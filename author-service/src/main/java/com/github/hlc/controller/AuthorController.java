package com.github.hlc.controller;

import com.github.hlc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liang on 2018/3/5.
 */
@RestController
public class AuthorController {

    @Autowired
    public AuthorService service;

    @RequestMapping("/author/hello")
    public String authorHello(String name){
       //return service.authorHelloService(name);
        return service.authorHelloServicebyfeign(name);
    }

}
