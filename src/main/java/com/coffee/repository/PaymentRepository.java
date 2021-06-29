package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffee.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	@Query(value = "SELECT new com.coffee.model.Payment(p.user, sum(amount) as amount) from Payment p GROUP BY p.user")
	List<Payment> findAmountPerUser();
	
}
