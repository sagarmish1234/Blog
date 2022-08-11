package com.project.blogserver.entiity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Entity
@Getter
@Setter
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
    private String story;
    private Date createdAt;
    private Date updatedAt;
    private HashSet<Long> views;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

}
