package com.project.blogserver.service;

import com.project.blogserver.entiity.ArticleEntity;
import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.repository.ArticleRepository;
import com.project.blogserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    public ArticleEntity loadArticleById(Long id) throws Exception {
        Optional<ArticleEntity> article = articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        }
        throw new Exception("No article found");
    }

    public List<ArticleEntity> loadArticleByTitle(String title) throws  Exception{
        Optional<List<ArticleEntity>> articles = articleRepository.findByTitleIgnoreCaseContaining(title);
        if(articles.isPresent() && !(articles.get().isEmpty())){
            return articles.get();
        }
        throw new Exception("No articles found");
    }

    public List<ArticleEntity> loadArticlesByUserId(Long id) throws Exception{
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent() && !(user.get().getArticles().isEmpty())){
            return user.get().getArticles();
        }
        throw new Exception("No user or articles found");
    }


    public ArticleEntity updateArticleById(Long id, ArticleEntity newArticle) throws Exception {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        if(articleEntity.isPresent()){
            articleEntity.get().setUpdatedAt(new Date());
            articleEntity.get().setImage(newArticle.getImage());
            articleEntity.get().setStory(newArticle.getStory());
            articleEntity.get().setTitle(newArticle.getTitle());
            articleEntity.get().setViews(newArticle.getViews());
            return articleEntity.get();
        }
        throw new Exception("No article found");
    }

    public ArticleEntity updateArticleViewsById(Long id) throws Exception {
        Optional<ArticleEntity> article = articleRepository.findById(id);
        if(article.isPresent()){
            article.get().setViews(article.get().getViews()+1);
            return article.get();
        }
        throw new Exception("No article found");
    }

    public ArticleEntity saveArticle(ArticleEntity articleEntity) throws Exception{
        return articleRepository.save(articleEntity);
    }





}
