package com.amitit.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("Hello")
	public String helloworld() {
		return "ok Done!";
	}

}
