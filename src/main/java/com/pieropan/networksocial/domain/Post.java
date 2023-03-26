package com.pieropan.networksocial.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_complementary_data")
    @Cascade(CascadeType.ALL)
    private ComplementaryData complementaryData;

    @OneToMany(mappedBy = "idPost")
    private List<Interest> interests;

    public Post(String title, String description, Date dateCreation, Users users, ComplementaryData data) {
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.users = users;
        this.complementaryData = data;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + '}';
    }
}