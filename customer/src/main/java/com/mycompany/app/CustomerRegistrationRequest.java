package com.mycompany.app;

import lombok.Builder;


@Builder
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {


}
