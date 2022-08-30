package com.project.blogserver.controller;

import com.project.blogserver.POJO.ResponsePOJO;
import com.project.blogserver.entiity.ArticleEntity;
import com.project.blogserver.entiity.CategoryEntity;
import com.project.blogserver.service.ArticleService;
import com.project.blogserver.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            HashMap<Long, String> categoryEntities = categoriesService.getAllCategoriesNameAndId();
            if (categoryEntities.size() == 0)
                throw new Exception("No categories found");
            return ResponseEntity.ok(categoryEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryEntity categoryEntity) {
        try {
            return ResponseEntity.ok(categoriesService.saveCategory(categoryEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getCategoryItems/{categoryId}")
    public ResponseEntity<?> getCategoryItems(@PathVariable Long categoryId) {
        try {
            List<ArticleEntity> articleEntities = articleService.loadArticlesByCategoryId(categoryId);
            return ResponseEntity.ok(articleEntities);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<?> deleteCategory(@pathVariable Long categoryId) {
        try {
            categoriesService.deleteCategoryById(id);
            return new ResponseEntity<>(id, HttpStatus.ok);
        } catch (Exception e) {
            return ResponseEntity.Status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/updateCategory/{categoryId}/{name}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @PathVariable String name) {
        try {
            categoriesService.updateCategoryById(categoryId, name);
            return new ResponseEntity<>(id, HttpStatus.ok);
        } catch (Exception e) {
            return new ResponseEntity,status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }

}
