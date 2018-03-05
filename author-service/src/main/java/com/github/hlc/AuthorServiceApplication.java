package com.github.hlc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign
 */
@SpringBootApplication
@EnableDiscoveryClient  //Eureka注册中心查询
@EnableFeignClients        //启用Feign客户端
public class AuthorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}

	/**
	 在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；
	 并且向程序的ioc注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
