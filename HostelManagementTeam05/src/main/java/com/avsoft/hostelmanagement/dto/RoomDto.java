package com.avsoft.hostelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {

    private Long id;
    private int roomNo;
    private String type;             // SINGLE / DOUBLE / TRIPLE
    private String status;           // AVAILABLE / FULL / MAINTENANCE
    private Double pricePerBed;
    private Boolean attachedBathroom;
    private Boolean balcony;

    // Foreign Key to link Parent Floor
    private Long floorId;
}