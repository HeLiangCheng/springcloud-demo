package com.github.hlc.service;

import com.github.hlc.feignclient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Liang on 2018/3/5.
 */
@Service
public class AuthorService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserFeignClient  feignClient;

    //使用restTemplate获取Http请求
    public String authorHelloService(String name){
        // 调用restTemplate.getForObject(“http://SERVICE-HELLO/hello?name=“+name,String.class)方法时，已经做了负载均衡，访问了不同的端口的服务实例
        // SERVICE-HELLO为Application
        System.out.println("restTemplate 端请求");
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name="+name,String.class);
    }


    /*
      使用Feign客户端请求user-service 服务
     */
    public String authorHelloServicebyfeign(String name){
        System.out.println("feign 端请求");
        return feignClient.helloFeignClient(name);
    }

}
