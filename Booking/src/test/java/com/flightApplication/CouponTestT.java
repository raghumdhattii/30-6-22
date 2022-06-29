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
//import com.flightApplication.bookingService.repository.PassengerRepository;
//
//
//class CouponTestT extends TestCase{
//	
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	
//	@Autowired
//	 PassengerRepository repo;
//	
//	
//	
//	
//	private MockMvc mockMvc;
//
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Test
//	public void testEmployee() throws Exception {
//		mockMvc.perform(get("/register-user")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.userId").value("10")).andExpect(jsonPath("$.firstName").value("Aryan"))
//				.andExpect(jsonPath("$.lastName").value("Khan"));
//
//	}
//
//}