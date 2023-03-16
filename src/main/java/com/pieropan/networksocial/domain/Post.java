package com.pieropan.networksocial.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;
    private String title;
    private String description;
    private Date dateCreation;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;
}