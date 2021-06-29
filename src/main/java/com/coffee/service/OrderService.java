package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.Order;
import com.coffee.model.Payment;
import com.coffee.repository.OrderRepository;

@Service
public class OrderService {
	final static Logger log = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	EntityManager em;

	public List<Order> saveOrderInfo(List<Order> orders) {
		log.info("savePaymentInfo Invoked");
		return orderRepository.saveAll(orders);
	}

	public List<Order> findAmountUserOwes() {
		log.info("findAmountUserOwes Invoked");
		List<Order> listOrderPyament = new ArrayList<Order>();

		try {
			Query query = em
					.createNativeQuery("SELECT O.USER, SUM(PROD.PRICES) AS AMOUNT_OWES FROM ORDERS O INNER JOIN ("
							+ "SELECT * FROM PRODUCTS P INNER JOIN PRODUCT_PRICES PP ON P.ID =PP.PRODUCT_ID ) AS PROD "
							+ "ON O.DRINK = PROD.DRINK_NAME AND O.SIZE = PROD.PRICES_KEY"
							+ "GROUP BY O.USER ORDER BY O.USER");
			listOrderPyament = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrderPyament;
	}
}