package com.userservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull @NotBlank(message = "name should not be blank") String name,
        @NotBlank(message = "email should not be blank") @Email String email) {
}
