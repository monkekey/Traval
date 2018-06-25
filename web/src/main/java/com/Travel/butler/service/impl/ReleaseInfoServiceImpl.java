package com.Travel.butler.service.impl;

import com.Travel.butler.domain.ReleaseInfo;
import com.Travel.butler.domain.ReleaseInfoRepository;
import com.Travel.butler.service.ReleaseInfoService;
import com.Travel.butler.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReleaseInfoServiceImpl implements ReleaseInfoService {

    @Autowired
    private ReleaseInfoRepository releaseInfoRepository;

    @Override
    public ReleaseInfo saveRelease(ReleaseInfo releaseInfo){
        String id = releaseInfo.getId();
        //有id为修改，无id为新增
        if(id == null || "".equals(id)){
            id = UUIDUtil.getUidByPrefix("REL",8);
            releaseInfo.setId(id);
            releaseInfo.setCreateTime(new Date());
            releaseInfo.setIsReview(new Byte("0"));
            releaseInfoRepository.saveAndFlush(releaseInfo);
        }else{
            releaseInfo.setUpdateTime(new Date());
            releaseInfoRepository.saveAndFlush(releaseInfo);
        }

        return releaseInfo;
    }

    @Override
    public Page<ReleaseInfo> getReleaseListPageByParams(Map<String, Object> params) {
        Integer curPage = Integer.valueOf(params.get("curPage").toString());
        Integer pageSize = Integer.valueOf(params.get("pageSize").toString());
        Pageable page = new PageRequest(curPage,pageSize,Sort.Direction.DESC,"create_time");
        Page<ReleaseInfo> result = releaseInfoRepository.findAll(page);
        return result;
    }


}
