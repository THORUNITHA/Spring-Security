package com.security.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Disable default security configuration and use our own configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

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

    //Creating a own authentication provider
    //multiple implementation of authentication provider for database it is DAO authentication provider

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
       //daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // Pass user - VAR aRGS
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("thoru").password("thoru").roles("ADMIN").build();
//
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("deepu").password("deepu").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
}