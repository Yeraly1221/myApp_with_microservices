package com.mycompany.app;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}
