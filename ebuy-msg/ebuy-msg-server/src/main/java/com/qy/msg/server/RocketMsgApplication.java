package com.qy.msg.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableAsync;



@EnableAsync
@EnableEurekaClient
//@EnableSwagger2
@EnableHystrix
@MapperScan("com.qy.msg.**.mapper")
@SpringBootApplication(scanBasePackages = {"com.qy.msg", "com.qy.base"})
public class RocketMsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMsgApplication.class, args);
    }


}
