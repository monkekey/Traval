package com.Travel.butler.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cash_record", schema = "TravalTips", catalog = "")
public class CashRecord {
    private String id;
    private String openid;
    private Integer cashMoney;
    private Byte isSuccess;
    private Date createTime;
    private Date upDateTime;

    @Id
    @Column(name = "id", nullable = false, length = 32)
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
    @Column(name = "cash_money", nullable = true, precision = 0)
    public Integer getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(Integer cashMoney) {
        this.cashMoney = cashMoney;
    }

    @Basic
    @Column(name = "is_success", nullable = true)
    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
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
    @Column(name = "upDate_time", nullable = true)
    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashRecord that = (CashRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (cashMoney != null ? !cashMoney.equals(that.cashMoney) : that.cashMoney != null) return false;
        if (isSuccess != null ? !isSuccess.equals(that.isSuccess) : that.isSuccess != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (upDateTime != null ? !upDateTime.equals(that.upDateTime) : that.upDateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (cashMoney != null ? cashMoney.hashCode() : 0);
        result = 31 * result + (isSuccess != null ? isSuccess.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (upDateTime != null ? upDateTime.hashCode() : 0);
        return result;
    }
}
