package com.pieropan.networksocial.domain;

import com.pieropan.networksocial.enums.CategoryEnum;
import com.pieropan.networksocial.enums.ModalityEnum;
import com.pieropan.networksocial.enums.SchoolingEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;
    private String title;
    @Column(length = 5000)
    private String description;
    private Date dateCreation;
    private ModalityEnum modality;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    private SchoolingEnum schooling;

    public Post(String title, String description, Date dateCreation, Users users,
                CategoryEnum category, ModalityEnum modality) {
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.users = users;
        this.category = category;
        this.modality = modality;
    }
}