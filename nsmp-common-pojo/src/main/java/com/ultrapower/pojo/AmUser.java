package com.ultrapower.pojo;

import java.util.Date;

public class AmUser {
    private String pkNsmpUser;

    private String userAccount;

    private String userPassword;

    private Date createTime;

    private Short comeFrom;

    public String getPkNsmpUser() {
        return pkNsmpUser;
    }

    public void setPkNsmpUser(String pkNsmpUser) {
        this.pkNsmpUser = pkNsmpUser == null ? null : pkNsmpUser.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(Short comeFrom) {
        this.comeFrom = comeFrom;
    }
}