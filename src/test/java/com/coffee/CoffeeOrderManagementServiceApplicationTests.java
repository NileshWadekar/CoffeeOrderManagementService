package com.coffee;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.coffee.controller.CoffeeRestController;
import com.coffee.model.Payment;
import com.coffee.service.PaymentService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CoffeeOrderManagementServiceApplicationTests {

	@Mock
	PaymentService paymentService;

	@InjectMocks
	CoffeeRestController coffeeRestController;

	List<Payment> testPayment;
	Payment payment;

	@BeforeEach
	public void setup() {
		payment = new Payment();
		testPayment = new ArrayList<>();
		
		payment.setUser("rochelle");
		payment.setAmount(22);
		testPayment.add(payment);
	}
	
	@Test
	void contextLoads() {
	}

	@Test
	void testAmountPaidPerUser() {
		when(paymentService.findAllGroupByUser()).thenReturn(testPayment);
		assertNotNull(coffeeRestController.retriveAmount());
	}
	
	@Test
	void testAmountPerOwes() {
		when(paymentService.findAmountUserOwes()).thenReturn(testPayment);
		assertNotNull(coffeeRestController.retriveAmount());
	}

}
