package com.flightApplication.adminService.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiscountCoupon implements Serializable  {
	
	@Id
	private String couponCode;
	
	private LocalDate expiryDate;
	
	private String status;
	
	private double discountPrice;
	
	public DiscountCoupon() {
		super();
	}
	
	public DiscountCoupon(String couponCode, LocalDate expiryDate, String status, double discountPrice) {
		super();
		this.couponCode = couponCode;
		this.expiryDate = expiryDate;
		this.status = status;
		this.discountPrice = discountPrice;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double dicountPrice) {
		this.discountPrice = dicountPrice;
	}

}
