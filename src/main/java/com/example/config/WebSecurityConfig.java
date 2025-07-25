package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> {
                        try {
                            requests
									.anyRequest().permitAll()
                                  //  .requestMatchers("/", "/auth/signup").permitAll()
                             //   .anyRequest().authenticated()
                                    .and().cors().disable()
                                    .csrf().disable();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
			);
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll());

		return http.build();
	}


}