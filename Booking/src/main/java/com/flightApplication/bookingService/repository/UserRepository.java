package com.flightApplication.bookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightApplication.bookingService.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.emailId = ?1")
	public User getUserByEmailID(String emailId);

}
