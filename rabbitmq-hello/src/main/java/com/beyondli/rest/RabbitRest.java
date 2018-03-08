package com.beyondli.rest;

import com.beyondli.rabbitmq.config.Sender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/3/6
 * Desc .
 */
@RestController
public class RabbitRest {
    @Resource
    private Sender sender;

    @RequestMapping(value = "/sender", method = RequestMethod.GET)
    public void hello() {
        sender.send();
    }
}
