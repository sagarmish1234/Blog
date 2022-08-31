package com.blogserver.articleservice.controller;

import com.blogserver.articleservice.POJO.ResponsePOJO;
import com.blogserver.articleservice.entity.ArticleEntity;
import com.blogserver.articleservice.entity.CategoryEntity;
import com.blogserver.articleservice.entity.UserEntity;
import com.blogserver.articleservice.proxy.AuthProxy;
import com.blogserver.articleservice.proxy.CategoryProxy;
import com.blogserver.articleservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    AuthProxy authProxy;

    @Autowired
    CategoryProxy categoryProxy;

    @GetMapping("/getResultByName/{name}/{articlesSize}/{categoriesSize}/{usersSize}")
    public ResponseEntity<?> getUsers(@PathVariable String name, @PathVariable Integer articlesSize, @PathVariable Integer categoriesSize, @PathVariable Integer usersSize) {
        ResponseEntity<List<CategoryEntity>> categories = categoryProxy.getByStartingName(name);
        ResponseEntity<List<UserEntity>> users = authProxy.getUsersByName(name);
        List<ArticleEntity> articleEntities = articleService.loadArticlesStartingWith(name);
        HashMap<String, Object> m = new HashMap<>();
        m.put("categories", categories.getBody().subList(categoriesSize, categoriesSize + Math.min(10, categories.getBody().size())));
        m.put("users", users.getBody().subList(usersSize, usersSize + Math.min(10, users.getBody().size())));
        m.put("articles", articleEntities.subList(articlesSize, articlesSize + Math.min(10, articleEntities.size())));
        return ResponseEntity.ok(m);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            ArticleEntity articleEntity = articleService.loadArticleById(id);
            return ResponseEntity.ok(articleEntity);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        try {
            List<ArticleEntity> articleEntity = articleService.loadArticleByTitle(title);
            return ResponseEntity.ok(articleEntity);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
        try {
            List<ArticleEntity> articleEntity = articleService.loadArticlesByUserId(userId);
            return ResponseEntity.ok(articleEntity);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PostMapping("/add/{userId}/user/{categoryId}/category")
    public ResponseEntity<?> addArticle(@RequestBody ArticleEntity articleEntity, @PathVariable Long userId, @PathVariable Long categoryId) {
        try {
            ArticleEntity article = articleService.saveArticleByUserIdAndCategoryId(articleEntity, userId, categoryId);
            return ResponseEntity.ok(article);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/update/{id}/user/{userId}")
    public ResponseEntity<?> updateArticle(@RequestBody ArticleEntity newArticleEntity, @PathVariable Long userId, @PathVariable Long id) {
        try {
            ArticleEntity oldArticle = articleService.loadArticleById(id);
            if (userId != oldArticle.getAuthor_id())
                throw new Exception("You are not authorized to update this article");
            return ResponseEntity.ok(articleService.updateArticleById(id, newArticleEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/updateViews/{id}/user/{userId}")
    public ResponseEntity<?> updateArticleViews(@PathVariable Long userId, @PathVariable Long id) {
        try {
            ArticleEntity article = articleService.updateArticleViewsById(userId, id);
            return ResponseEntity.ok(article);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public ResponseEntity<?> getArticlesByCategoryId(@PathVariable Long categoryId) {
        try {
            List<ArticleEntity> articles = articleService.loadArticlesByCategoryId(categoryId);
            return ResponseEntity.ok(articles);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getEditorPics")
    public ResponseEntity<?> getEditorPics() {
        try {
            List<ArticleEntity> articleEntities = articleService.loadEditorPicks();
            return ResponseEntity.ok(articleEntities);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

}
