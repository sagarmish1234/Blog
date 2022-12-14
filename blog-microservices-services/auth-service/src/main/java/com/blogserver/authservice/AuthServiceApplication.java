package com.blogserver.authservice;

import com.blogserver.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableWebSecurity
@EnableTransactionManagement
public class AuthServiceApplication {

    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }


}
