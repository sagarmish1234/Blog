package com.micro.categorymicroservice.controller;

import com.micro.categorymicroservice.POJO.ResponsePOJO;
import com.micro.categorymicroservice.entity.CategoryEntity;
import com.micro.categorymicroservice.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<CategoryEntity> categories = categoriesService.loadAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        try {
            List<CategoryEntity> categoryEntities = categoriesService.loadCategoriesByName(name);
            return ResponseEntity.ok(categoryEntities);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            CategoryEntity category = categoriesService.loadCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }
    @GetMapping("/getByStartingName/{name}")
    public ResponseEntity<?> getByStartingName(@PathVariable String name) {
        try {
            List<CategoryEntity> categoryEntities = categoriesService.getCategoriesStartingWith(name);
            return ResponseEntity.ok(categoryEntities);
        } catch (Exception e) {
            return ResponseEntity.ok(new ArrayList<CategoryEntity>());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryEntity categoryEntity) {
        try {
            return ResponseEntity.ok(categoriesService.saveCategory(categoryEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoriesService.deleteCategoryById(id);
            return ResponseEntity.ok("The category with id " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/update/{id}/{name}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @PathVariable String name) {
        try {
            CategoryEntity categoryEntity = categoriesService.updateCategoryById(id, name);
            return ResponseEntity.ok(categoryEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }

}
