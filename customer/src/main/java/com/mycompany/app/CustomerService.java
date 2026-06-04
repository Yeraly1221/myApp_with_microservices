package com.mycompany.app;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Builder
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        customerRepository.save(Customer
                        .builder()
                        .firstName(customerRequest.firstName())
                        .lastName(customerRequest.lastName())
                        .email(customerRequest.email())
                        .build());
    }
}
