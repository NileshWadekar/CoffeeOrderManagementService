package com.coffee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.coffee.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constants.ORDERS_TABLE)
@Data
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@NotEmpty(message = "User Name Is Mandatory!")
	private String user;
	@NotEmpty(message = "User Drink Is Mandatory!")
	private String drink;
	@NotEmpty(message = "Drink Size Is Mandatory!")
	private String size;
	
	private transient long amount;
	
	

}
