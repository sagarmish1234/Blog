package com.blogserver.blogdatabase.repository;

import com.blogserver.blogdatabase.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {

    Optional<List<ArticleEntity>> findByTitleIgnoreCaseContaining(String title);

    Optional<List<ArticleEntity>> findByTitleIgnoreCaseStartingWith(String name);
}