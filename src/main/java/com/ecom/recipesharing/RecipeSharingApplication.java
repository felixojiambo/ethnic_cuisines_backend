package com.ecom.recipesharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeSharingApplication {

	public static void main(String[] args) {

		SpringApplication.run(RecipeSharingApplication.class, args);
		System.out.println("Server running on port 9090");
	}

}
