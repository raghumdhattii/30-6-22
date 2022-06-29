package com.flightApplication.bookingService.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.bookingService.Exception.RecordNotFoundException;
import com.flightApplication.bookingService.entity.BookingDetails;
import com.flightApplication.bookingService.entity.Passenger;
import com.flightApplication.bookingService.entity.User;
import com.flightApplication.bookingService.model.BookingHistory;
import com.flightApplication.bookingService.model.Ticket;
import com.flightApplication.bookingService.service.BookingService;



@RestController
@CrossOrigin (origins= {"https:hoppscotch.io", "http://localhost:4200"})
//@RequestMapping("/booking")

public class BookingController {

	@Autowired
	private BookingService bookingService;
	
//	@PostMapping("/register-user")
//	public boolean registerNewUser(@RequestBody User user) throws UserAlreadyRegisteredException {
//		boolean flag = false;
//		flag = bookingService.registerUser(user);
//		return flag;
//	}
	
	@PostMapping("/register-user")
	public User registerNewUser(@RequestBody User user) throws RecordNotFoundException {
		return bookingService.registerUser(user);
	}
	
	@GetMapping("/register-user/{emailId}")
	public User GetUser(@RequestBody User user,@PathVariable String emailId) throws RecordNotFoundException {
		return bookingService.getUserByEmailID(emailId);
	}

//	@PostMapping("/users/{userid}/flight/{flightid}/")
//	public Ticket bookTicket(@RequestBody List<Passenger> passengers, @PathVariable int flightid,
//			@PathVariable String userid, @RequestParam String discountCoupon) throws SQLException, NotEnoughSeatsException {
//
//		return bookingService.bookTicket(passengers, flightid, userid, discountCoupon);
//	}
	
	@PostMapping("/users/{userid}/flight/{flightid}")
	public Ticket bookTicket(@RequestBody List<Passenger> passengers, @PathVariable int flightid,
			@PathVariable int userid, @RequestParam String discountCoupon) throws SQLException, RecordNotFoundException {

		return bookingService.bookTicket(passengers, flightid, userid, discountCoupon);
	}


	@GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPNR(@PathVariable int pnr)
			throws NullPointerException, SQLException, RecordNotFoundException {
		return bookingService.getTicketByPNR(pnr);
	}

	@GetMapping("/history/{emailId}")
	public List<BookingHistory> getTicketByEmail(@PathVariable String emailId)
			throws SQLException, RecordNotFoundException {

		return bookingService.getTicketByEmail(emailId);
	}

	@DeleteMapping("/users/{userid}/cancel/{pnr}")
	public void deleteTicketByPNR(@PathVariable int userid, @PathVariable int pnr)
			throws RecordNotFoundException {
		bookingService.deleteTicketByPNR(userid, pnr);

	}
	
//	@GetMapping("/allBooking/{id}")
//	public BookingDetails getbookingDetailsById(@PathVariable int id)
//			throws NullPointerException, SQLException, RecordNotFoundException {
//		return bookingService.getbookingDetailsById(id);
//	}
}
