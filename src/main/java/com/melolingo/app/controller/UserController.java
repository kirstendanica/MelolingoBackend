package com.melolingo.app.controller;

import com.melolingo.app.dto.JwtAuthenticationResponse;
import com.melolingo.app.dto.LoginRequest;
import com.melolingo.app.models.User;
import com.melolingo.app.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService, TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUserAccount(@RequestBody User user) {
        User registeredUser = userService.registerNewUserAccount(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByUsername(loginRequest.getUsername());
            String jwt = tokenProvider.generateToken(user);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login information.");
        }
    }

    @GetMapping("/languages")
    public ResponseEntity<List<String>> getSupportedLanguages() {
        List<String> supportedLanguages = Arrays.asList("French", "Spanish", "German", "Chinese", "Russian", "Swedish", "Finnish", "Korean", "Japanese", "Dutch", "Polish");
        return ResponseEntity.ok(supportedLanguages);
    }
}
