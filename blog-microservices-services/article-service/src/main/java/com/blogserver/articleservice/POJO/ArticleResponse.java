package com.blogserver.articleservice.POJO;

import com.blogserver.articleservice.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {
    private Long id;
    private ArticleUserResponse author;
    private String title;
    private String image;
    private Long wordCount;
    private String story;
    private Date createdAt;
    private HashSet<Long> views;
    private String category;
}
