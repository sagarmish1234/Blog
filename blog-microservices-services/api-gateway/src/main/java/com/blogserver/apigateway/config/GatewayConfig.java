package com.blogserver.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Autowired
//    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/user/**").uri("lb://auth-service"))
                .route(r -> r.path("/category/**").uri("lb://category-service"))
                .route(r -> r.path("/article/**").uri("lb://article-service")).build();
    }

}
