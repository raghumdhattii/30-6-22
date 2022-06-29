package com.flightApplication.adminService.dto;

public class Airline {
	
	private String airlineName;
	private int airlineId;
	private String status;
	
	private String airlineEmail;
	
	public Airline() {
		super();
	}
	public Airline(String airlineName, String status, String airlineEmail) {
		super();
		this.airlineName = airlineName;
		this.status = status;
		this.airlineEmail = airlineEmail;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getAirlineId() {
		return airlineId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAirlineEmail() {
		return airlineEmail;
	}
	public void setAirlineEmail(String airlineEmail) {
		this.airlineEmail = airlineEmail;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

}
