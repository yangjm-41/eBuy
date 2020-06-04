package com.ebuy.management;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@MapperScan("com.ebuy.management.dao")//mapper接口包路径
@EnableAutoConfiguration
@EnableFeignClients
@EnableHystrix
public class ManagementApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ManagementApplication.class);
        application.run(args);
    }
}
