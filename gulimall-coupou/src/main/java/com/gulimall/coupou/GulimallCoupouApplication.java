package com.gulimall.coupou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.gulimall.coupou.mapper")
public class GulimallCoupouApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCoupouApplication.class, args);
    }

}
