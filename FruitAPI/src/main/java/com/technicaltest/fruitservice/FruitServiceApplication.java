package com.technicaltest.fruitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.technicaltest"})
public class FruitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitServiceApplication.class, args);
	}

}
