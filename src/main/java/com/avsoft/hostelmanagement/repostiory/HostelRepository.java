package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avsoft.hostelmanagement.entity.Hostel;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long>{
	@Query("SELECT h FROM Hostel h JOIN h.addresss a WHERE " +
	           "(:city IS NULL OR LOWER(a.city) LIKE LOWER(CONCAT('%', :city, '%'))) AND " +
	           "(:area IS NULL OR LOWER(a.area) LIKE LOWER(CONCAT('%', :area, '%')))")
	    List<Hostel> searchHostels(@Param("city") String city, @Param("area") String area);
	
	

}
