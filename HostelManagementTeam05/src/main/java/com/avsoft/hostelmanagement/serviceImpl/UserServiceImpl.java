package com.avsoft.hostelmanagement.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.entity.User;
import com.avsoft.hostelmanagement.exceptionHandler.UserCustomeException;
import com.avsoft.hostelmanagement.repostiory.UserRepository;
import com.avsoft.hostelmanagement.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
   @Autowired
   UserRepository userRepo;
	
   
   
	@Override
	
    public void signup(User user) {

        
		User existingUser = userRepo.findByUserName(user.getUserName()).orElse(null);

        if (existingUser != null) {
            throw new UserCustomeException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        user.setRole("USER");

        userRepo.save(user);
    }
}
