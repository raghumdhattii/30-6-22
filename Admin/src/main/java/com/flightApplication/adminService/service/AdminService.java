package com.flightApplication.adminService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApplication.adminService.entity.DiscountCoupon;

import com.flightApplication.adminService.exception.RecordNotFoundException;
import com.flightApplication.adminService.model.Coupon;
import com.flightApplication.adminService.repository.DiscountCouponRepository;

@Service
public class AdminService {
	
	@Autowired
	private DiscountCouponRepository discountcouponrepo; 

	public DiscountCoupon addCoupon(Coupon coupon) {
		DiscountCoupon disCoup = new DiscountCoupon(coupon.getCouponCode(),coupon.getExpiryDate(),coupon.getStatus(),coupon.getDiscountPrice());
		return discountcouponrepo.save(disCoup);
	}

	public DiscountCoupon modifyCoupon(Coupon coupon, String couponCode) throws RecordNotFoundException {

		Optional<DiscountCoupon> couponDet = discountcouponrepo.findById(couponCode);
		if(couponDet.isPresent()) {
			DiscountCoupon disCoup = new DiscountCoupon(coupon.getCouponCode(),coupon.getExpiryDate(),coupon.getStatus(),coupon.getDiscountPrice());
			discountcouponrepo.save(disCoup);
			return disCoup;
		}
		else
			throw new RecordNotFoundException("Coupon is not available for the given coupon code" + couponCode);
		
		
	}

	public DiscountCoupon getCouponDetails(String couponCode) throws RecordNotFoundException {

		 Optional<DiscountCoupon> couponDetails = discountcouponrepo.findById(couponCode);
		 
		 if(couponDetails.isPresent()) {
			 return couponDetails.get();
		 }
		 else {
			 throw new RecordNotFoundException("No coupon "+ couponCode+" is present " );
		 }
	}

}
