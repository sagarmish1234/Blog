package com.blogserver.articleservice.proxy;

import com.blogserver.articleservice.entity.CategoryEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("category-service")
public interface CategoryProxy {
    @GetMapping("/category/getByStartingName/{name}")
    public ResponseEntity<List<CategoryEntity>> getByStartingName(@PathVariable String name);

    @GetMapping("/category/getById/{id}")
    public ResponseEntity<CategoryEntity> getById(@PathVariable Long id);
}
