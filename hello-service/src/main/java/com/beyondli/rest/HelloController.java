package com.beyondli.rest;

import com.beyondli.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beyondLi
 * Date 2018/3/1
 * Desc .
 */
@RestController
public class HelloController {
    /**
     * 无参
     * @return
     */
    @RequestMapping(value = "/no/hello", method = RequestMethod.GET)
    public String hello() {
        return "new hello world";
    }

    /**
     * get传参
     */
    @RequestMapping(value = "/get/hello/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable String name) {
        return "传入的名字为:" + name;
    }

    /**
     * post传参
     */
    @RequestMapping(value = "/post/hello", method = RequestMethod.POST)
    public String postHello(@RequestBody User user) {
        return "传入的名字为:" + user.getName() + ", 传入的年龄为" + user.getAge();
    }
}
