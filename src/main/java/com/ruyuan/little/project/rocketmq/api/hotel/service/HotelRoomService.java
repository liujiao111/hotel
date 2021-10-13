package com.ruyuan.little.project.rocketmq.api.hotel.service;

import com.ruyuan.little.project.common.dto.CommonResponse;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:20
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public interface HotelRoomService {

    /**
     * 查询房间详情
     * @param id
     * @param phoneNumber
     * @return
     */
    public CommonResponse getRoomById(Long id, String phoneNumber);
}
