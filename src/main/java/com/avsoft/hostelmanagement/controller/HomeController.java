package com.avsoft.hostelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/app")
    public String app() {
        return "index";
    }

    @GetMapping("/uday")
    public String printMyName() {
    	return "Uday";
    }
    
    
    // ✅ Simple Hello API
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }
    
    @GetMapping("/shiv")
    public String shiv() {
    	return "shiv";
    }
}
