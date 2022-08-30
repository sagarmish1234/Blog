package com.micro.categorymicroservice.repository;

import com.micro.categorymicroservice.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<List<CategoryEntity>> findByNameIgnoreCaseContaining(String name);


}
