package com.example.hellojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HelloJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }
}
