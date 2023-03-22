package com.pieropan.networksocial.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class PostDto {
    private Long id;

    @Length(min = 10, max = 80, message = "Campo título deve possuir entre 10 a 80 caracteres.")
    private String title;

    @Length(min = 50, max = 255, message = "Campo descrição deve possuir entre 50 a 255 caracteres.")
    private String description;

    private Date dateCreation;
    private UsersDto users;
    private CategoryDto category;
    private SchoolingDto schooling;
    private String modality;
}