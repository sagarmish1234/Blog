package com.micro.categorymicroservice.service;

import com.micro.categorymicroservice.entity.CategoryEntity;
import com.micro.categorymicroservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoriesService {

    @Autowired
    public CategoryRepository categoryRepository;

    public CategoryEntity loadCategoryById(Long id) throws Exception {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new Exception("No category found");
    }

    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    public List<CategoryEntity> loadCategoriesByName(String name) throws Exception {
        Optional<List<CategoryEntity>> categories = categoryRepository.findByNameIgnoreCaseContaining(name);
        if (categories.isPresent() && !(categories.get().isEmpty())) {
            return categories.get();
        }
        throw new Exception("No categories found");
    }

    public List<CategoryEntity> loadAllCategories() throws Exception {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(Long id) throws Exception {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new Exception("No category found");
        }
        categoryRepository.deleteById(id);
    }

    public Boolean patternCheck(String big, String small) {
        if (small.length() > big.length() || small.charAt(0) != big.charAt(0))
            return false;
        int i = 0, j = 0;
        while (i < big.length() && j < small.length()) {
            if (big.charAt(i) == small.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == small.length())
            return true;
        return false;
    }

    public List<CategoryEntity> getCategoriesStartingWith(String name) throws Exception {
        List<CategoryEntity> categories = categoryRepository.findAll();
        categories = categories.stream().filter(e -> patternCheck(e.getName().toLowerCase(), name.toLowerCase())).collect(Collectors.toList());
        if (categories.isEmpty())
            throw new Exception("No categories found");
        return categories;
    }

    public CategoryEntity updateCategoryById(Long id, String name) throws Exception {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
        if (!categoryEntity.isPresent()) {
            throw new Exception("No category found.");
        }
        categoryEntity.get().setName(name);
        return categoryEntity.get();
    }

}
