package com.blogserver.apigateway.config;

import com.blogserver.apigateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/user/**").filters(f -> f.filter(filter)).uri("lb://auth-service"))
                .route(r -> r.path("/category/**").filters(f -> f.filter(filter)).uri("lb://category-service"))
                .route(r -> r.path("/article/**").filters(f -> f.filter(filter)).uri("lb://article-service")).build();
    }
}
