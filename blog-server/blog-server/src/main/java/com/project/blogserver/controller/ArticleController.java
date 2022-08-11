package com.project.blogserver.controller;

import com.project.blogserver.POJO.ResponsePOJO;
import com.project.blogserver.entiity.ArticleEntity;
import com.project.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("/addArticle/{userId}/user/{categoryId}/category")
    public ResponseEntity<?> addArticle(@RequestBody ArticleEntity articleEntity, @PathVariable Long userId, @PathVariable Long categoryId) {
        try {
            ArticleEntity article = articleService.saveArticleByUserIdAndCategoryId(articleEntity, userId, categoryId);
            return ResponseEntity.ok(article);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/updateArticle/{id}/user/{userId}")
    public ResponseEntity<?> updateArticle(@RequestBody ArticleEntity newArticleEntity, @PathVariable Long userId, @PathVariable Long id) {
        try {
            ArticleEntity oldArticle = articleService.loadArticleById(id);
            if (userId != oldArticle.getAuthor().getId())
                throw new Exception("You are not authorized to update this article");
            return ResponseEntity.ok(articleService.updateArticleById(id, newArticleEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/updateArticleViews/{id}/user/{userId}")
    public ResponseEntity<?> updateArticleViews(@PathVariable Long userId, @PathVariable Long id) {
        try {
            ArticleEntity article = articleService.updateArticleViewsById(userId, id);
            return ResponseEntity.ok(article);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getArticleByTitle/{title}")
    public ResponseEntity<?> getArticleByTitle(@PathVariable String title) {
        try {
            List<ArticleEntity> articles = articleService.loadArticleByTitle(title);
            return ResponseEntity.ok(articles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getArticlesByUserId/{userId}")
    public ResponseEntity<?> getArticlesByUserId(@PathVariable Long userId) {
        try {
            List<ArticleEntity> articleEntities = articleService.loadArticlesByUserId(userId);
            return ResponseEntity.ok(articleEntities);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getArticlesByCategoryId/{categoryId}")
    public ResponseEntity<?> getArticlesByCategoryId(@PathVariable Long categoryId) {
        try {
            List<ArticleEntity> articles = articleService.loadArticlesByCategoryId(categoryId);
            return ResponseEntity.ok(articles);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

}
