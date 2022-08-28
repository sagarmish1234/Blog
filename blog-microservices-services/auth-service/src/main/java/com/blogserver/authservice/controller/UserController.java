package com.blogserver.authservice.controller;

import com.blogserver.authservice.POJO.ResponsePOJO;
import com.blogserver.authservice.entity.UserEntity;
import com.blogserver.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserEntity userEntity) {
        try {
            UserEntity user = userService.updateUserByUsername(userEntity.getEmail(), userEntity);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            UserEntity user = userService.loadUserById(id);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try{
            UserEntity user = userService.loadUserByEmail(email);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }
}
