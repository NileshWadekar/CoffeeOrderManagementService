package com.coffee.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.Order;
import com.coffee.model.Payment;
import com.coffee.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JSONReadWriteService {
	final static Logger log = LoggerFactory.getLogger(JSONReadWriteService.class);

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	public void readWriteJSON() {
		readAndSaveProducts();
		readAndSaveOrders();
		readAndSavePayments();
	}

	private void readAndSaveProducts() {
		log.info("readAndSaveProducts Invoked");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/products.json");
		try {
			List<Product> products = mapper.readValue(inputStream, typeReference);
			productService.saveProductInfo(products);
			log.info("Prodcuts Saved!");
		} catch (IOException e) {
			log.error("Unable to save Products: " + e.getMessage());
		}

	}

	private void readAndSavePayments() {
		log.info("readAndSavePayments Invoked");
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Payment>> typeReference = new TypeReference<List<Payment>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/payments.json");
		try {
			List<Payment> payments = mapper.readValue(inputStream, typeReference);
			paymentService.savePaymentInfo(payments);
			log.info("Payments Saved!");
		} catch (IOException e) {
			log.error("Unable to save Payments: " + e.getMessage());
		}

	}

	private void readAndSaveOrders() {
		log.info("readAndSaveOrders Invoked");
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Order>> typeReference = new TypeReference<List<Order>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/orders.json");
		try {
			List<Order> orders = mapper.readValue(inputStream, typeReference);
			orderService.saveOrderInfo(orders);
			log.info("Orders Saved!");
		} catch (IOException e) {
			log.error("Unable to save Orders: " + e.getMessage());
		}

	}

}