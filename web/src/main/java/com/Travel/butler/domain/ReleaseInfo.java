package com.Travel.butler.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "release_info", schema = "TravalTips", catalog = "")
public class ReleaseInfo {
    private String id;
    private String openid;
    private String title;
    private String province;
    private String city;
    private String area;
    private String detailAddr;
    private String startAddr;
    private String passAddr;
    private String content;
    private Byte helpType;
    private Integer rewardMoney;
    private Byte isReward;
    private Byte releaseType;
    private String attachment;
    private String contactPhone;
    private Byte isReview;
    private Date createTime;
    private Date updateTime;

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
    @Column(name = "title", nullable = true, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 50)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "area", nullable = true, length = 100)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "detail_addr", nullable = true, length = 400)
    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    @Basic
    @Column(name = "start_addr", nullable = true, length = 400)
    public String getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr;
    }

    @Basic
    @Column(name = "pass_addr", nullable = true, length = 5000)
    public String getPassAddr() {
        return passAddr;
    }

    public void setPassAddr(String passAddr) {
        this.passAddr = passAddr;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "help_type", nullable = true)
    public Byte getHelpType() {
        return helpType;
    }

    public void setHelpType(Byte helpType) {
        this.helpType = helpType;
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
    @Column(name = "is_reward", nullable = true)
    public Byte getIsReward() {
        return isReward;
    }

    public void setIsReward(Byte isReward) {
        this.isReward = isReward;
    }

    @Basic
    @Column(name = "release_type", nullable = true)
    public Byte getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Byte releaseType) {
        this.releaseType = releaseType;
    }

    @Basic
    @Column(name = "attachment", nullable = true, length = 1000)
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Basic
    @Column(name = "contact_phone", nullable = true, length = 12)
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Basic
    @Column(name = "is_review", nullable = true)
    public Byte getIsReview() {
        return isReview;
    }

    public void setIsReview(Byte isReview) {
        this.isReview = isReview;
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

        ReleaseInfo that = (ReleaseInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (detailAddr != null ? !detailAddr.equals(that.detailAddr) : that.detailAddr != null) return false;
        if (startAddr != null ? !startAddr.equals(that.startAddr) : that.startAddr != null) return false;
        if (passAddr != null ? !passAddr.equals(that.passAddr) : that.passAddr != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (helpType != null ? !helpType.equals(that.helpType) : that.helpType != null) return false;
        if (rewardMoney != null ? !rewardMoney.equals(that.rewardMoney) : that.rewardMoney != null) return false;
        if (isReward != null ? !isReward.equals(that.isReward) : that.isReward != null) return false;
        if (releaseType != null ? !releaseType.equals(that.releaseType) : that.releaseType != null) return false;
        if (attachment != null ? !attachment.equals(that.attachment) : that.attachment != null) return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        if (isReview != null ? !isReview.equals(that.isReview) : that.isReview != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (detailAddr != null ? detailAddr.hashCode() : 0);
        result = 31 * result + (startAddr != null ? startAddr.hashCode() : 0);
        result = 31 * result + (passAddr != null ? passAddr.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (helpType != null ? helpType.hashCode() : 0);
        result = 31 * result + (rewardMoney != null ? rewardMoney.hashCode() : 0);
        result = 31 * result + (isReward != null ? isReward.hashCode() : 0);
        result = 31 * result + (releaseType != null ? releaseType.hashCode() : 0);
        result = 31 * result + (attachment != null ? attachment.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (isReview != null ? isReview.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
