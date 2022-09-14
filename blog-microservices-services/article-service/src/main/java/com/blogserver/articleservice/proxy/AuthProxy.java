package com.blogserver.articleservice.proxy;

import com.blogserver.articleservice.POJO.ResponsePOJO;
import com.blogserver.articleservice.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthProxy {

    @GetMapping("/user/getByStaringName/{name}")
    public ResponseEntity<List<UserEntity>> getUsersByName(@PathVariable String name);

    @GetMapping("/user/getById/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id);

    @GetMapping("/user/getByEmail/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email);
}
