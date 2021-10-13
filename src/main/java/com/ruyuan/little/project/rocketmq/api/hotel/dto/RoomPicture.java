package com.ruyuan.little.project.rocketmq.api.hotel.dto;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:18
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class RoomPicture {

    /**
     * 图片id
     */
    private Integer id;

    /**
     * 图片地址
     */
    private String url;

    private String src;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
