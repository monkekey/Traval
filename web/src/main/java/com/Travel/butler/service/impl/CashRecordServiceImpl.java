package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.CashRecord;
import com.Travel.butler.domain.ICashRecordDao;
import com.Travel.butler.domain.ICashRecordRepository;
import com.Travel.butler.service.CashRecordService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CashRecordServiceImpl implements CashRecordService {

    @Autowired
    private ICashRecordDao cashRecordDao;
    @Autowired
    private ICashRecordRepository cashRecordRepository;

    public Page<CashRecord> findCashRecord(Integer pageIdx,Integer pageSize,String createTime, Integer success, Integer flag) {

        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, "id");

        Specification<CashRecord> spec = new Specification<CashRecord>() {
            public Predicate toPredicate(Root<CashRecord> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), flag);
                predicates.add(p);

                p = cb.equal(root.get("isSuccess").as(String.class), success);
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

        Page<CashRecord> cashRecords =  cashRecordDao.findAll(spec,pageable);

        return cashRecords;
    }

    public CashRecord save(CashRecord cashRecord) {
        String id = UUIDUtil.getUidByPrefix("CR",8);
        cashRecord.setId(id);
        cashRecord.setCreateTime(new Date());
        cashRecord.setFlag(CommonFlag.VALID.getValue());
        CashRecord new_cashRecord = new CashRecord();
        new_cashRecord = cashRecordRepository.saveAndFlush(cashRecord);
        return new_cashRecord;
    }

    public String updata(CashRecord cashRecord) {
        CashRecord old_cashRecord = cashRecordRepository.findOne(cashRecord.getId());
        if(old_cashRecord == null){
            return "更新失败，无此记录！";
        }

        CashRecord new_cashRecord = new CashRecord();
        new_cashRecord = old_cashRecord;
        new_cashRecord.setUpDateTime(new Date());
        cashRecordRepository.saveAndFlush(new_cashRecord);

        return "ok";
    }

    public String delete(String id) {
        CashRecord old_cashRecord = cashRecordRepository.findOne(id);
        if(old_cashRecord == null){
            return "删除失败，无此记录！";
        }

        old_cashRecord.setUpDateTime(new Date());
        old_cashRecord.setFlag(CommonFlag.DELETED.getValue());
        cashRecordRepository.saveAndFlush(old_cashRecord);

        return "ok";
    }
}
