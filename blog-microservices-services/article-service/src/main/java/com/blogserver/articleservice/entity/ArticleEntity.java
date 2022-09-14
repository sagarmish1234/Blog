package com.blogserver.articleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long author_id;

    private String title;
    private String image;

    private Long wordCount;
    @Column(columnDefinition = "LONGTEXT")
    private String story;
    private Date createdAt;
    private Date updatedAt;
    private HashSet<Long> views;
    private Long category_id;

}