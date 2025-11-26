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
public class HostelDto {

    private Long id;
    private String name;
    private String address;
    private int capacity;
    private String contactNo;
    private String email;
    private String image;
    private String website;
    private String genderType; // BOYS / GIRLS / CO-ED
    private String description;
    
    private Double latitude;
    private Double longitude;
    
    private String status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // IMPORTANT: We only need the ID to link the parent, not the whole object
    private Long organizationId; 
}