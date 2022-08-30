package com.blogserver.authservice;

import com.blogserver.authservice.entity.UserEntity;
import com.blogserver.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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

    @PostConstruct
    public void users() {
        ArrayList<UserEntity> arr = new ArrayList<>(Arrays.asList(
                new UserEntity(null, null, "Sagar Mishra", "sagarmish1234@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632419", new Date(), "Admin")
                , new UserEntity(null, null, "Kagar M", "sagarmish1235@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632420", new Date(), "User")
        ));
        userRepository.saveAll(arr);
    }
}
