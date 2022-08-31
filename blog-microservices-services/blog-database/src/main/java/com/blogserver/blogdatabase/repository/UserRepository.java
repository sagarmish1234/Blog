package com.blogserver.blogdatabase.repository;

import com.blogserver.blogdatabase.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    Optional<List<UserEntity>> findByFullNameIgnoreCaseStartingWith(String name);
    Optional<List<UserEntity>> findByFullNameIgnoreCaseContaining(String name);
}