package com.example.demo_auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "This is the admin dashboard.";
    }

    @GetMapping("/management")
    public String getAdminManagementPage() {
        return "This is the admin management page.";
    }
}
