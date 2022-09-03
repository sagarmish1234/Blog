package com.blogserver.authservice.controller;

import com.blogserver.authservice.POJO.LoginRequest;
import com.blogserver.authservice.POJO.ResponsePOJO;
import com.blogserver.authservice.service.JwtUtil;
import com.blogserver.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtUtil.generateToken(userDetails);
            HashMap<String, Object> obj = new HashMap<>();
            obj.put("token", token);
            obj.put("user",userService.loadUserByEmail(loginRequest.getUsername()));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            System.out.println(loginRequest);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePOJO(e.getMessage()));
        }
    }



}