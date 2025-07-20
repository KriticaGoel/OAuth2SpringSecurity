package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignUpRequestDto {

    @NotNull(message = "Username cannot be null")
    @Size(min=1 ,max = 50,message = "Username should have min 1 and max 50 character")
    private String username;
    @NotNull(message = "Password cannot be null")
    @Size(min=5 ,max = 50,message = "Password should have min 5 and max 50 character")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$",
            message = "Password must contain at least one number, one capital letter, and one special character")

    private String password;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email cannot be null")
    @Size(min=3, max=50, message="Email must contain at least 3 character")
    private String email;

    @Digits(integer = 10, message = "Longer is not allowed", fraction = 0)
    private String phone;

}
