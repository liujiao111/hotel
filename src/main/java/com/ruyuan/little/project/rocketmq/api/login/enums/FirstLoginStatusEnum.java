package com.ruyuan.little.project.rocketmq.api.login.enums;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/9 16:42
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public enum FirstLoginStatusEnum {
    YES(1, "未登录过"),

    NO(2, "已登录过");

    private Integer status;

    private String desc;

    FirstLoginStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
