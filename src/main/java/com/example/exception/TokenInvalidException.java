package com.example.exception;

public class TokenInvalidException extends RuntimeException{

    public  TokenInvalidException(String msg){
        super(msg);
    }
}
