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
public class BuildingDto {

    private Long id;
    private String name;        // e.g., "Wing A"
    private int floors;         // e.g., 5
    private String warden;
    private String contactNo;
    private Boolean maintenanceRequired;
    private String status;      // ACTIVE / UNDER_MAINTENANCE

    private LocalDate createdAt;
    private LocalDate updatedAt;

    // Foreign Key to link Parent Hostel
    private Long hostelId;
}