package com.Travel.butler.domain;

import javax.persistence.*;

@Entity
@Table(name = "config")
public class Config {
    private String id;
    private String miniAppId;
    private String miniAppKey;
    private String pubNumAppId;
    private String pubNumKey;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mini_app_id", nullable = true, length = 32)
    public String getMiniAppId() {
        return miniAppId;
    }

    public void setMiniAppId(String miniAppId) {
        this.miniAppId = miniAppId;
    }

    @Basic
    @Column(name = "mini_app_key", nullable = true, length = 50)
    public String getMiniAppKey() {
        return miniAppKey;
    }

    public void setMiniAppKey(String miniAppKey) {
        this.miniAppKey = miniAppKey;
    }

    @Basic
    @Column(name = "pub_num_app_id", nullable = true, length = 32)
    public String getPubNumAppId() {
        return pubNumAppId;
    }

    public void setPubNumAppId(String pubNumAppId) {
        this.pubNumAppId = pubNumAppId;
    }

    @Basic
    @Column(name = "pub_num_key", nullable = true, length = 50)
    public String getPubNumKey() {
        return pubNumKey;
    }

    public void setPubNumKey(String pubNumKey) {
        this.pubNumKey = pubNumKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Config config = (Config) o;

        if (id != null ? !id.equals(config.id) : config.id != null) return false;
        if (miniAppId != null ? !miniAppId.equals(config.miniAppId) : config.miniAppId != null) return false;
        if (miniAppKey != null ? !miniAppKey.equals(config.miniAppKey) : config.miniAppKey != null) return false;
        if (pubNumAppId != null ? !pubNumAppId.equals(config.pubNumAppId) : config.pubNumAppId != null) return false;
        if (pubNumKey != null ? !pubNumKey.equals(config.pubNumKey) : config.pubNumKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (miniAppId != null ? miniAppId.hashCode() : 0);
        result = 31 * result + (miniAppKey != null ? miniAppKey.hashCode() : 0);
        result = 31 * result + (pubNumAppId != null ? pubNumAppId.hashCode() : 0);
        result = 31 * result + (pubNumKey != null ? pubNumKey.hashCode() : 0);
        return result;
    }
}
