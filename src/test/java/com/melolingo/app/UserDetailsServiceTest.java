package com.melolingo.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDetailsServiceTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testLoadUserByUsername() {
        String username = "MelolingoUser";
        UserDetails user = userDetailsService.loadUserByUsername(username);
        assertNotNull(user, "User should not be null");
        assertEquals(username, user.getUsername(), "Username should match the input");
    }
}