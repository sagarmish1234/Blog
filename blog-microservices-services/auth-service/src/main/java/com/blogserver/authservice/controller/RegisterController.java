package com.blogserver.authservice.controller;

import com.blogserver.authservice.POJO.ResponsePOJO;
import com.blogserver.authservice.entity.UserEntity;
import com.blogserver.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity userEntity) {
        try {
            UserEntity user = userService.loadUserByEmail(userEntity.getEmail());
            return ResponseEntity.status(400).body(new ResponsePOJO("User already exits"));
        } catch (Exception e) {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            return ResponseEntity.ok(userService.saveUser(userEntity));
        }
    }
}