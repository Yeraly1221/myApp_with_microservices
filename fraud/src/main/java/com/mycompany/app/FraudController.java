package com.mycompany.app;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckHistoryService  fcHistoryService;

    @GetMapping("/customerId")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")  Long customerId) {

        boolean isFraudulentCustomer = fcHistoryService.isFraudulentCustomer(customerId);

        return new FraudCheckResponse(isFraudulentCustomer);

    }
}
