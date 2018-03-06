package com.github.hlc.feignclient;

import org.springframework.stereotype.Component;

/**
 * Created by Liang on 2018/3/5.
 */
@Component
public class UserClientHystric implements UserFeignClient {

    @Override
    public String helloFeignClient(String name) {
        return "sorry service not available [name: " + name + "]";
    }
}
