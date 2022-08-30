package com.blogserver.authservice.controller;

import com.blogserver.authservice.POJO.ResponsePOJO;
import com.blogserver.authservice.entity.UserEntity;
import com.blogserver.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/updateByEmail/{email}")
    public ResponseEntity<?> update(@RequestBody UserEntity userEntity, @PathVariable String email) {
        try {
            UserEntity user = userService.updateUserByUsername(email, userEntity);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserEntity user = userService.loadUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            UserEntity user = userService.loadUserByEmail(email);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @GetMapping("/getByStaringName/{name}")
    public ResponseEntity<?> getUsersByName(@PathVariable String name) {
        try {
            List<UserEntity> user = userService.loadUsersStartingWith(name);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.getStackTrace();
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.ok(new ResponsePOJO("User with id " + id + "  deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateUserById(@RequestBody UserEntity userEntity, @PathVariable Long id) {
        try {
            UserEntity user = userService.updateUserById(id, userEntity);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }
}
