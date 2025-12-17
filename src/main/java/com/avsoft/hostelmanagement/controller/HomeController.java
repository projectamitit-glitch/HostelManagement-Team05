package com.avsoft.hostelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    // Option 1: Serve static index.html
    @GetMapping("/")
    public String home() {
        // Forward to static index.html
        return "forward:/index.html";
    }
    
    // Option 2: Serve Thymeleaf template
    @GetMapping("/app")
    public String app() {
        return "index"; // Uses templates/index.html
    }
}