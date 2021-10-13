package com.ruyuan.little.project.rocketmq.api.hotel.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.rocketmq.api.hotel.dto.HotelRoom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:23
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class HotelRoomCacheManager {

    /**
     * 酒店房间jvm缓存
     * TODO 防止oom可以通过google Guava Cache改造
     */
    private ConcurrentHashMap<Long, HotelRoom> hotelRoomConcurrentHashMap = new ConcurrentHashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelRoomCacheManager.class);

    public void updateLocalCache(HotelRoom hotelRoom) {
        hotelRoomConcurrentHashMap.put(hotelRoom.getId(), hotelRoom);
        LOGGER.info("hotel room local cache data:{}", JSON.toJSONString(hotelRoom));
    }

    /**
     * 根据房间ID获取房间JVM内存信息
     * @param id
     * @return
     */
    public HotelRoom getHotelRoomFromLocalCache(Long id) {
        return hotelRoomConcurrentHashMap.get(id);
    }
}
