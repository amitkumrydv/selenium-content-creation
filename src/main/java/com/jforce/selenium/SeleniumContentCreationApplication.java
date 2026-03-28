package com.jforce.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = "com.jforce.selenium")
public class SeleniumContentCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumContentCreationApplication.class, args);
	}

}
