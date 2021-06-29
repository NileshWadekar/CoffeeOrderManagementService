package com.coffee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.exceptions.NoDataFoundException;
import com.coffee.model.Payment;
import com.coffee.service.PaymentService;

@RestController
public class CoffeeRestController {
	Logger log = LoggerFactory.getLogger(CoffeeRestController.class);

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/amounts", produces = "application/json")
	public ResponseEntity<List<Payment>> retriveAmount() {
		log.info("Request Received to Retrive Amout Paid Per User!!");
		List<Payment> amountPerUser = paymentService.findAllGroupByUser();
		if(null == amountPerUser)
			throw new NoDataFoundException("No Data Found For Coffee Order Service!!");
		return new ResponseEntity<>(amountPerUser, HttpStatus.OK);
	}

	@GetMapping(value = "/amountUserStillOwes", produces = "application/json")
	public ResponseEntity<List<Payment>> findAmountUserStillOwes() {
		log.info("Request Received to Retrive Amout User Still Owes!!");
		List<Payment> amountPerUser = paymentService.findAmountUserOwes();
		if(amountPerUser.isEmpty())
			throw new NoDataFoundException("No Data Found For Coffee Order Service!!");
		return new ResponseEntity<>(amountPerUser, HttpStatus.OK);
	}

}