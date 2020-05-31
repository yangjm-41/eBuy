package com.ebuy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangjm
 * @createTime 2020-05-29 14:20
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(UserApplication.class);
        application.run(args);
    }
}
