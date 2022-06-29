package com.flightApplication.adminService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@EnableDiscoveryClient 
//@EnableCaching 									
@SecurityScheme(name="adminController", scheme="bearer", type =SecuritySchemeType.HTTP, in= SecuritySchemeIn.HEADER)
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
//$2a$10$keCEU1B1Z3Vu94xdaF0rO.z6iG9vPa9SuJ6r3LFX.yaE7C3IONNJu