package com.project.blogserver.repository;

import com.project.blogserver.entiity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<List<CategoryEntity>> findByNameIgnoreCaseContaining(String name);

}
