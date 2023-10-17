package com.melolingo.app.services;

import com.melolingo.app.repo.RoleRepo;
import com.melolingo.app.models.Role;
import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.User;
import com.melolingo.app.repo.UserRepo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final ExerciseService exerciseService;

    private final RoleRepo roleRepo;
    public UserService(UserRepo userRepo, ExerciseService exerciseService, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.exerciseService = exerciseService;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepo.findByUsername(username);
        return user != null && password.equals(user.getPassword());
    }

    public User registerNewUserAccount(String username, String password) {
        if (userRepo.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already taken, sorry!");
        }
        User user = new User();

    // Assign ROLE_USER during user registration by default
    Role defaultRole = roleRepo.findByName(Role.ERole.ROLE_USER);

    if (defaultRole == null) {
        throw new IllegalArgumentException("ROLE_USER not found in our database... Please ensure proper set up for roles.");
    }

    Set<Role> roles = new HashSet<>();
    roles.add(defaultRole);

    user.setRoles(roles);
     user.setUsername(username);
     user.setPassword(password);

   return userRepo.save(user);
}

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<ExerciseDto> getExercisesByLanguage(String language) {
        return exerciseService.getExercisesByLanguage(language);
    }

    public Authentication authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {

        UserDetails userDetails = loadUserByUsername(usernamePasswordAuthenticationToken.getName());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        return authentication;
    }
}