package com.Travel.butler.service;

import com.Travel.butler.vo.InnVo;

import java.util.List;

/**
 * Created by zy on 2018/1/3.
 */
public interface InnService {

    public List<InnVo> findValidInn();
}
