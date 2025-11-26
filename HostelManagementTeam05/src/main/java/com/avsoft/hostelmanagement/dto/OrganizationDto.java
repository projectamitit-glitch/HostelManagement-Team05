package com.avsoft.hostelmanagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {
	private Long id;
    private String orgName;
    private String address;
    private String email;
    private String contactNo;
    private String website;
    private String gstNo;
    private String logoUrl;
    
    // We allow passing status manually, or we default it in service
    private String status; 
    
    // Dates are usually set by the server, but good to have in DTO for responses
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
