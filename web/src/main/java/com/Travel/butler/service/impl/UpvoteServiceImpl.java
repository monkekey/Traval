package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.IUpvoteDao;
import com.Travel.butler.domain.IUpvoteRepostiory;
import com.Travel.butler.domain.RewardRecord;
import com.Travel.butler.domain.Upvote;
import com.Travel.butler.service.UpvoteService;
import com.Travel.butler.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpvoteServiceImpl implements UpvoteService {

    @Autowired
    private IUpvoteDao upvoteDao;
    @Autowired
    private IUpvoteRepostiory upvoteRepostiory;

    @Override
    public Page<Upvote> findUpvote(Integer pageIdx, Integer pageSize, String openid, Integer flag) {
        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, "id");

        Specification<Upvote> spec = new Specification<Upvote>() {
            public Predicate toPredicate(Root<Upvote> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), flag);
                predicates.add(p);

                if(!StringUtils.isEmpty(openid)){
                    p = cb.equal(root.get("openid").as(Date.class), openid);
                    predicates.add(p);
                }

                Predicate[] props = new Predicate[predicates.size()];
                predicates.toArray(props);
                query.where(props);
                return query.getRestriction();
            }
        };

        Page<Upvote> upvotePage =  upvoteDao.findAll(spec,pageable);

        return upvotePage;
    }

    @Override
    public Upvote save(Upvote upvote) {
        String id = UUIDUtil.getUidByPrefix("UP",8);
        upvote.setId(id);
        upvote.setCreateTime(new Date());
        upvote.setUpdateTime(new Date());
        upvote.setFlag(CommonFlag.VALID.getValue());

        Upvote new_upvote = upvoteRepostiory.saveAndFlush(upvote);

        return new_upvote;
    }

    @Override
    public String updata(Upvote upvote) {

        Upvote old_upvote = upvoteRepostiory.findOne(upvote.getId());
        if(old_upvote == null){
            return "更新失败，无此记录！";
        }

        Upvote new_upvote = new Upvote();
        new_upvote = old_upvote;
        new_upvote.setUpdateTime(new Date());
        upvoteRepostiory.saveAndFlush(new_upvote);

        return "ok";

    }

    @Override
    public String delete(String id) {

        Upvote old_upvote = upvoteRepostiory.findOne(id);
        if(old_upvote == null){
            return "删除失败，无此记录！";
        }

        old_upvote.setUpdateTime(new Date());
        old_upvote.setFlag(CommonFlag.DELETED.getValue());
        upvoteRepostiory.saveAndFlush(old_upvote);

        return "ok";

    }
}
