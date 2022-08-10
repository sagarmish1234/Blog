package com.project.blogserver.controller;

import com.project.blogserver.POJO.ResponsePOJO;
import com.project.blogserver.entiity.CategoryEntity;
import com.project.blogserver.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            List<CategoryEntity> categoryEntities = categoriesService.loadAllCategories();
            if(categoryEntities.isEmpty())
                throw new Exception("No categories found");
            return ResponseEntity.ok(categoryEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryEntity categoryEntity){
        try{
            return ResponseEntity.ok(categoriesService.saveCategory(categoryEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }


}
