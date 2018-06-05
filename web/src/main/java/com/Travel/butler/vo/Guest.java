package com.Travel.butler.vo;


public class Guest {
    private String openid;
    private String userName;

    public Guest(String openid, String userName) {
        this.openid = openid;
        this.userName = userName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
