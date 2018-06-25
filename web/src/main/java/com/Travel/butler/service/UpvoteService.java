package com.Travel.butler.service;

import com.Travel.butler.domain.Upvote;
import org.springframework.data.domain.Page;

public interface UpvoteService {

    public Page<Upvote> findUpvote(Integer pageIdx, Integer pageSize, String openid, Integer flag);

    public Upvote save(Upvote upvote);

    public String updata(Upvote upvote);

    public String delete(String id);

}
