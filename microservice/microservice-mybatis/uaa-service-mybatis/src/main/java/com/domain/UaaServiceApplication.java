package com.domain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
@EnableTransactionManagement
//@EnableScheduling
//@EnableAsync
@MapperScan("com.uaa.model.mapper")
public class UaaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }

}
