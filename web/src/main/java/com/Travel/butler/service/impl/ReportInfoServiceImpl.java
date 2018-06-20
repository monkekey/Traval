package com.Travel.butler.service.impl;

import com.Travel.butler.constant.CommonFlag;
import com.Travel.butler.domain.*;
import com.Travel.butler.service.ReportInfoService;
import com.Travel.butler.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportInfoServiceImpl implements ReportInfoService {

    @Autowired
    private IReportInfoDao reportInfoDao;
    @Autowired
    private IReportInfoRepository reportInfoRepository;

    @Override
    public Page<ReportInfo> findReportInfo(Integer pageIdx, Integer pageSize, String orderBy, ReportInfo reportInfo) {

        Pageable pageable = new PageRequest(pageIdx, pageSize, Sort.Direction.DESC, orderBy);

        Specification<ReportInfo> spec = new Specification<ReportInfo>() {
            public Predicate toPredicate(Root<ReportInfo> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Predicate p = cb.equal(root.get("flag").as(Integer.class), reportInfo.getFlag());
                predicates.add(p);

                if(!StringUtils.isEmpty(reportInfo.getOpenid())){
                    p = cb.equal(root.get("openid").as(String.class), reportInfo.getOpenid());
                    predicates.add(p);
                }

                if(!StringUtils.isEmpty(reportInfo.getReportOpenid())){
                    p = cb.equal(root.get("reportOpenid").as(Date.class), reportInfo.getReportOpenid());
                    predicates.add(p);
                }

                if(!StringUtils.isEmpty(reportInfo.getReportId())){
                    p = cb.equal(root.get("reportId").as(Date.class), reportInfo.getReportId());
                    predicates.add(p);
                }

                Predicate[] props = new Predicate[predicates.size()];
                predicates.toArray(props);
                query.where(props);
                return query.getRestriction();
            }
        };

        Page<ReportInfo> reportInfoPage =  reportInfoDao.findAll(spec,pageable);

        return reportInfoPage;

    }

    @Override
    public ReportInfo save(ReportInfo reportInfo) {

        String id = UUIDUtil.getUidByPrefix("report",8);
        reportInfo.setId(id);
        reportInfo.setCreateTime(new Date());
        reportInfo.setUpdateTime(new Date());
        reportInfo.setFlag(CommonFlag.VALID.getValue());
        ReportInfo new_reportInfo = new ReportInfo();
        new_reportInfo = reportInfoRepository.saveAndFlush(reportInfo);

        return new_reportInfo;
    }

    @Override
    public String updata(ReportInfo reportInfo) {

        ReportInfo old_reportInfo = reportInfoRepository.findOne(reportInfo.getId());
        if(old_reportInfo == null){
            return "更新失败，无该记录！";
        }
        old_reportInfo.setUpdateTime(new Date());
        reportInfoRepository.saveAndFlush(old_reportInfo);

        return "ok";
    }

    @Override
    public String delete(String id) {
        ReportInfo old_reportInfo = reportInfoRepository.findOne(id);
        if(old_reportInfo == null){
            return "删除失败，无该记录！";
        }
        old_reportInfo.setUpdateTime(new Date());
        old_reportInfo.setFlag(CommonFlag.DELETED.getValue());
        reportInfoRepository.saveAndFlush(old_reportInfo);

        return "ok";
    }
}
