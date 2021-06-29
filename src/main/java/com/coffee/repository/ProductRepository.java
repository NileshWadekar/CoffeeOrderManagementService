package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffee.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
