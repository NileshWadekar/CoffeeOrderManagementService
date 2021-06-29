package com.coffee.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.Payment;
import com.coffee.repository.PaymentRepository;

@Service
public class PaymentService {
	final static Logger log = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	EntityManager em;

	public List<Payment> savePaymentInfo(List<Payment> payments) {
		log.info("savePaymentInfo Invoked");
		return paymentRepository.saveAll(payments);
	}

	public List<Payment> findAllGroupByUser() {
		log.info("findAllGroupByUser Invoked");
		return paymentRepository.findAmountPerUser();
	}

	@SuppressWarnings("unchecked")
	public List<Payment> findAmountUserOwes() {
		log.info("findAmountUserOwes Invoked");
		List<Payment> listPyament = new ArrayList<>();
		try {
			Query query = em.createNativeQuery(
					"SELECT O.USER, SUM (PROD.PRICES) AS AMOUNT FROM ORDERS O INNER JOIN (SELECT * FROM PRODUCTS P INNER JOIN PRODUCT_PRICES PP ON P.ID =PP.PRODUCT_ID) AS PROD ON O.DRINK = PROD.DRINK_NAME AND O.SIZE = PROD.PRICES_KEY GROUP BY O.USER");
			List<Object[]> list = query.getResultList();

			for (Object[] obj : list) {
				Payment payment = new Payment();
				payment.setUser(obj[0].toString());
				payment.setAmount(Double.parseDouble(obj[1].toString()));
				listPyament.add(payment);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPyament;
	}

}