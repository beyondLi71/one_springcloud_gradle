package com.beyondli.rest;

import com.beyondli.dto.User;
import com.beyondli.feign.HelloService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/3/1
 * Desc .
 */
@RestController
@RequestMapping(value = "/test")
public class FeignController {
    /**
     * 依赖注入
     */
    @Resource
    HelloService helloService;

    @RequestMapping(value = "/no/hello", method = RequestMethod.GET)
    public String hello() {
        String hello = helloService.hello();
        return "hello服务返回的数据为" + hello;
    }

    @RequestMapping(value = "/get/hello/{name}", method = RequestMethod.GET)
    public String getHelllo(@PathVariable String name) {
        String hello = helloService.getHello(name);
        return hello;
    }

    @RequestMapping(value = "/post/hello", method = RequestMethod.POST)
    public String postHello(@RequestBody User user) {
        String userInfo = helloService.postHello(user);
        return userInfo;
    }
}
