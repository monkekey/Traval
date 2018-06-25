package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.CashRecord;
import com.Travel.butler.domain.IRewardRecordDao;
import com.Travel.butler.domain.IRewardRecordRepository;
import com.Travel.butler.domain.RewardRecord;
import com.Travel.butler.service.RewardRecordService;
import com.Travel.butler.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.smartcardio.CommandAPDU;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RewardRecordServiceImpl implements RewardRecordService {

    @Autowired
    private IRewardRecordRepository rewardRecordRepository;
    @Autowired
    private IRewardRecordDao rewardRecordDao;

    @Override
    public Page<RewardRecord> findRewardRecord(Integer pageIdx, Integer pageSize, String createTime, Integer isPay, Integer flag) {
        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, "id");

        Specification<RewardRecord> spec = new Specification<RewardRecord>() {
            public Predicate toPredicate(Root<RewardRecord> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), flag);
                predicates.add(p);

                p = cb.equal(root.get("isPay").as(String.class), isPay);
                predicates.add(p);

                if(!StringUtils.isEmpty(createTime)){
                    p = cb.equal(root.get("createTime").as(Date.class), createTime);
                    predicates.add(p);
                }

                Predicate[] props = new Predicate[predicates.size()];
                predicates.toArray(props);
                query.where(props);
                return query.getRestriction();
            }
        };

        Page<RewardRecord> cashRecords =  rewardRecordDao.findAll(spec,pageable);

        return cashRecords;
    }

    @Override
    public RewardRecord save(RewardRecord rewardRecord) {

        String id = UUIDUtil.getUidByPrefix("RR",8);
        rewardRecord.setId(id);
        rewardRecord.setCreateTime(new Date());
        rewardRecord.setUpdateTime(new Date());
        rewardRecord.setFlag(CommonFlag.VALID.getValue());

        RewardRecord new_rewardRecord = rewardRecordRepository.saveAndFlush(rewardRecord);

        return new_rewardRecord;
    }

    @Override
    public String updata(RewardRecord rewardRecord) {

        RewardRecord old_rewardRecord = rewardRecordRepository.findOne(rewardRecord.getId());
        if(old_rewardRecord == null){
            return "更新失败，无此记录！";
        }

        RewardRecord new_rewardRecord = new RewardRecord();
        new_rewardRecord = old_rewardRecord;
        new_rewardRecord.setUpdateTime(new Date());
        rewardRecordRepository.saveAndFlush(new_rewardRecord);

        return "ok";

    }

    @Override
    public String delete(String id) {
        RewardRecord old_rewardRecord = rewardRecordRepository.findOne(id);
        if(old_rewardRecord == null){
            return "删除失败，无此记录！";
        }

        old_rewardRecord.setUpdateTime(new Date());
        old_rewardRecord.setFlag(CommonFlag.DELETED.getValue());
        rewardRecordRepository.saveAndFlush(old_rewardRecord);

        return "ok";
    }
}
