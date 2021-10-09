package com.ruyuan.little.project.rocketmq.api.login.controller;

import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.rocketmq.api.login.dto.LoginRequestDTO;
import com.ruyuan.little.project.rocketmq.api.login.service.LoginService;
import com.ruyuan.little.project.rocketmq.api.login.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/9 16:52
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/wxLogin")
    public CommonResponse wxLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        //第一次到哪里发放优惠券
        loginService.firstLoginDistributeCoupon(loginRequestDTO);
        return CommonResponse.success();
    }

    @RequestMapping(value = "/resetLoginStatus")
    public CommonResponse wxLogin(@RequestParam(value = "phoneNumber") String phoneNumber) {
        loginService.resetFirstLoginStatus(phoneNumber);
        return CommonResponse.success();
    }

}
