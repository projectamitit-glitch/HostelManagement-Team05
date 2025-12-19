package com.avsoft.hostelmanagement.repostiory;

import com.avsoft.hostelmanagement.dto.VacantBedDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Bed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Long>{
    @Query("SELECT new com.avsoft.hostelmanagement.dto.VacantBedDto (" +
            "b.id, " +
            "b.sharing, " +   // sharing from Bed entity
            "b.room.id, " +
            "b.room.floor.floorNo, " +
            "b.room.floor.building.name, " +
            "b.room.floor.building.hostel.name) " +  // using 'name'
            "FROM Bed b " +
            "WHERE b.status = 'AVAILABLE' " +
            "AND b.sharing = :sharing " +
            "AND b.room.floor.building.hostel.id = :hostelId")
    List<VacantBedDto> findVacantBeds(
            @Param("hostelId") Long hostelId,
            @Param("sharing") int sharing);

}
