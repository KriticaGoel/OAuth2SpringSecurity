package com.example.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequestDto {

    private String username;
    @Email
    private String email;
    private String password;
}
