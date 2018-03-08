package com.beyondli.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/12/6 上午3:20
 * @desc .
 */
@Component
@PropertySource(value = "common-application.properties")
public class CommonLoadProperties {
    public CommonLoadProperties() {

    }
}
