package com.blogserver.apigateway;

import com.blogserver.apigateway.entity.UserEntity;
import com.blogserver.apigateway.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.google.common.net.HttpHeaders.X_REQUESTED_WITH;
import static org.springframework.http.HttpHeaders.*;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	@Autowired
	private UserRespository userRespository;
	@Bean
	public CorsConfiguration corsConfiguration(RoutePredicateHandlerMapping routePredicateHandlerMapping) {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("http://localhost:3000");
		corsConfiguration.setAllowedMethods(Arrays.asList(
				HttpMethod.POST.name(),
				HttpMethod.GET.name(),
				HttpMethod.OPTIONS.name(),
				HttpMethod.DELETE.name(),
				HttpMethod.PUT.name(),
				HttpMethod.PATCH.name()
		));
		corsConfiguration.setAllowedHeaders(
				Arrays.asList(ORIGIN, X_REQUESTED_WITH, CONTENT_TYPE, ACCEPT, AUTHORIZATION, "XXX"));
		corsConfiguration.setMaxAge(3600L);
		corsConfiguration.setAllowCredentials(true);
		routePredicateHandlerMapping.setCorsConfigurations(
				new HashMap<String, CorsConfiguration>() {{ put("/**", corsConfiguration); }});
		return corsConfiguration;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
