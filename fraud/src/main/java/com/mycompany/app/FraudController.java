package com.mycompany.app;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckHistoryService  fcHistoryService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")  Long customerId) {

        boolean isFraudulentCustomer = fcHistoryService.isFraudulentCustomer(customerId);

        log.info("fraud check request for customer {}", customerId);

        return new FraudCheckResponse(isFraudulentCustomer);

    }
}
