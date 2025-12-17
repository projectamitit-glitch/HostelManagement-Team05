package com.avsoft.hostelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "mahesh Sanjay Pande";
		//		return "forward:/index.html";
	}

	@GetMapping("/app")
	public String app() {
		return "index";
	}
}