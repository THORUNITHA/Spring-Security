package com.security.demo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Disable default security configuration and use our own configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //disable the csrf
        httpSecurity.csrf(customizer -> customizer.disable());
        //we need every user to be authenticated
        httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated());
        // Form login
        httpSecurity.formLogin(Customizer.withDefaults());
        //access the output in postman
        httpSecurity.httpBasic(Customizer.withDefaults());
        //Session stateless - everytime a new session is created
      httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
}