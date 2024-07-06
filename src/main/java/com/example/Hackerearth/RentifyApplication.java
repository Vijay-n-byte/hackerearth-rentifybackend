package com.example.Hackerearth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RentifyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentifyApplication.class, args);
		System.out.println("hello");
	}
}
