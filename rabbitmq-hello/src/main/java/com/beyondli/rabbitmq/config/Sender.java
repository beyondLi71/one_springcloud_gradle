package com.beyondli.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by beyondLi
 * Date 2018/3/6
 * Desc .生产者
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello" + LocalDateTime.now();
        rabbitTemplate.convertAndSend("hello", context);
        System.out.println("send:" + context);
    }
}
