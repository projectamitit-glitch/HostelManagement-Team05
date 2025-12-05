package com.avsoft.hostelmanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.avsoft.hostelmanagement.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
	
	private String fullName;
    private String currentAddress;
    private String permanentAddress;
    private LocalDate dateOfBirth;
    private Long mobileNo;
    private String email;
    private String education;
    private Long adharNo;
    private String parentName;
    private Long parentMobileNo;
    private String gender;
    private String profession;
    private String maritalStatus;
    private String userName;
    
   private String password; 

}
