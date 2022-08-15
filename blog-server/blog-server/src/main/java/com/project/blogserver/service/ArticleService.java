package com.project.blogserver.service;

import com.project.blogserver.entiity.ArticleEntity;
import com.project.blogserver.entiity.CategoryEntity;
import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.repository.ArticleRepository;
import com.project.blogserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CategoriesService categoriesService;

    @Autowired
    private UserRepository userRepository;

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

    public List<ArticleEntity> loadArticlesByUserId(Long userId) throws Exception {
        List<ArticleEntity> articles = articleRepository.findAll();
        if(articles.isEmpty())
            throw new Exception("No articles found");
        articles = articles.stream().filter(e->e.getAuthor().getId()==userId).collect(Collectors.toList());
        if(articles.isEmpty())
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

//    public ArticleEntity saveArticle(ArticleEntity articleEntity) throws Exception {
//        return articleRepository.save(articleEntity);
//    }

    public ArticleEntity saveArticleByUserIdAndCategoryId(ArticleEntity articleEntity, Long userId, Long categoryId) throws Exception {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!(user.isPresent()))
            throw new Exception("Bad Credentials");
        CategoryEntity category = categoriesService.loadCategoryById(categoryId);
        articleEntity.setAuthor(user.get());
        articleEntity.setCreatedAt(new Date());
        articleEntity.setViews(new HashSet<>());
        articleEntity.setCategory(category);
        articleEntity.setWordCount((long) articleEntity.getStory().split(" ").length);
        return articleRepository.save(articleEntity);
    }

    public List<ArticleEntity> loadArticlesByCategoryId(Long categoryId) throws Exception {
        List<ArticleEntity> articles = articleRepository.findAll();
        if(articles.isEmpty())
            throw new Exception("No articles found");
        articles = articles.stream().filter(e->e.getCategory().getId()==categoryId).collect(Collectors.toList());
        if(articles.isEmpty())
            throw new Exception("No articles found");
        return articles;
    }

    public List<ArticleEntity> loadEditorPicks() throws Exception{
        List<ArticleEntity> pics = articleRepository.findAll();
        if(!pics.isEmpty()){
            Collections.shuffle(pics);
            return pics.subList(0,4);
        }
        throw new Exception("No articles found");
    }


}
