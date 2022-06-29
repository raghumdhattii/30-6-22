//package com.flightApplication;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.flightApplication.repository.AirlineRepository;
//import com.flightApplication.service.AirlineService;
//
//public class TestFlightApp extends AirlineApplicationTests {
//	
//	
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//	@Test
//	public void testAirline() throws Exception {
//		mockMvc.perform(get("/airline")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.airlineName").value("AirIndia")).andExpect(jsonPath("$.airlineId").value("44"))
//				.andExpect(jsonPath("$.status").value("Available")).andExpect(jsonPath("$.airlineEmail").value("AirIndia@gmail.com"));
//
//	}
//
//}
//
////	@Autowired
////	private WebApplicationContext webApplicationContext;
////
////	
////	@Autowired
////	 AirlineRepository repo;
////	
////	@Autowired
////	AirlineService ser;
////	
////	
////	private MockMvc mockMvc;
////
////	@Before
////	public void setup() {
////		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
////	}
////
////	@Test
////	public void testEmployee() throws Exception {
////		mockMvc.perform(get("/airline")).andExpect(status().isOk())
////				.andExpect(content().contentType("application/json;charset=UTF-8"))
////				.andExpect(jsonPath("$.airlineId").value("9")).andExpect(jsonPath("$.status").value("Available"))
////				.andExpect(jsonPath("$.airlineEmail").value("JetAirways@gmail.com"));
////
////	}
////
