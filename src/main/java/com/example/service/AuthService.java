package com.example.service;

import com.example.dto.LoginRequestDto;
import com.example.dto.SignUpRequestDto;
import com.example.dto.UserDto;

public interface AuthService {

    UserDto signup(SignUpRequestDto name);

    String login(LoginRequestDto userDto);

    UserDto validateToken(String token);
}
