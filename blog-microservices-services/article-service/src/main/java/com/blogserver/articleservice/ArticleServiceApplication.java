package com.blogserver.articleservice;

import com.blogserver.articleservice.entity.ArticleEntity;
import com.blogserver.articleservice.proxy.AuthProxy;
import com.blogserver.articleservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients
public class ArticleServiceApplication {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	AuthProxy authProxy;

	public static void main(String[] args) {
		SpringApplication.run(ArticleServiceApplication.class, args);
	}

	@PostConstruct
	public void articles() {
		List<ArticleEntity> articleEntityList = Arrays.asList(new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Consumerism in India", "https://images.pexels.com/photos/2068975/pexels-photo-2068975.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "In the 1990s, many multinational corporations rushed into India to pursue its\n" +
				"middle-class consumers. Low incomes, social and political conservatism and\n" +
				"resistance to change proved too much for them to bear in India's high-security,\n" +
				"low-income society.\n" +
				"The country's recent economic performance and population growth are factors, as\n" +
				"well as its demographic profile. A youthful, exuberant generation is joining the\n" +
				"ranks of Indian consumers. Indians constitute a fifth of the world's citizens below\n" +
				"age 20. Gallup surveyed more than 2,000 people in India from 1996 to 2006 and\n" +
				"found significant changes in consumer attitudes over that period.\n" +
				"Indians are getting more materialistic and consumerism is becoming a way of life\n" +
				"in India- Almost half of India's urban population had adopted a \"work hard and get\n" +
				"rich\" ethos by 1996. Indians are more motivated than ever by personal ambition\n" +
				"and a desire for material success and they put in the hours it takes to achieve those\n" +
				"goals.\n" +
				"A recent Gallup poll of more than 30 countries showed that India ranks among the\n" +
				"hardest working nations globally. Although long-term plans remain a high priority,\n" +
				"life's pleasures in the here and now have gained importance over the past decade.\n" +
				"Indians' desire to set money aside for electronics and durables has grown so\n" +
				"dramatically that it has nearly caught up with their desire to save for their children's\n" +
				"education. The number of Indians who own or use mobile phones has grown\n" +
				"1,600% - not surprising in a country that is adding more than 3 million subscribers\n" +
				"a month. Ownership of music systems and televisions is also on the rise. And it is\n" +
				"not merely a large-city phenomenon; people in smaller towns espouse these values\n" +
				"as well.\n" +
				"30% of Indians still live on less than one U.S. dollar a day. In the short term,\n" +
				"income constraints and rising costs could slow India's transformation from a\n" +
				"needs-based to a wants-based market. However, a heightened desire to lead the\n" +
				"good life might well intensify the middle- and lower-income groups' efforts to\n" +
				"make more money.\n" +
				"\"Foreign is passé; Indian is paramount- Indians long believed in the overwhelming\n" +
				"supremacy of all things foreign\". Now, with Indians succeeding on the global\n" +
				"economic stage, \"Made in India\" is no longer an apology. While Indians'\n" +
				"confidence in foreign companies has remained essentially static, their faith in\n" +
				"domestic companies has grown. They have become discerning consumers who\n" +
				"want products that are made in India and for Indians.\n" +
				"Of the top 20 brands in India, eight are Indian. Of the top 20 named in a survey,\n" +
				"eight are Indian, including names like Tata, Godrej, and Bajaj. Hutch, Nokia, and\n" +
				"Samsung have done this particularly well.\n" +
				"Seven of the top brands come from well-established MNCs that are either\n" +
				"thoroughly indigenized or involved in a joint venture that gives them the\n" +
				"advantages of both worlds—customization of products for India with levels of\n" +
				"quality and technology associated with international companies. Seven of the top\n" +
				"brands come from well-established MNCs such as Philips and Hero Honda.\n" +
				"India is a diverse country, with 23 official languages and more than 1,000 dialects.\n" +
				"It's one of the world's oldest civilizations, and rather than dispense with traditional\n" +
				"values, it has wrapped modernity around its traditional core. 83% of Indians\n" +
				"approve of women working outside the home. Only 25% approve of marriage to\n" +
				"someone who is not an Indian.\n" +
				"To the outside world, the harmonious coexistence of seeming contradictions is one\n" +
				"of the most confusing aspects of the Indian psyche. The companies, domestic or\n" +
				"foreign, that understand this complexity will be the most successful at working\n" +
				"with and selling to Indians and stand to reap enormous benefits of scale.", new Date(), null, new HashSet<>(), 4L), new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Consumerism in India", "https://images.pexels.com/photos/3483098/pexels-photo-3483098.jpeg?auto=compress&cs=tinysrgb&w=600", 400L, "Maecenas id lectus eu eros viverra viverra et eget orci. Suspendisse potenti. Praesent ultrices ex vitae interdum commodo. Donec id iaculis nunc. Pellentesque consectetur nulla vitae orci efficitur bibendum. Sed non maximus mi. Mauris porttitor est quis est venenatis finibus eu eu lectus. Maecenas laoreet fermentum mattis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum sagittis condimentum elementum. Ut ultricies erat hendrerit justo ultricies, nec euismod neque tempus.", new Date(), null, new HashSet<>(), 4L), new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/1602726/pexels-photo-1602726.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Quisque placerat venenatis elit, vitae suscipit felis maximus vel. Phasellus laoreet augue quis dolor luctus luctus eget vitae lacus. Sed pretium sollicitudin commodo. Donec congue ante suscipit tellus condimentum, et aliquam eros aliquet. Sed at augue ac massa vehicula tristique. Nulla iaculis nisl vel quam vulputate, id pulvinar massa interdum. Morbi pretium auctor viverra. Nam sapien erat, vestibulum sit amet mattis id, molestie in dui.", new Date(), null, new HashSet<>(), 4L), new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 5L),new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 4L),new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 3L),new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 4L),new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 4L),new ArticleEntity((Long) null, authProxy.getUserByEmail("sagarmish1234@gmail.com").getBody().getId(), "Article 1", "https://images.pexels.com/photos/210990/pexels-photo-210990.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 400L, "Vestibulum pellentesque massa vitae laoreet tincidunt. Integer et nisi id lectus consectetur cursus. Nunc ac erat faucibus, euismod magna ac, finibus massa. Etiam tincidunt lacinia libero vel commodo. Cras eget egestas magna, ac commodo quam. In tincidunt elit a convallis dapibus. Praesent vitae hendrerit turpis. In hac habitasse platea dictumst. Morbi efficitur dapibus lacinia.", new Date(), null, new HashSet<>(), 5L));
		articleRepository.saveAll(articleEntityList);
	}
}
