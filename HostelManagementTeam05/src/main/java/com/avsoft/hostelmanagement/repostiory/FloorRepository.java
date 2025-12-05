package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.dto.GetFloorDto;
import com.avsoft.hostelmanagement.entity.Floor;


<<<<<<< HEAD

public interface FloorRepository extends JpaRepository<Floor, Long>  {

	List<GetFloorDto> findByBuildingId(Long id);
}
=======
	List<Floor> findByNoOfRooms(int noOfRooms);

}
>>>>>>> remotes/origin/feature/samiksha/#11
