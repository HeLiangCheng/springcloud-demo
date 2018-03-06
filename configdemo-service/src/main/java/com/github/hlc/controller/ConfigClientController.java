package com.github.hlc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liang on 2018/3/6.
 */
@RestController
@RequestMapping("/api/config")
public class ConfigClientController {

    @Value("${foo}")
    String foo;

    @Value("${democonfigclient.message}")
    String message;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo + " : " + message;
    }

}
