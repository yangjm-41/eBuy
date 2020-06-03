package com.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author yangjm
 * @createTime 2020-05-29 14:20
 * @description
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@MapperScan("com.ebuy.order.dao")//mapper接口包路径
@EnableAutoConfiguration
@EnableFeignClients
@EnableHystrix
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(OrderApplication.class);
        application.run(args);
    }
}
