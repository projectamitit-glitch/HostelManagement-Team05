package com.avsoft.hostelmanagement.dto;

import lombok.Data;

@Data
public class VacantBedDto {

    private Long bedId;
    private int sharing;
    private Long roomId;
    private int floorNo;
    private String buildingName;
    private String hostelName;


    public VacantBedDto(
            Long bedId,
            int sharing,
            Long roomId,
            int floorNo,
            String buildingName,
            String hostelName
    ) {
        this.bedId = bedId;
        this.sharing = sharing;
        this.roomId = roomId;
        this.floorNo = floorNo;
        this.buildingName = buildingName;
        this.hostelName = hostelName;
    }
}
