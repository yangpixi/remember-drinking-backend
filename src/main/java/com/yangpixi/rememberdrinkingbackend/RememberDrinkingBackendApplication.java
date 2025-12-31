package com.yangpixi.rememberdrinkingbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangpixi.rememberdrinkingbackend.mapper")
public class RememberDrinkingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RememberDrinkingBackendApplication.class, args);
    }

}
