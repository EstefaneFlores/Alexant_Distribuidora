package com.example.Alexant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example", "Models.service"})
public class AlexantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlexantApplication.class, args);
	}

}
