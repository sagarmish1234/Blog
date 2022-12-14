package com.project.blogserver;

import com.project.blogserver.entiity.CategoryEntity;
import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.repository.CategoryRepository;
import com.project.blogserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
public class BlogServerApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogServerApplication.class, args);
    }

    @PostConstruct
    public void users() {
        ArrayList<UserEntity> arr = new ArrayList<>(Arrays.asList(
                new UserEntity(null,null, "Sagar Mishra", "sagarmish1234@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632419", new Date(), "Admin")
                , new UserEntity(null,null, "Sagar M", "sagarmish1235@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632420", new Date(), "User")
        ));
        userRepository.saveAll(arr);
    }

    @PostConstruct
    public void categories() {
        ArrayList<CategoryEntity> arr = new ArrayList<>(Arrays.asList(
                new CategoryEntity(null, "Food and Drinks")
                , new CategoryEntity(null, "Tourism")
        ));
        categoryRepository.saveAll(arr);
    }


}
