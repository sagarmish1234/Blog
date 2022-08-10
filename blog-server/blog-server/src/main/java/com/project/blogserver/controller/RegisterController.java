package com.project.blogserver.controller;

import com.project.blogserver.POJO.ResponsePOJO;
import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity userEntity) {
        try {
            Optional<UserEntity> user = userService.loadUserByEmail(userEntity.getEmail());
            if (user.isPresent())
                throw new Exception("User Already exists");
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            return ResponseEntity.ok(userService.saveUser(userEntity));
        } catch (Exception e) {
//            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }
}
