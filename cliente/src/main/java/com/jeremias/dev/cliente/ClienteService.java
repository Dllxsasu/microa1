package com.jeremias.dev.cliente;

import com.jeremias.dev.amqp.RabbitMQMessageProducer;
import com.jeremias.dev.clients.fraud.FraudCheckResponse;
import com.jeremias.dev.clients.fraud.FraudClient;
import com.jeremias.dev.clients.notification.NotificationClient;
import com.jeremias.dev.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(ClienteRequest request) {
        Cliente cliente = Cliente.builder()
                .nombres(request.nombres())
                .apellidos(request.apellidos())
                .email(request.email())
                .build();
        //guarda y sincroniza los cambios en la entidad
        clienteRepository.saveAndFlush(cliente);
        /*
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                cliente.getId()
                );

        */
        //lol

        String x = "ada";
        String lol = "a";

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(cliente.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        NotificationRequest notificationRequest = new NotificationRequest(
                cliente.getId(),
                cliente.getEmail(),
                String.format("Hi %s, welcome to wakanda forever...",
                        cliente.getNombres())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");

  //      notificationClient.sendNotification(notificationRequest);
/*
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

         */

    }
}
