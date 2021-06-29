package com.coffee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coffee.service.JSONReadWriteService;

@SpringBootApplication
public class CoffeeOrderManagementServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoffeeOrderManagementServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(JSONReadWriteService jsonReadWriteService) {
		return args -> {
			jsonReadWriteService.readWriteJSON();
		};
	}

}
