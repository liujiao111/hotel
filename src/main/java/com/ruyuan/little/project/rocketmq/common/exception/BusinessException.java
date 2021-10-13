package com.ruyuan.little.project.rocketmq.common.exception;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/12 18:36
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
