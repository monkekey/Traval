package com.Travel.butler.service;

import com.Travel.butler.domain.Reply;
import org.springframework.data.domain.Page;

public interface ReplyService {

    public Page<Reply> findReply(Integer pageIdx, Integer pageSize, String openid, String releaseId, Integer flag,String orderBy);

    public Reply save(Reply reply);

    public String updata(Reply reply);

    public String delete(String id);

}
