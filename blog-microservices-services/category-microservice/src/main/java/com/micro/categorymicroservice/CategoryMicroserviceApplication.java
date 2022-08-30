package com.micro.categorymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class CategoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryMicroserviceApplication.class, args);
	}

}
