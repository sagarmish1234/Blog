package com.blogserver.articleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String image;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private Date createdAt;
    private String role;
}