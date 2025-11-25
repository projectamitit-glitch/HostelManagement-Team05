package com.avsoft.hostelmanagement.repostiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avsoft.hostelmanagement.entity.User;

	

	@Repository
	public interface UserRepository extends JpaRepository<User, Long> {

	    Optional<User> findByUserName(String userName);

	    Optional<User> findByEmail(String email);

	   
	    Optional<User> findByUserNameAndPassword(String userName, String password);
	}
