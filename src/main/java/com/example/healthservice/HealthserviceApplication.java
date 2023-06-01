package com.example.healthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthserviceApplication.class, args);
	}

}
