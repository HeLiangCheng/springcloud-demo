package com.github.hlc.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Liang on 2018/3/5.
 */

//@ FeignClient（“服务名”）
@FeignClient(value = "SERVICE-HELLO")
public interface UserFeignClient {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String helloFeignClient(@RequestParam(value = "name") String name);

}
