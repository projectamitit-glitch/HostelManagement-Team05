package com.avsoft.hostelmanagement.service;

import java.util.List;

import com.avsoft.hostelmanagement.dto.UserSignupDto;
import com.avsoft.hostelmanagement.dto.UserUpdateDto;
import com.avsoft.hostelmanagement.entity.User;

public interface UserService{
	
	
	
	public String registerUser(UserSignupDto dto);
	
	public User getUser(long id);
	
	public String deleteUser(long id);
	
	public String verifyEmail(String email, String otp);
	
	public String resendOtp(String email);
	
	List<User> getAllUsers();
	
	
	String updateUser(long id, UserUpdateDto dto);
	
	
	
	
	
	
	
}
