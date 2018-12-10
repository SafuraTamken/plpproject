package com.cg.ecm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ECMApplication {
	public static void main(String[] args) {
		SpringApplication.run(ECMApplication.class, args);
	}
}
