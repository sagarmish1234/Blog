package com.blogserver.articleservice.proxy;

import com.blogserver.articleservice.POJO.ResponsePOJO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "auth-service")
public interface AuthProxy {

    @GetMapping("/user/getByStaringName/{name}")
    public ResponseEntity<?> getUsersByName(@PathVariable String name);
}
