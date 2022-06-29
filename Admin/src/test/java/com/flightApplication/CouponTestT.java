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
//import com.flightApplication.adminService.repository.DiscountCouponRepository;
//
//
//class CouponTestT extends CouponTest{
//	
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	
//	@Autowired
//	 DiscountCouponRepository repo;
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
//		mockMvc.perform(get("/Admincontroller/coupon")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.couponCode").value("A1001")).andExpect(jsonPath("$.discountPrice").value("10000"))
//				.andExpect(jsonPath("$.status").value("Available"));
//
//	}
//
//}