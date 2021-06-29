package com.coffee.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

	private Constants() {

	}

	// Database Constants
	public static final String PRODUCTS_TABLE = "products";
	public static final String ORDERS_TABLE = "orders";
	public static final String PAYMENT_TABLE = "payment";
	
	//Other Constants
	public static List<String> STOCK_TYPE_LIST = Arrays.asList("buy","sell");
	public static int MAX_SHARES = 100;
	public static int MIN_SHARES = 0;

}
