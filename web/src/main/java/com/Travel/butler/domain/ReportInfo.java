package com.Travel.butler.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report_info")
public class ReportInfo {
    private String id;
    private String openid;
    private String reportOpenid;
    private String reportId;
    private Byte reportType;
    private Date createTime;
    private Date updateTime;

    @Id
    @Column(name = "id", nullable = true, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "openid", nullable = true, length = 32)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "report_openid", nullable = true, length = 32)
    public String getReportOpenid() {
        return reportOpenid;
    }

    public void setReportOpenid(String reportOpenid) {
        this.reportOpenid = reportOpenid;
    }

    @Basic
    @Column(name = "report_id", nullable = true, length = 32)
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "report_type", nullable = true)
    public Byte getReportType() {
        return reportType;
    }

    public void setReportType(Byte reportType) {
        this.reportType = reportType;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportInfo report = (ReportInfo) o;

        if (id != null ? !id.equals(report.id) : report.id != null) return false;
        if (openid != null ? !openid.equals(report.openid) : report.openid != null) return false;
        if (reportOpenid != null ? !reportOpenid.equals(report.reportOpenid) : report.reportOpenid != null)
            return false;
        if (reportId != null ? !reportId.equals(report.reportId) : report.reportId != null) return false;
        if (reportType != null ? !reportType.equals(report.reportType) : report.reportType != null) return false;
        if (createTime != null ? !createTime.equals(report.createTime) : report.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(report.updateTime) : report.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (reportOpenid != null ? reportOpenid.hashCode() : 0);
        result = 31 * result + (reportId != null ? reportId.hashCode() : 0);
        result = 31 * result + (reportType != null ? reportType.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
