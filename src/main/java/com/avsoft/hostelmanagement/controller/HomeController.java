package com.avsoft.hostelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // loads templates/index.html
    }

    @GetMapping("/hello")
    public String hello(){
        return "Welcome To team 5 ";
    }
}
