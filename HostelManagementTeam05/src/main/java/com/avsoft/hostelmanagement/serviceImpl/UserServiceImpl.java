package com.avsoft.hostelmanagement.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.hostelmanagement.dto.UserSignupDto;
import com.avsoft.hostelmanagement.dto.UserUpdateDto;
import com.avsoft.hostelmanagement.entity.User;
import com.avsoft.hostelmanagement.repostiory.UserRepository;
import com.avsoft.hostelmanagement.service.UserService;
import com.avsoft.hostelmanagement.util.EmailService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	

	@Autowired
	EmailService emailService;
	
	// OTP Generator
	private String generateOtp() {
		return String.format("%06d", new Random().nextInt(999999));
	}
	

	//add user 
	
	@Override
	public String registerUser(UserSignupDto dto) {

		// email already verified user exists
		Optional<User> exist = userRepo.findByEmail(dto.getEmail());
		if (exist.isPresent() && exist.get().isEmailVerified())
			return "Email already registered!";

		// If user exists but unverified → update details & resend OTP
		User user = exist.orElse(new User());

		user.setFullName(dto.getFullName());
		user.setEmail(dto.getEmail());
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword()); 
		user.setCreatedDate(LocalDateTime.now());
		user.setRole("USER");

		// Generate OTP
		String otp = generateOtp();
		user.setOtp(otp);
		user.setOtpGeneratedAt(LocalDateTime.now());

		userRepo.save(user);
		emailService.sendOtp(dto.getEmail(), otp);

		return "OTP sent to email. Please verify to complete signup.";
	}
	
	
	//get user 
	
	@Override
	public User getUser(long id) {
	    User user = userRepo.findById(id).orElse(null);

	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    return user;
	}
	
	//delete user 
	
	@Override
	public String deleteUser(long id) {
		userRepo.deleteById(id);
		return "User removed successfully!";
	}
	
	//otp and mail verification
	
	@Override
	public String verifyEmail(String email, String otp) {

		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		if (user.isEmailVerified())
			return "Email already verified!";

		// OTP expiry check (10 minutes)
		if (user.getOtpGeneratedAt().plusMinutes(10).isBefore(LocalDateTime.now()))
			return "OTP expired! Please resend.";

		if (!user.getOtp().equals(otp))
			return "Invalid OTP!";

		user.setEmailVerified(true);
		user.setOtp(null);
		user.setOtpGeneratedAt(null);
		userRepo.save(user);

		return "Email verified successfully!";
	}

	//resend otp
	
	@Override
	public String resendOtp(String email) {

		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		String otp = generateOtp();
		user.setOtp(otp);
		user.setOtpGeneratedAt(LocalDateTime.now());
		userRepo.save(user);

		emailService.sendOtp(email, otp);

		return "OTP resent to email!";
	}


	// get all users
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
		
	}

// update user 
	@Override
	public String updateUser(long id, UserUpdateDto dto) {
		 User user = userRepo.findById(id).orElse(null);

		    if (user == null) {
		        return "User not found!";
		    }

		    
		    if (dto.getFullName() != null) {
		        user.setFullName(dto.getFullName());
		    }
		    if (dto.getCurrentAddress() != null) {
		        user.setCurrentAddress(dto.getCurrentAddress());
		    }
		    if (dto.getPermanentAddress() != null) {
		        user.setPermanentAddress(dto.getPermanentAddress());
		    }
		    if (dto.getDateOfBirth() != null) {
		        user.setDateOfBirth(dto.getDateOfBirth());
		    }
		    if (dto.getMobileNo() != null) {
		        user.setMobileNo(dto.getMobileNo());
		    }
		    if (dto.getEmail() != null) {
		        user.setEmail(dto.getEmail());
		    }
		    if (dto.getEducation() != null) {
		        user.setEducation(dto.getEducation());
		    }
		    if (dto.getAdharNo() != null) {
		        user.setAdharNo(dto.getAdharNo());
		    }
		    if (dto.getParentName() != null) {
		        user.setParentName(dto.getParentName());
		    }
		    if (dto.getParentMobileNo() != null) {
		        user.setParentMobileNo(dto.getParentMobileNo());
		    }
		    if (dto.getGender() != null) {
		        user.setGender(dto.getGender());
		    }
		    if (dto.getProfession() != null) {
		        user.setProfession(dto.getProfession());
		    }
		    if (dto.getMaritalStatus() != null) {
		        user.setMaritalStatus(dto.getMaritalStatus());
		    }
		    if (dto.getUserName() != null) {
		        user.setUserName(dto.getUserName());
		    }
		    if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
		        user.setPassword(dto.getPassword());  
		    }

		    
		    user.setUpdatedDate(LocalDateTime.now());

		    
		    userRepo.save(user);

		    return "User updated successfully!";
		}
	
}
