package com.veganplanet.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDubbo
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
public class VeganplanetUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeganplanetUserApplication.class, args);
    }

}
