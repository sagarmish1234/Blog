package com.project.blogserver.repository;

import com.project.blogserver.entiity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {

    Optional<List<ArticleEntity>> findByTitleIgnoreCaseContaining(String title);
}
