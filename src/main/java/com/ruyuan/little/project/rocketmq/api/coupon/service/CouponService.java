package com.ruyuan.little.project.rocketmq.api.coupon.service;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/11 16:58
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public interface CouponService {

    /**
     * 给用户发放优惠券
     * @param beid
     * @param userId
     * @param couponConfigId
     * @param validDay
     * @param sourceOrderId
     * @param phoneNumber
     */
    void distributeCoupon(Integer beid,Integer userId, Integer couponConfigId, Integer validDay, Integer sourceOrderId, String phoneNumber);

}
