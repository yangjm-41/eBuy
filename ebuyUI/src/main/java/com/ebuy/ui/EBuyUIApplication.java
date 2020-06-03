package com.ebuy.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EBuyUIApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EnableEurekaClient.class);
        application.run(args);
    }
}
