package com.blogserver.articleservice.controller;

import com.blogserver.articleservice.POJO.ResponsePOJO;
import com.blogserver.articleservice.proxy.AuthProxy;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    AuthProxy authProxy;

    @GetMapping("/getUsers/{name}")
    public ResponseEntity<?> getUsers(@PathVariable String name) {
        try {
            ResponseEntity<?> users = authProxy.getUsersByName(name);
            return users;
        } catch (FeignException f) {
            if (f.status() == 404)
                return ResponseEntity.status(404).body(new ResponsePOJO("No users found"));
            else
                return ResponseEntity.status(400).body(new ResponsePOJO("Bad Request"));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponsePOJO(e.getMessage()));
        }
    }

}
