package com.Travel.butler.service.impl;

import com.Travel.butler.domain.IInnRepository;
import com.Travel.butler.service.InnService;
import com.Travel.butler.vo.InnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2018/1/3.
 */
@Service
public class InnServiceImpl implements InnService {
    @Autowired
    private IInnRepository innRepository;

    public List<InnVo> findValidInn() {
        return innRepository.findValidInn();
    }
}
