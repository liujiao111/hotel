package com.ruyuan.little.project.rocketmq.api.hotel.dto;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:18
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class HotelRoomMessage {

    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 手机号
     */
    private String phoneNumber;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
