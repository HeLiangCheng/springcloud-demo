package com.github.hlc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEurekaApplication.class, args);
	}
}
