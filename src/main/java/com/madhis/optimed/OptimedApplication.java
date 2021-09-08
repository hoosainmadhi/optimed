package com.madhis.optimed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class OptimedApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimedApplication.class, args);
	}
}
