package com.example.schoolmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.schoolmicroservice")
public class SchoolMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolMicroServiceApplication.class, args);
    }

}
