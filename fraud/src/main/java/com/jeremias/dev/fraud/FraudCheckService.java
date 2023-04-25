package com.jeremias.dev.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Log4j2
@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer clientId) {
        log.info("locuras de verano id: " +clientId);
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .clienteId(clientId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
