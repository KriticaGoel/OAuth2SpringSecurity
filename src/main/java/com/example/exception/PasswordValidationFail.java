package com.example.exception;

public class PasswordValidationFail extends RuntimeException{
    public PasswordValidationFail(String message) {
        super(message);
    }
}
