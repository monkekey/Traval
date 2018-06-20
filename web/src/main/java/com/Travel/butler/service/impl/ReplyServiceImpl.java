package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.CashRecord;
import com.Travel.butler.domain.IReplyDao;
import com.Travel.butler.domain.IReplyRepostiory;
import com.Travel.butler.domain.Reply;
import com.Travel.butler.service.ReplyService;
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
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private IReplyDao replyDao;
    @Autowired
    private IReplyRepostiory replyRepostiory;

    @Override
    public Page<Reply> findReply(Integer pageIdx, Integer pageSize, String openid, String releaseId, Integer flag, String orderBy) {

        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, orderBy);

        Specification<Reply> spec = new Specification<Reply>() {
            public Predicate toPredicate(Root<Reply> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), flag);
                predicates.add(p);

                if(!StringUtils.isEmpty(openid)){
                    p = cb.equal(root.get("openid").as(String.class), openid);
                    predicates.add(p);
                }

                if(!StringUtils.isEmpty(releaseId)){
                    p = cb.equal(root.get("releaseId").as(Date.class), releaseId);
                    predicates.add(p);
                }

                Predicate[] props = new Predicate[predicates.size()];
                predicates.toArray(props);
                query.where(props);
                return query.getRestriction();
            }
        };

        Page<Reply> replyPage =  replyDao.findAll(spec,pageable);

        return replyPage;

    }

    @Override
    public Reply save(Reply reply) {
        String id = UUIDUtil.getUidByPrefix("reply",8);
        reply.setId(id);
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
        reply.setFlag(CommonFlag.VALID.getValue());
        Reply new_reply = replyRepostiory.saveAndFlush(reply);
        return new_reply;
    }

    @Override
    public String updata(Reply reply) {
        Reply old_reply = replyRepostiory.findOne(reply.getId());
        if(old_reply == null){
            return "更新失败，无该数据";
        }

        Reply new_reply = reply;
        new_reply.setUpdateTime(new Date());
        replyRepostiory.saveAndFlush(new_reply);

        return "ok";
    }

    @Override
    public String delete(String id) {
        Reply old_reply = replyRepostiory.findOne(id);
        if(old_reply == null){
            return "删除失败，无该数据";
        }
        old_reply.setUpdateTime(new Date());
        old_reply.setFlag(CommonFlag.DELETED.getValue());
        replyRepostiory.saveAndFlush(old_reply);

        return "ok";
    }
}
