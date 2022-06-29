package com.flightApplication.adminService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightApplication.adminService.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

}
