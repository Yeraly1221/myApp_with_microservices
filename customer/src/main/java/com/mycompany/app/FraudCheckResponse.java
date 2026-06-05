package com.mycompany.app;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}
