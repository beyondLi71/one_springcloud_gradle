package com.beyondli.feign;

import com.beyondli.dto.User;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beyondLi
 * Date 2018/3/1
 * Desc .
 */
@FeignClient("hello-service")
public interface HelloService {
    /**
     * 无参
     * @return
     */
    @RequestMapping(value = "/no/hello", method = RequestMethod.GET)
    String hello();

    /**
     * get带参
     * @param name
     * @return
     */
    @RequestMapping(value = "/get/hello/{name}", method = RequestMethod.GET)
    String getHello(@PathVariable("name") String name);

    /**
     * post带参
     * @param user
     * @return
     */
    @RequestMapping(value = "/post/hello")
    String postHello(@RequestBody User user);
}
