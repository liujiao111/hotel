package com.ruyuan.little.project.rocketmq.api.login.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;

/**
 * Description： TODO
 * Author: liujiao
 * Date: Created in 2021/10/9 16:29
 * email: liujiao@fcbox.com
 * Version: 0.0.1
 */
@Configuration
public class LoginProducerConfiguration {

    @Value("${rocketmq.namesrv.address}")
    private String namesrvAddress;

    @Value("${rocketmq.login.producer.group}")
    private String loginProducerGroup;

    /**
     * 登录生产者
     * @return 登录消息rocketmq的生产者对象
     * @throws MQClientException
     */
    @Bean(value = "loginMqProducer")
    public DefaultMQProducer loginProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(loginProducerGroup);
        producer.setNamesrvAddr(namesrvAddress);
        producer.start();
        return producer;
    }
















}
