package com.avsoft.hostelmanagement.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.hostelmanagement.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
