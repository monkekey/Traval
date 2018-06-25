package com.Travel.butler.service;

import com.Travel.butler.domain.Suggesstion;
import org.springframework.data.domain.Page;

public interface SuggesstionSerivce {

    public Page<Suggesstion> findSuggesstion(Integer pageIdx, Integer pageSize, String openid,Byte suggType, Integer flag);

    public Suggesstion save(Suggesstion suggesstion);

    public String updata(Suggesstion suggesstion);

    public String delete(String id);

}
