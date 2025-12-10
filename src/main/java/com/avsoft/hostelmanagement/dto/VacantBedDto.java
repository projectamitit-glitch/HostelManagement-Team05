package com.avsoft.hostelmanagement.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VacantBedDto {

    private Long id;
    private int sharing;
    private Long roomId;
    private int floorNo;
    private String buildingName;
    private String hostelName;

    public VacantBedDto(Long id, int sharing, Long roomId, int floorNo,
                        String buildingName, String hostelName) {
        this.id = id;
        this.sharing = sharing;
        this.roomId = roomId;
        this.floorNo = floorNo;
        this.buildingName = buildingName;
        this.hostelName = hostelName;
    }

}
