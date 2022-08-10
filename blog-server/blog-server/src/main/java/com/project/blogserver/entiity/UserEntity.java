package com.project.blogserver.entiity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private Date createdAt;
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArticleEntity> articles;
}
