package com.beyondli.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beyondLi
 * Date 2018/3/1
 * Desc .
 */
@RefreshScope
@RestController
public class ClientController {
    @Value("${form}")
    private String form;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String hello() {
        return this.form;
    }


}
