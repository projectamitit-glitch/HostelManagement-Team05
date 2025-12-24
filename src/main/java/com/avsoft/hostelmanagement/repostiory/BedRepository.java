package com.avsoft.hostelmanagement.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avsoft.hostelmanagement.entity.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{

    @Query("SELECT DISTINCT b.sharing FROM Bed b ORDER BY b.sharing")
    List<Integer> findAllDistinctSharing();

}
