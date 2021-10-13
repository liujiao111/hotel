package com.ruyuan.little.project.rocketmq.api.hotel.dto;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:16
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class RoomDescription {

    /**
     * 面积
     */
    private String area;

    /**
     * 宽高
     */
    private String bed;

    /**
     * 早餐的份数
     */
    private Integer breakfast;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }
}
