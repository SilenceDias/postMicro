package com.example.clientcoreapi.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientModel {
    @NotNull(message = "Name cannot be empty")
    private String name;
    private String lastname;
    @NotNull(message = "Email cannot be empty")
    @Email
    private String email;
}
