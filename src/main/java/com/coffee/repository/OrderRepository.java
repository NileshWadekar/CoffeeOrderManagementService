package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffee.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
