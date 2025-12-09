package com.avsoft.hostelmanagement.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ImageDto {
	 private Long id;
	    private LocalDate date;
	    private String fileName;
	    private String fileType;
	    private Long hostelId;
	   
	

}
