package com.avsoft.hostelmanagement.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.util.MessageConstant;
import com.avsoft.hostelmanagement.entity.User;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avsoft.hostelmanagement.dto.OtpVerificationDto;
import com.avsoft.hostelmanagement.dto.UserSignupDto;
import com.avsoft.hostelmanagement.dto.UserUpdateDto;
import com.avsoft.hostelmanagement.entity.User;
import com.avsoft.hostelmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	//adduser
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody UserSignupDto dto) {
		String response = service.registerUser(dto);
		return ResponseEntity.ok(response);
	}


	// get user by id 
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User user = service.getUser(id);
		return ResponseEntity.ok(user);
	}

	//delete  user by id 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		String msg = service.deleteUser(id);
		return ResponseEntity.ok(msg);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable long id,
	                                         @RequestBody UserUpdateDto dto) {
	    String msg = service.updateUser(id, dto);
	    return ResponseEntity.ok(msg);
	}
	

  //verify mail using otp	
	
	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyEmail(@RequestBody OtpVerificationDto dto) {
		String result = service.verifyEmail(dto.getEmail(), dto.getOtp());
		return ResponseEntity.ok(result);
	}


	// resend otp
	
	@PostMapping("/resend-otp")
	public ResponseEntity<String> resendOtp(@RequestBody OtpVerificationDto dto) {
		String msg = service.resendOtp(dto.getEmail());
		return ResponseEntity.ok(msg);
	}
}
