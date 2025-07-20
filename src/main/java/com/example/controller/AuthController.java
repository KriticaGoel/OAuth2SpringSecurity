package com.example.controller;

import com.example.dto.LoginRequestDto;
import com.example.dto.SignUpRequestDto;
import com.example.dto.UserDto;
import com.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
    this.authService = authService;
    }
    //Signup
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignUpRequestDto signUpRequestDto) {

        return ResponseEntity.ok(authService.signup(signUpRequestDto));
    }

    //login
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody LoginRequestDto userDto) {
        if (userDto.getEmail() == null || userDto.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password must not be null");
        }
        return ResponseEntity.ok(authService.login(userDto));
    }

    //Validate Token
    @GetMapping("/validate")
    public ResponseEntity<UserDto> validateToken(@RequestHeader String token){

        UserDto userDto = authService.validateToken(token);

        return ResponseEntity.ok(userDto);

    }

    //getToken
}
