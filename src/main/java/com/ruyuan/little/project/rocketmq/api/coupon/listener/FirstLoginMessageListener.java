package com.ruyuan.little.project.rocketmq.api.coupon.listener;

import com.alibaba.fastjson.JSON;
import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.common.enums.ErrorCodeEnum;
import com.ruyuan.little.project.common.enums.LittleProjectTypeEnum;
import com.ruyuan.little.project.redis.api.RedisApi;
import com.ruyuan.little.project.rocketmq.api.coupon.dto.FirstLoginMessageDTO;
import com.ruyuan.little.project.rocketmq.api.coupon.service.CouponService;
import com.ruyuan.little.project.rocketmq.common.constants.RedisKeyConstant;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/9 18:12
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */@Component
public class FirstLoginMessageListener implements MessageListenerConcurrently {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstLoginMessageListener.class);

    /**
     * redis dubbo服务
     */
    @Reference(version = "1.0.0",
            interfaceClass = RedisApi.class,
            cluster = "failfast")
    private RedisApi redisApi;

    /**
     * 优惠券服务service组件
     */
    @Autowired
    private CouponService couponService;

    /**
     * 第一次登陆下发的优惠券id
     */
    @Value("${first.login.couponId}")
    private Integer firstLoginCouponId;

    /**
     * 第一次登陆优惠券有效天数
     */
    @Value("${first.login.coupon.day}")
    private Integer firstLoginCouponDay;


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        for (MessageExt messageExt : list) {
            String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
            Integer userId = null;
            String phoneNumber = null;
            try {
                LOGGER.info("received login success messageL=:{}", body);
                FirstLoginMessageDTO firstLoginMessageDTO = JSON.parseObject(body, FirstLoginMessageDTO.class);

                userId = firstLoginMessageDTO.getUserId();

                phoneNumber = firstLoginMessageDTO.getPhoneNumber();

                CommonResponse<Boolean> response = redisApi.setnx(RedisKeyConstant.FIRST_LOGIN_DUPLICATION_KEY_PREFIX + userId,
                        String.valueOf(userId),
                        phoneNumber,
                        LittleProjectTypeEnum.ROCKETMQ
                );

                if(Objects.equals(response.getCode(), ErrorCodeEnum.FAIL)) {
                    //Redis操作失败，返回RECONSUME_LATER ， 后续MQ会重新投递该消息
                    LOGGER.info("consumer first login message redis dubbo interface fail userId:{}", userId);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                if(Objects.equals(response.getCode(), ErrorCodeEnum.SUCCESS)
                        && Objects.equals(response.getData(), Boolean.FALSE)) {
                    //重复消费
                    LOGGER.info("duplicate consumer first login message userId:{}", userId);
                } else {
                    //未重复消费，发放优惠券
                    //给用户发放优惠券
                    couponService.distributeCoupon(firstLoginMessageDTO.getBeid(),
                            userId,
                            firstLoginCouponId,
                            firstLoginCouponDay,
                            0,
                            phoneNumber
                    );
                    LOGGER.info("distribute userId:{} first login coupon end", userId);
                }
            } catch (Exception e) {
                //消费失败，删除Redis中的标记
                LOGGER.info("received login success message:{}, consumer fail", body);
                if (userId != null) {
                    redisApi.del(RedisKeyConstant.FIRST_LOGIN_DUPLICATION_KEY_PREFIX + userId,
                            phoneNumber,
                            LittleProjectTypeEnum.ROCKETMQ);
                }
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        //返回消费成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
