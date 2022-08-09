package com.aofred.tweeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class TweeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

}
