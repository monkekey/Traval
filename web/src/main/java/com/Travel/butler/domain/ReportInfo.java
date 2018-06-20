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
    private Integer flag;

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

    @Basic
    @Column(name = "flag", nullable = true)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportInfo that = (ReportInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (reportOpenid != null ? !reportOpenid.equals(that.reportOpenid) : that.reportOpenid != null) return false;
        if (reportId != null ? !reportId.equals(that.reportId) : that.reportId != null) return false;
        if (reportType != null ? !reportType.equals(that.reportType) : that.reportType != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        return flag != null ? flag.equals(that.flag) : that.flag == null;
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
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
