package com.flightApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightApplication.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline , Integer>{

}
