package com.flightApplication.adminService.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightApplication.adminService.dto.Airline;
import com.flightApplication.adminService.dto.Flight;
import com.flightApplication.adminService.entity.DiscountCoupon;
import com.flightApplication.adminService.exception.RecordNotFoundException;
import com.flightApplication.adminService.model.Coupon;
import com.flightApplication.adminService.service.AdminService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RequestMapping("/Admincontroller")
@CrossOrigin (origins= {"https:hoppscotch.io", "http://localhost:4200"})
@RestController
@SecurityRequirement(name = "adminController")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AdminService adminService;

	@Autowired
	private KafkaTemplate<String, Flight> kafkaTemplate;

	private static final String TOPIC = "kafka_topic_name";
	//private static final String TOPIC = "kafka_topic";
	private static final Logger logger = LogManager.getLogger();


	

	@PostMapping("/airline")
	public Airline addAirline(@RequestBody Airline airline)
			throws NullPointerException, SQLException, RecordNotFoundException {
		System.out.println(" in add airline");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Airline> requestEntity = new HttpEntity<>(airline, headers);
		ResponseEntity<Airline> res = restTemplate.exchange("http://localhost:8082/airline", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Airline>() {
				});

		if (res.getBody() == null) {
			throw new RecordNotFoundException("The airline is not added in the table ");
		}

		return res.getBody();
	}

	@PutMapping("/airline/{airlineid}")
	public Airline blockUnblockAirline(@PathVariable int airlineid)
			throws NullPointerException, SQLException, RecordNotFoundException {

		ResponseEntity<Airline> res = restTemplate.exchange("http://localhost:8082/airline/" + airlineid,
				HttpMethod.PUT, null, new ParameterizedTypeReference<Airline>() {
				});

		if (res != null)
			return res.getBody();
		else {
			throw new RecordNotFoundException("Airline not found");
		}

	}

	@GetMapping("/airline")
	public List<Airline> getAllAirlines() throws RecordNotFoundException {
		ResponseEntity<List<Airline>> res = restTemplate.exchange("http://localhost:8082/airline", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Airline>>() {
				});

		if (res != null)
			return res.getBody();
		else {
			throw new RecordNotFoundException("Airline not found");
		}

	}

	@PostMapping("/airline/{airlineid}/flight")
	public Flight addFlight(@RequestBody Flight flight, @PathVariable int airlineid) throws NullPointerException {
		
		System.out.println(" new admin micro service");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Flight> requestEntity = new HttpEntity<>(flight, headers);
		ResponseEntity<Flight> res = restTemplate.exchange("http://localhost:8082/airline/" + airlineid + "/flight",
				HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Flight>() {
				});

		return res.getBody();
	}

	@PutMapping("airline/{airlineid}/flight/{flightid}")
	public Flight updateFlight(@PathVariable int airlineid, @PathVariable int flightid, @RequestBody Flight flight)
			throws SQLException, NullPointerException, RecordNotFoundException {
		System.out.println(" admin service");

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Flight> requestEntity = new HttpEntity<>(flight, headers);
		ResponseEntity<Flight> res = restTemplate.exchange(
				"http://localhost:8082/airline/" + airlineid + "/flight/" + flightid, HttpMethod.PUT, requestEntity,
				new ParameterizedTypeReference<Flight>() {
				});
		if (res != null)
			return res.getBody();
		else {
			throw new RecordNotFoundException("Airline not found");
		}

	}
	
////
//	@GetMapping("/flights")
//	public List<Flight> getFlights() throws RecordNotFoundException {
//		ResponseEntity<List<Flight>> res1 = restTemplate.exchange("http://localhost:8082/search", HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<Flight>>() {
//				});
//
//		if (res1 != null)
//			return res1.getBody();
//		else {
//			throw new RecordNotFoundException("flight not found");
//		}
//
//	}
//
	@PostMapping("/coupon")
	public DiscountCoupon addcoupon(@RequestBody Coupon coupon) {
		return adminService.addCoupon(coupon);

	}

	@PutMapping("/coupon/{couponCode}")
	public DiscountCoupon modifyCoupon(@RequestBody Coupon coupon, @PathVariable String couponCode)
			throws RecordNotFoundException {

		return adminService.modifyCoupon(coupon, couponCode);

	}

	@GetMapping("/coupon/{couponCode}")
	public DiscountCoupon getcoupon(@PathVariable String couponCode) throws RecordNotFoundException {
		return adminService.getCouponDetails(couponCode);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public KafkaTemplate<String, Flight> getKafkaTemplate() {
		return kafkaTemplate;
	}

	public void setKafkaTemplate(KafkaTemplate<String, Flight> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

}
