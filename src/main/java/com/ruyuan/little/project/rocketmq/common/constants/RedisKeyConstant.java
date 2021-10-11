package com.ruyuan.little.project.rocketmq.common.constants;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/11 19:00
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class RedisKeyConstant {

    /**
     * 第一次登陆重复消费 保证幂等的key前缀
     */
    public static final String FIRST_LOGIN_DUPLICATION_KEY_PREFIX = "little:project:firstLoginDuplication:";


    /**
     * 酒店房间key的前缀
     */
    public static final String HOTEL_ROOM_KEY_PREFIX = "little:project:hotelRoom:";
}
