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
    private String type;
    private String status;
    private Double pricePerBed;
    private int sharing;

    // We only need the ID to link it, not the whole Floor object
    private Long floorId;



}