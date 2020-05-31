package com.ebuy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangjm
 * @createTime 2020-05-29 11:37
 * @description
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka3000 {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Eureka3000.class);
        application.run(args);

    }
}
