package com.beyondli.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author kingboy
 * @date 2017/6/21 下午10:20
 * @desc 加载application-configuration.properties文件
 */
@Component
@PropertySource(value="exception.properties", encoding =  "UTF-8")
public class LoadProperties {
}
