package com.blogserver.articleservice.controller;

import com.blogserver.articleservice.entity.ArticleEntity;
import com.blogserver.articleservice.entity.CategoryEntity;
import com.blogserver.articleservice.entity.UserEntity;
import com.blogserver.articleservice.proxy.AuthProxy;
import com.blogserver.articleservice.proxy.CategoryProxy;
import com.blogserver.articleservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getResultByName/{name}")
    public ResponseEntity<?> getUsers(@PathVariable String name) {
        ResponseEntity<List<CategoryEntity>> categories = categoryProxy.getByStartingName(name);
        ResponseEntity<List<UserEntity>> users = authProxy.getUsersByName(name);
        List<ArticleEntity> articleEntities = articleService.loadArticlesStartingWith(name);
        HashMap<String, Object> m = new HashMap<>();
        m.put("categories", categories.getBody());
        m.put("users", users.getBody());
        m.put("articles", articleEntities);
        return ResponseEntity.ok(m);
    }

}
