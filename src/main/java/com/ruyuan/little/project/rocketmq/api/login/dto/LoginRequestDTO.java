package com.ruyuan.little.project.rocketmq.api.login.dto;

import java.io.Serializable;

/**
 * Description： 用户登录实体类
 * Author: liujiao
 * Date: Created in 2021/10/9 16:25
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class LoginRequestDTO implements Serializable {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * token
     */
    private String token;

    /**
     * 小程序ID
     */
    private Integer beid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }
}
