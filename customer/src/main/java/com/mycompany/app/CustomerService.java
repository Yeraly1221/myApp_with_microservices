package com.mycompany.app;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.Callable;

@Builder
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final WebClient webClient;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();


        customerRepository.saveAndFlush(customer);


        FraudCheckResponse fraudCheckResponse = webClient
                .get()
                .uri("/api/v1/fraud-check/{customerId}", customer.getId())
                .retrieve()
                .bodyToMono(FraudCheckResponse.class)
                .block();


        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster is not available");
        }


    }
}
