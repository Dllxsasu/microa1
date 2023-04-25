package com.jeremias.dev.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FraudAplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudAplication.class,args);
    }
}
