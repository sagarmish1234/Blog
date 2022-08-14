package com.project.blogserver.controller;

import com.project.blogserver.POJO.LoginRequest;
import com.project.blogserver.POJO.ResponsePOJO;
import com.project.blogserver.entiity.UserEntity;
import com.project.blogserver.service.JwtUtil;
import com.project.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
            UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtUtil.generateToken(userDetails);
            HashMap<String,String> obj = new HashMap<>();
            obj.put("token",token);
            return ResponseEntity.ok(obj);
        }
        catch (Exception e){
//            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponsePOJO(e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserEntity userEntity){
        try{
            UserEntity user = userService.updateUserByUsername(userEntity.getEmail(), userEntity);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
//            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponsePOJO(e.getMessage()));
        }
    }




}
