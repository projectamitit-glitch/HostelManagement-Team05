package com.avsoft.hostelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hostelmanagement.constants.MessageConstant;
import com.avsoft.hostelmanagement.entity.User;
import com.avsoft.hostelmanagement.response.ApiResponse;
import com.avsoft.hostelmanagement.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
 @Autowired
  UserService service;
 
 @PostMapping("/signup")
 public ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user) {
     service.signup(user);
     return new ResponseEntity<>(
             new ApiResponse<>(MessageConstant.USER_REGISTER_SUCCESS, user),
             HttpStatus.CREATED
     );
 }
}
