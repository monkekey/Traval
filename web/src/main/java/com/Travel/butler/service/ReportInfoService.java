package com.Travel.butler.service;

import com.Travel.butler.domain.ReportInfo;
import org.springframework.data.domain.Page;

public interface ReportInfoService {

    public Page<ReportInfo> findReportInfo(Integer pageIdx, Integer pageSize, String orderBy,ReportInfo reportInfo);

    public ReportInfo save(ReportInfo reportInfo);

    public String updata(ReportInfo reportInfo);

    public String delete(String id);

}
