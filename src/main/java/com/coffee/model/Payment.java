package com.coffee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.coffee.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constants.PAYMENT_TABLE)
@Data
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@NotEmpty(message = "User Name Is Mandatory!")
	private String user;
	@PositiveOrZero(message = "User Order Payment Should be Postive!")
	private double amount;
	
	public Payment(@NotEmpty(message = "User Name Is Mandatory!") String user,
			@PositiveOrZero(message = "User Order Payment Should be Postive!") double amount) {
		super();
		this.user = user;
		this.amount = amount;
	}

	
}
