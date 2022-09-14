package com.blogserver.blogdatabase;

import com.blogserver.blogdatabase.entity.ArticleEntity;
import com.blogserver.blogdatabase.entity.CategoryEntity;
import com.blogserver.blogdatabase.entity.UserEntity;
import com.blogserver.blogdatabase.repository.ArticleRepository;
import com.blogserver.blogdatabase.repository.CategoryRepository;
import com.blogserver.blogdatabase.repository.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
@EnableEurekaClient
public class BlogDatabaseApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogDatabaseApplication.class, args);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}

	@PostConstruct
	public void users() {
		ArrayList<UserEntity> arr = new ArrayList<>(Arrays.asList(
				new UserEntity(null, "https://res.cloudinary.com/sagarmish1234/image/upload/v1662445064/Self-image_shrink_his7zo.jpg", "Sagar Mishra", "sagarmish1234@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632419", new Date(), "Admin")
				, new UserEntity(null, "https://res.cloudinary.com/sagarmish1234/image/upload/v1662445064/Self-image_shrink_his7zo.jpg", "Sagar M", "sagarmish1235@gmail.com", new BCryptPasswordEncoder().encode("sagar"), "6290632420", new Date(), "User")
		));
		userRepository.saveAll(arr);
	}

	@PostConstruct
	public void categories() {
		List<CategoryEntity> categoryEntityList = Arrays.asList(new CategoryEntity(null, "Food"),
				new CategoryEntity(null, "Travel"), new CategoryEntity(null, "Space"), new CategoryEntity(null, "Economics"));
		categoryRepository.saveAll(categoryEntityList);
	}



}
