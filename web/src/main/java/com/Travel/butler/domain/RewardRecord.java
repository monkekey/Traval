package com.Travel.butler.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reward_record", schema = "TravalTips", catalog = "")
public class RewardRecord {
    private String id;
    private String openid;
    private Integer rewardMoney;
    private Byte isPay;
    private Date createTime;
    private Date updateTime;
    private Integer flag;

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
    @Column(name = "reward_money", nullable = true, precision = 0)
    public Integer getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(Integer rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    @Basic
    @Column(name = "is_pay", nullable = true)
    public Byte getIsPay() {
        return isPay;
    }

    public void setIsPay(Byte isPay) {
        this.isPay = isPay;
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

        RewardRecord that = (RewardRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (rewardMoney != null ? !rewardMoney.equals(that.rewardMoney) : that.rewardMoney != null) return false;
        if (isPay != null ? !isPay.equals(that.isPay) : that.isPay != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        return flag != null ? flag.equals(that.flag) : that.flag == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (rewardMoney != null ? rewardMoney.hashCode() : 0);
        result = 31 * result + (isPay != null ? isPay.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
