package com.jeremias.dev.notification;

import com.jeremias.dev.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(
        scanBasePackages = {
                "com.jeremias.dev.notification",
                "com.jeremias.dev.amqp"
        }

)
public class NotifiactionAplication {
    public static void main(String[] args) {
        SpringApplication.run(NotifiactionAplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    new person("alex","jeremias",1),
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey()
//            );
//        };
//    }
//
//    record person (String name, String lastname,int age){}
}
