package com.javaapi.fruitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.javaapi"})
public class FruitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitServiceApplication.class, args);
	}

}
