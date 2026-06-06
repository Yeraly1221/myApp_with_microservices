package com.mycompany.app;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Builder
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final WebClient.Builder webClientBuilder;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();


        customerRepository.saveAndFlush(customer);


        FraudCheckResponse fraudCheckResponse = webClientBuilder.build()
                .get()
                .uri("http://fraud/api/v1/fraud-check/{customerId}", customer.getId())
                .retrieve()
                .bodyToMono(FraudCheckResponse.class)
                .block();


        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster is not available");
        }


    }
}
