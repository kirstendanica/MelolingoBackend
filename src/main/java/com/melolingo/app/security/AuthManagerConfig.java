package com.melolingo.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableWebSecurity
public class AuthManagerConfig {
    private final UserService userService;

    // Inject UserService dependency via constructor
    public AuthManagerConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    @Lazy
    public UserDetailsService userDetailsService() {
        return userService;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    @Lazy
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable())
                .authorizeRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated();
    }
}