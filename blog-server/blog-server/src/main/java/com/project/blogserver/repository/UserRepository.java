package com.project.blogserver.repository;

import com.project.blogserver.entiity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<List<UserEntity>> findByFullNameIgnoreCaseContaining(String name);
}
