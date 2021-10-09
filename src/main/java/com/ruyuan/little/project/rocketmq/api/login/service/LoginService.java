package com.ruyuan.little.project.rocketmq.api.login.service;

import com.ruyuan.little.project.rocketmq.api.login.dto.LoginRequestDTO;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/9 16:34
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public interface LoginService {
    /**
     * 第一次登录分发优惠券
     * @param loginRequestDTO
     */
    void firstLoginDistributeCoupon(LoginRequestDTO loginRequestDTO);

    /**
     * 重置用户的登录状态
     * @param phoneNumber
     */
    void resetFirstLoginStatus(String phoneNumber);


}
