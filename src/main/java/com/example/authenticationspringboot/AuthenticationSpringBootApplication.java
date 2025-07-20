package com.example.authenticationspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EntityScan("com.example.model")  // Add this to scan your entity package
@EnableJpaRepositories("com.example.repository") // Add this if you have repositories
public class AuthenticationSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationSpringBootApplication.class, args);
    }

}
