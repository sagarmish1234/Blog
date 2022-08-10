package com.project.blogserver.controller;

import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class RegisterController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity userEntity){
        try{
            UserDetails user = userService.loadUserByUsername(userEntity.getEmail());
            if(user!=null)
                throw new Exception("User Already exists");
            return ResponseEntity.ok(userService.saveUser(userEntity));
        } catch (Exception e) {
//            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
