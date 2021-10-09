package com.ruyuan.little.project.rocketmq.api;

import com.ruyuan.little.project.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/8 17:09
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
@RestController
public class HealthController {

    @RequestMapping("/")
    public CommonResponse health() {
        return CommonResponse.success();
    }
}
