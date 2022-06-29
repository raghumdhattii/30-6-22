//package com.flightApplication;
//
////import org.junit.jupiter.api.Test;
////import org.springframework.boot.test.context.SpringBootTest;
////
////@SpringBootTest
////workingOk
////class BookingApplicationTests {
////
////	@Test
////	void contextLoads() {
////	}
////
////}
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.flightApplication.bookingService.BookingApplication;
//import com.flightApplication.bookingService.Exception.RecordNotFoundException;
//import com.flightApplication.bookingService.entity.BookingDetails;
//import com.flightApplication.bookingService.service.BookingService;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes =BookingApplication.class)
//class BookingApplicationTests {
//
//	
//	@Autowired
//	BookingService service;
//
//	
//	@Test
//	void checkBookingTest() throws RecordNotFoundException
//	{
//		
//		BookingDetails details = new BookingDetails();
//		
//		details = service.getbookingDetailsById(46);
//		System.out.println("d-> "+details);
//		assertEquals("Cancelled", details.getStatus());
//		
//	}
//	
//	
////	
//}
//
//	
//
//
//
