package com.project.blogserver.entiity;

import lombok.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity author;

    private String title;
    private  String image;

    private Long wordCount;
    private String story;
    private Date createdAt;
    private Date updatedAt;
    private HashSet<Long> views;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

}
