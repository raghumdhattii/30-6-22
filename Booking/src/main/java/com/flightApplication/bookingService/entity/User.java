package com.flightApplication.bookingService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String firstName;

	private String lastName;

	private String gender;

	private String age;

	@NonNull
	private String emailId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String firstName, String lastName, String gender, String age, String emailId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.emailId = emailId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", emailId=" + emailId + "]";
	}

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "USER_FLIGHT_BOOKING", joinColumns = @JoinColumn(name =
	 * "USER_ID"), inverseJoinColumns = @JoinColumn(name = "FLIGHT_ID")) private
	 * List<Flight> flight;
	 */

	

}
