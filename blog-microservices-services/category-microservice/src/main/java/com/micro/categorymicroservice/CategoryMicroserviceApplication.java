package com.micro.categorymicroservice;

import com.micro.categorymicroservice.entity.CategoryEntity;
import com.micro.categorymicroservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
public class CategoryMicroserviceApplication {

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CategoryMicroserviceApplication.class, args);
    }

    @PostConstruct
    public void categories() {
        List<CategoryEntity> categoryEntityList = Arrays.asList(new CategoryEntity(null, "Food"),
                new CategoryEntity(null, "Travel"), new CategoryEntity(null, "Space"));
        categoryRepository.saveAll(categoryEntityList);
    }
}
