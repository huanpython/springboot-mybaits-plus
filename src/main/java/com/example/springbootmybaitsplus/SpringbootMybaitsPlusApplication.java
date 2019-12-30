package com.example.springbootmybaitsplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybaitsplus.mapper")
public class SpringbootMybaitsPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybaitsPlusApplication.class, args);
    }

}
