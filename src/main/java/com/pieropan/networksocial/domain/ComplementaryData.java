package com.pieropan.networksocial.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "complementary_data")
public class ComplementaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_complementary_data")

    private Long id;

    private String category;

    private String schooling;

    private String modality;

    private String company;

    private String location;

    @Column(columnDefinition="TEXT")
    private String requirements;

    @Column(columnDefinition="TEXT")
    private String benefits;

    public ComplementaryData(String category, String schooling, String modality,
                             String company, String location, String requirements, String benefits) {
        this.category = category;
        this.schooling = schooling;
        this.modality = modality;
        this.company = company;
        this.location = location;
        this.requirements = requirements;
        this.benefits = benefits;
    }

    public ComplementaryData() {}
}