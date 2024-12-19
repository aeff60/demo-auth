package com.example.demo_auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public String getUserProfile() {
        return "This is the user profile page.";
    }

    @GetMapping("/settings")
    public String getUserSettings() {
        return "This is the user settings page.";
    }
}
