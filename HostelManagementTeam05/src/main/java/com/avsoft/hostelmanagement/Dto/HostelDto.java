package com.avsoft.hostelmanagement.Dto;

import lombok.Data;

@Data
public class HostelDto {
	
	private Long id;
    private String name;
    private String address;
    private int capacity;
    private String contactNo;
    private String genderType; 

}
