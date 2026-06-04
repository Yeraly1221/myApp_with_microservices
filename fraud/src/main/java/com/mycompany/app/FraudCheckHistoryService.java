package com.mycompany.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryService {

    private  final FraudCheckHistoryRepository fcHistoryRepository;

    public boolean isFraudulentCustomer(Long customerId) {
        fcHistoryRepository.save(FraudCheckHistory.builder()
                .isFraudster(false)
                .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
