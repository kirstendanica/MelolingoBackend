package com.melolingo.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.melolingo.app.services.UserService;

@Configuration
@EnableWebSecurity
public class JwtAuthFilterConfig {

    private final UserService userService;

    // Inject UserService dependency via constructor
    public JwtAuthFilterConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    @Lazy
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationManager authenticationManager) throws Exception {
        return authenticationManager;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable())
                .authorizeRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated();
    }
}