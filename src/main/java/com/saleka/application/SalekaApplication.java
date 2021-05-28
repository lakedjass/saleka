package com.saleka.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalekaApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello world qui ne durera pas très longtemps inch'Allah";
	}

}
