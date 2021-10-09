package com.ruyuan.little.project.rocketmq.api.coupon.dto;

/**
 * Description： 用于获取MQ中关于用户第一次登录消息
 * Author: liujiao
 * Date: Created in 2021/10/9 18:07
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class FirstLoginMessageDTO {

    private Integer userId;

    private String nickName;

    private Integer beid;

    private String phoneNumber;

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

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
