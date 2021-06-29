package com.coffee.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coffee.constants.Constants;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constants.PRODUCTS_TABLE)
@Data @NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String drink_name;
	@ElementCollection
	private Map<String,Double> prices = new HashMap<String, Double>();	
}
