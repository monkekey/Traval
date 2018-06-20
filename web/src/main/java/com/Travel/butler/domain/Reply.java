package com.Travel.butler.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reply")
public class Reply {
    private String id;
    private String openid;
    private String releaseId;
    private String replyContent;
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
    @Column(name = "release_id", nullable = true, length = 32)
    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    @Basic
    @Column(name = "reply_content", nullable = true, length = 400)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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

        Reply reply = (Reply) o;

        if (id != null ? !id.equals(reply.id) : reply.id != null) return false;
        if (openid != null ? !openid.equals(reply.openid) : reply.openid != null) return false;
        if (releaseId != null ? !releaseId.equals(reply.releaseId) : reply.releaseId != null) return false;
        if (replyContent != null ? !replyContent.equals(reply.replyContent) : reply.replyContent != null) return false;
        if (createTime != null ? !createTime.equals(reply.createTime) : reply.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(reply.updateTime) : reply.updateTime != null) return false;
        return flag != null ? flag.equals(reply.flag) : reply.flag == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (releaseId != null ? releaseId.hashCode() : 0);
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
