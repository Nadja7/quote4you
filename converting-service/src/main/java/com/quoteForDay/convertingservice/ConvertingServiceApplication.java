package com.quoteForDay.convertingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRetry
public class ConvertingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvertingServiceApplication.class, args);
    }

}
