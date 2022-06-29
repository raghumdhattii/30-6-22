package com.flightApplication.bookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightApplication.bookingService.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
