package com.joseph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboardPage() {
        // Logic for displaying the dashboard page
        return "dashboard";
    }
}
