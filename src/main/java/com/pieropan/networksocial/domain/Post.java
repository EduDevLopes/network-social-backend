package com.pieropan.networksocial.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(length = 5000)
    private String description;
    private Date dateCreation;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    private String modality;

    public Post(String title, String description, Date dateCreation, Users users, Category category) {
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.users = users;
        this.category = category;
    }

    public Post() {

    }
}