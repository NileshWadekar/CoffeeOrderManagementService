package com.coffee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.Product;
import com.coffee.repository.ProductRepository;

@Service
public class ProductService {
	final static Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	public List<Product> saveProductInfo(List<Product> products) {
		log.info("saveProductInfo Invoked");
		return productRepository.saveAll(products);
	}

}