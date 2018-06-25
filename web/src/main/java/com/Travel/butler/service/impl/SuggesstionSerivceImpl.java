package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.ISuggesstionDao;
import com.Travel.butler.domain.ISuggesstionRepository;
import com.Travel.butler.domain.Suggesstion;
import com.Travel.butler.service.SuggesstionSerivce;
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
public class SuggesstionSerivceImpl implements SuggesstionSerivce {

    @Autowired
    private ISuggesstionDao suggesstionDao;
    @Autowired
    private ISuggesstionRepository suggesstionRepository;

    @Override
    public Page<Suggesstion> findSuggesstion(Integer pageIdx, Integer pageSize, String openid, Byte suggType, Integer flag) {
        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, "id");

        Specification<Suggesstion> spec = new Specification<Suggesstion>() {
            public Predicate toPredicate(Root<Suggesstion> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), flag);
                predicates.add(p);

                p = cb.equal(root.get("suggType").as(String.class), suggType);
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

        Page<Suggesstion> suggesstions =  suggesstionDao.findAll(spec,pageable);

        return suggesstions;
    }

    @Override
    public Suggesstion save(Suggesstion suggesstion) {

        String id = UUIDUtil.getUidByPrefix("SUG",8);
        suggesstion.setId(id);
        suggesstion.setCreateTime(new Date());
        suggesstion.setUpdateTime(new Date());
        suggesstion.setFlag(CommonFlag.VALID.getValue());

        Suggesstion new_suggesstion = suggesstionRepository.saveAndFlush(suggesstion);

        return new_suggesstion;

    }

    @Override
    public String updata(Suggesstion suggesstion) {

        Suggesstion old_suggesstion = suggesstionRepository.findOne(suggesstion.getId());
        if(old_suggesstion == null){
            return "更新失败，无此记录！";
        }

        Suggesstion new_suggesstion = new Suggesstion();
        new_suggesstion = old_suggesstion;
        new_suggesstion.setUpdateTime(new Date());
        suggesstionRepository.saveAndFlush(new_suggesstion);

        return "ok";

    }

    @Override
    public String delete(String id) {

        Suggesstion old_suggesstion = suggesstionRepository.findOne(id);
        if(old_suggesstion == null){
            return "删除失败，无此记录！";
        }

        old_suggesstion.setUpdateTime(new Date());
        old_suggesstion.setFlag(CommonFlag.DELETED.getValue());
        suggesstionRepository.saveAndFlush(old_suggesstion);

        return "ok";

    }
}
