package com.melolingo.app.controller;

import com.melolingo.app.dto.LoginRequest;
import com.melolingo.app.dto.JwtAuthenticationResponse;
import com.melolingo.app.services.UserService;
import com.melolingo.app.security.TokenProvider;
import com.melolingo.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @Autowired
    public LoginController(UserService userService, TokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user
        boolean isAuthenticated = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // Find the user object to generate the token
            User user = userService.findByUsername(loginRequest.getUsername());
            if (user == null) {
                return ResponseEntity.status(401).build();
            }

            // Generate the token for the authenticated user
            String token = tokenProvider.generateToken(user);

            // Return the token in the response
            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        } else {
            // If authentication fails, return an error response
            return ResponseEntity.status(401).build();
        }
    }
}