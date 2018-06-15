package com.Travel.butler.service;

import com.Travel.butler.domain.ReleaseInfo;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ReleaseInfoService {

    public ReleaseInfo saveRelease(ReleaseInfo releaseInfo);

    public Page<ReleaseInfo> getReleaseListPageByParams(Map<String,Object> params);
}
