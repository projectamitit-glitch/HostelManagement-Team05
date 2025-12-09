package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
