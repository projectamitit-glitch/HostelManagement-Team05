package com.avsoft.hostelmanagement.Dto;

import lombok.Data;

@Data
public class BedDto {
	
	private Long id;
    private String bedNo;
    private String status;
    private String price;
    private int sharing; 
}
