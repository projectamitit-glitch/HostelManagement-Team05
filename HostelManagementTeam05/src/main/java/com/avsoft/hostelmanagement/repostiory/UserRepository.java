package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
