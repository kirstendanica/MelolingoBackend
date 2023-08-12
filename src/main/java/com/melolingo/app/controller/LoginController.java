package com.melolingo.app.controller;

import com.melolingo.app.dto.LoginRequest;
import com.melolingo.app.dto.JwtAuthenticationResponse;
import com.melolingo.app.services.UserService;
import com.melolingo.app.security.TokenProvider;
import com.melolingo.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user
        boolean isAuthenticated = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // Find user object to generate the token
            Optional<User> optionalUser = Optional.ofNullable(userService.findByUsername(loginRequest.getUsername()));

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                // Generate token for authenticated user
                String token = tokenProvider.generateToken(user);

                // Return token in response
                return ResponseEntity.ok(new JwtAuthenticationResponse(token));
            } else {
                // Handle case where user is not found
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
            }
        } else {
            // If authentication fails, return error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
