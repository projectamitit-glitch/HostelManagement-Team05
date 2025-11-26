package com.avsoft.hostelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FloorDto {

    private Long id;
    private int floorNo;
    private int noOfRooms;
    private String floorType; // e.g., TILED, WOODEN, VIP
    private String status;    // ACTIVE / FULL / MAINTENANCE

    // Foreign Key to link Parent Building
    private Long buildingId;
}