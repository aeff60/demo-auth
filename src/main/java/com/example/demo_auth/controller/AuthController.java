package com.example.demo_auth.controller;


import java.util.Map;
import java.util.Set;

import com.example.demo_auth.entity.Users;
import com.example.demo_auth.repository.UserRepository;
import com.example.demo_auth.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public String register(@RequestBody Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        // Assign default roles
        if (users.getRoles() == null || users.getRoles().isEmpty()) {
            users.setRoles(Set.of("ROLE_USER")); // Default role is USER
        }

        userRepository.save(users);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginData) {
        Users users = userRepository.findByUsername(loginData.get("username"))
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(loginData.get("password"), users.getPassword())) {
            return jwtUtils.generateJwtToken(users.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }


}
