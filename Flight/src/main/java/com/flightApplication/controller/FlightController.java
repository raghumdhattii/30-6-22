package com.flightApplication.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.entity.Flight;
import com.flightApplication.exception.RecordNotFoundException;
import com.flightApplication.service.FlightService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin (origins= {"https:hoppscotch.io", "http://localhost:4200"})
@RestController

public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping(path = "airline/{id}/flight")// consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Flight addFlight(@PathVariable int id, @RequestBody Flight flight) throws SQLException, NoSuchElementException {
		
	    
		return flightService.addFlight(id,flight);

	}

	@PutMapping("airline/{id}/flight/{flightid}")
	public Flight updateFlight(@PathVariable int id , @PathVariable int flightid, @RequestBody Flight flight) throws NullPointerException, SQLException, NoSuchElementException, RecordNotFoundException {
		
	    
		return flightService.updateFlight(id ,flightid,flight);

	}
	
	@GetMapping("flight/{flightid}")
	public Flight getFlight(@PathVariable int flightid) throws NoSuchElementException,NullPointerException, SQLException, RecordNotFoundException {
		
	    
		return flightService.getFlight(flightid);

	}
	


	@GetMapping("/search")
	public List<Flight> getFlights(@RequestParam String from , @RequestParam String to, @RequestParam String date) throws ParseException, RecordNotFoundException, NoSuchElementException{
		
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		  //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSX");
		  //LocalDateTime date1 = LocalDateTime.parse(date, dtf);
		  
		  LocalDate date1 = LocalDate.parse(date, dtf);
		 
		  if(flightService.getFlights(from, to, date1) !=null) {
			  
			  return flightService.getFlights(from,to,date1);
		  }
		  
		  else {
			  throw new RecordNotFoundException("No flights found for the given search details");
		  }
	
		
	}

}
