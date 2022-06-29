package com.flightApplication.adminService.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//to avoid unnecessary serialization
@JsonIgnoreProperties({"hibernateLazyInitializer"}) 
@Entity
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String userId;
	
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
