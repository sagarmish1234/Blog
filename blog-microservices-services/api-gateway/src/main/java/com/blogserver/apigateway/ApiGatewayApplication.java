package com.blogserver.apigateway;

import com.blogserver.apigateway.entity.UserEntity;
import com.blogserver.apigateway.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	@Autowired
	private UserRespository userRespository;


	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
