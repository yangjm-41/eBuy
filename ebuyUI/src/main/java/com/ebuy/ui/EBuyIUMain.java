package com.ebuy.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EBuyIUMain {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EBuyIUMain.class);
        application.run(args);
    }
}
