package com.melolingo.app.services;

import com.melolingo.app.models.User;
import com.melolingo.app.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    // Inject UserRepo & PasswordEncoder dependencies via constructor
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder)
    {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // Load user from username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
    }

    // Authenticate user with username and password
    public boolean authenticate(String username, String password) {
        User user = userRepo.findByUsername(username);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    // Register new user account
    public User registerNewUserAccount(String username, String password) {
        if (userRepo.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already taken, sorry!");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return userRepo.save(user);
    }

    // Return all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Find by username & save user
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}