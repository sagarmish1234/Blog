package com.blogserver.articleservice.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUserResponse {

    private String email;
    private String fullName;
    private String image;
}
