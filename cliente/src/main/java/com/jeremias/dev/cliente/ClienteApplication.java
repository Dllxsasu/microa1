package com.jeremias.dev.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.jeremias.dev.cliente",
                "com.jeremias.dev.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.jeremias.dev.clients"

)

public class ClienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }
}
