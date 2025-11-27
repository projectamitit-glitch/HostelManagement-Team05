package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class BedDto {
	
	private Long id;
    private String bedNo;
    private String status;
    private String price;
    private int sharing; 
}
