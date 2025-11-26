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
public class BedDto {

    private Long id;
    private String bedNo;
    private String status;        // AVAILABLE / BOOKED
    private String price;         // Stored as String in your Entity, though Double is often better
    private int sharing;          // 1, 2, 3 sharing

    private Boolean booked;
    private LocalDate bookedFrom;
    private LocalDate bookedTo;

    // Foreign Key to link Parent Room
    private Long roomId;
}