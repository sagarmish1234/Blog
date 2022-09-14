package com.blogserver.articleservice.service;

import com.blogserver.articleservice.POJO.ArticleResponse;
import com.blogserver.articleservice.POJO.ArticleUserResponse;
import com.blogserver.articleservice.entity.ArticleEntity;
import com.blogserver.articleservice.entity.CategoryEntity;
import com.blogserver.articleservice.entity.UserEntity;
import com.blogserver.articleservice.proxy.AuthProxy;
import com.blogserver.articleservice.proxy.CategoryProxy;
import com.blogserver.articleservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthProxy authProxy;

    @Autowired
    private CategoryProxy categoryProxy;

    public ArticleEntity loadArticleById(Long id) throws Exception {
        Optional<ArticleEntity> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        }
        throw new Exception("No article found");
    }

    public List<ArticleEntity> loadArticleByTitle(String title) throws Exception {
        Optional<List<ArticleEntity>> articles = articleRepository.findByTitleIgnoreCaseContaining(title);
        if (articles.isPresent() && !(articles.get().isEmpty())) {
            return articles.get();
        }
        throw new Exception("No articles found");
    }

    public Boolean patternCheck(String big, String small) {
        if (small.length() > big.length() || small.charAt(0) != big.charAt(0))
            return false;
        int i = 0, j = 0;
        while (i < big.length() && j < small.length()) {
            if (big.charAt(i) == small.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == small.length())
            return true;
        return false;
    }

    public List<ArticleEntity> loadArticlesStartingWith(String name) {
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        articleEntities = articleEntities.stream().filter(e -> patternCheck(e.getTitle().toLowerCase(), name.toLowerCase())).collect(Collectors.toList());
        return articleEntities;
    }

    public List<ArticleEntity> loadArticlesByUserId(Long userId) throws Exception {
        List<ArticleEntity> articles = articleRepository.findAll();
        if (articles.isEmpty())
            throw new Exception("No articles found");
        articles = articles.stream().filter(e -> e.getAuthor_id() == userId).collect(Collectors.toList());
        if (articles.isEmpty())
            throw new Exception("No user or articles found");
        return articles;
    }


    public ArticleEntity updateArticleById(Long id, ArticleEntity newArticle) throws Exception {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        if (articleEntity.isPresent()) {
            articleEntity.get().setUpdatedAt(new Date());
            articleEntity.get().setImage(newArticle.getImage());
            articleEntity.get().setStory(newArticle.getStory());
            articleEntity.get().setTitle(newArticle.getTitle());
            articleEntity.get().setWordCount((long) newArticle.getStory().split(" ").length);
            return articleEntity.get();
        }
        throw new Exception("No article found");
    }

    public ArticleEntity updateArticleViewsById(Long userId, Long id) throws Exception {
        Optional<ArticleEntity> article = articleRepository.findById(id);
        if (article.isPresent()) {
            HashSet<Long> views  = article.get().getViews();
            views.add(userId);
            article.get().setViews(views);
            return article.get();
        }
        throw new Exception("No article found");
    }



    public ArticleEntity saveArticleByUserIdAndCategoryId(ArticleEntity articleEntity, Long userId, Long categoryId) throws Exception {
        try{
            ResponseEntity<UserEntity> user = authProxy.getUserById(userId);
            ResponseEntity<CategoryEntity> category = categoryProxy.getById(categoryId);
            articleEntity.setAuthor_id(user.getBody().getId());
            articleEntity.setCreatedAt(new Date());
            articleEntity.setViews(new HashSet<>());
            articleEntity.setCategory_id(category.getBody().getId());
            articleEntity.setWordCount((long) articleEntity.getStory().split("\\s").length);
            return articleRepository.save(articleEntity);
        }
        catch(Exception e){
            throw new Exception("User or category does not exist");
        }
    }

    public List<ArticleEntity> loadArticlesByCategoryId(Long categoryId) throws Exception {
        List<ArticleEntity> articles = articleRepository.findAll();
        if(articles.isEmpty())
            throw new Exception("No articles found");
//        System.out.println(articles.get(0));
//        return articles;
        articles = articles.stream().filter(e->e.getCategory_id().equals(categoryId)).collect(Collectors.toList());
        if(articles.isEmpty())
            throw new Exception("No articles found");
        return articles;
    }

    public List<ArticleEntity> loadEditorPicks() throws Exception {
        List<ArticleEntity> pics = articleRepository.findAll();
        if (!pics.isEmpty()) {
            Collections.shuffle(pics);
            return pics.subList(0, 4);
        }
        throw new Exception("No articles found");
    }

    public List<ArticleResponse> convertToArticleResponse(List<ArticleEntity> articles) {
        List<ArticleResponse> ans = new ArrayList<>();
        for (ArticleEntity ar : articles) {
            ArticleResponse articleResponse = new ArticleResponse();
            articleResponse.setId(ar.getId());
            articleResponse.setTitle(ar.getTitle());
            articleResponse.setImage(ar.getImage());
            articleResponse.setStory(ar.getStory());
            articleResponse.setWordCount(ar.getWordCount());
            UserEntity userById = authProxy.getUserById(ar.getAuthor_id()).getBody();
            articleResponse.setAuthor(new ArticleUserResponse(userById.getEmail(), userById.getFullName(), userById.getImage()));
            CategoryEntity byId = categoryProxy.getById(ar.getCategory_id()).getBody();
            articleResponse.setCategory(byId.getName());
            articleResponse.setCreatedAt(ar.getCreatedAt());
            ans.add(articleResponse);
        }
        return ans;
    }

    public List<ArticleEntity> trendingPosts() throws Exception {
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        if (articleEntities.isEmpty())
            throw new Exception("Articles not found");
        Collections.sort(articleEntities, (a, b) -> a.getViews().size() - b.getViews().size());
        return articleEntities.subList(0, 6);
    }

    public ArticleResponse convertToArticleResponse(ArticleEntity ar) {
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.setId(ar.getId());
        articleResponse.setTitle(ar.getTitle());
        articleResponse.setImage(ar.getImage());
        articleResponse.setStory(ar.getStory());
        articleResponse.setWordCount(ar.getWordCount());
        UserEntity userById = authProxy.getUserById(ar.getAuthor_id()).getBody();
        articleResponse.setAuthor(new ArticleUserResponse(userById.getEmail(), userById.getFullName(), userById.getImage()));
        CategoryEntity byId = categoryProxy.getById(ar.getCategory_id()).getBody();
        articleResponse.setCategory(byId.getName());
        articleResponse.setCreatedAt(ar.getCreatedAt());
        return articleResponse;
    }
}