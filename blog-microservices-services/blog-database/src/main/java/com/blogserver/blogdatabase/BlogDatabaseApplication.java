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

	@PostConstruct
	public void articles() {
		List<ArticleEntity> articleEntityList = Arrays.asList(new ArticleEntity((Long) null, 5L, "Article 1", "https://images.pexels.com/photos/2068975/pexels-photo-2068975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Pellentesque iaculis justo sapien, quis fermentum nulla ullamcorper et. In ornare maximus porta. Nullam ac fermentum ante. Praesent condimentum lorem et rutrum pulvinar. Suspendisse dapibus dignissim justo sed euismod. Integer at ornare sapien, et dapibus justo. Integer scelerisque facilisis accumsan. Sed ullamcorper aliquam libero non sagittis. Phasellus finibus, sapien et faucibus scelerisque, tellus nulla elementum libero, ac gravida leo enim sit amet magna. Etiam id molestie diam. Nulla feugiat nisl eu iaculis ultrices. Nulla malesuada venenatis sapien eu consectetur. Etiam magna nisi, hendrerit vel orci et, venenatis fringilla lacus. Donec ultricies at nisi at accumsan.", new Date(), null, new HashSet<>(), 4L), new ArticleEntity((Long) null, 5L, "Article 1", "https://images.pexels.com/photos/3483098/pexels-photo-3483098.jpeg?auto=compress&cs=tinysrgb&w=600", 400L, "Maecenas id lectus eu eros viverra viverra et eget orci. Suspendisse potenti. Praesent ultrices ex vitae interdum commodo. Donec id iaculis nunc. Pellentesque consectetur nulla vitae orci efficitur bibendum. Sed non maximus mi. Mauris porttitor est quis est venenatis finibus eu eu lectus. Maecenas laoreet fermentum mattis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum sagittis condimentum elementum. Ut ultricies erat hendrerit justo ultricies, nec euismod neque tempus.", new Date(), null, new HashSet<>(), 4L),new ArticleEntity((Long) null, 5L, "Article 1", "https://images.pexels.com/photos/1602726/pexels-photo-1602726.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Quisque placerat venenatis elit, vitae suscipit felis maximus vel. Phasellus laoreet augue quis dolor luctus luctus eget vitae lacus. Sed pretium sollicitudin commodo. Donec congue ante suscipit tellus condimentum, et aliquam eros aliquet. Sed at augue ac massa vehicula tristique. Nulla iaculis nisl vel quam vulputate, id pulvinar massa interdum. Morbi pretium auctor viverra. Nam sapien erat, vestibulum sit amet mattis id, molestie in dui.", new Date(), null, new HashSet<>(), 4L),new ArticleEntity((Long) null, 5L, "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 4L));
		articleRepository.saveAll(articleEntityList);

	}

}
