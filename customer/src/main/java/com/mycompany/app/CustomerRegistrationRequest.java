package com.mycompany.app;

import lombok.Builder;
import lombok.Data;


@Builder
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {


}
