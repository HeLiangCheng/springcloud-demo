package com.github.hlc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liang on 2018/3/5.
 */
@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hi "+name+",i am from port:"+port;
    }

}
