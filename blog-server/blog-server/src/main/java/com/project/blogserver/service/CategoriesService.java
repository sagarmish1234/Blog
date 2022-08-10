package com.project.blogserver.service;

import com.project.blogserver.entiity.CategoryEntity;
import com.project.blogserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    public CategoryRepository categoryRepository;

    public CategoryEntity loadCategoryById(Long id) throws Exception{
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        throw  new Exception("No category found");
    }

    public CategoryEntity saveCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    public List<CategoryEntity> loadCategoriesByName(String name) throws Exception{
        Optional<List<CategoryEntity>> categories = categoryRepository.findByNameIgnoreCaseContaining(name);
        if(categories.isPresent() && !(categories.get().isEmpty())){
            return categories.get();
        }
        throw  new Exception("No categories found");
    }
    public List<CategoryEntity> loadAllCategories() throws Exception{
        return categoryRepository.findAll();
    }
    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
