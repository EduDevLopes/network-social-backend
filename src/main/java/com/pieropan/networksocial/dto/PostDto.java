package com.pieropan.networksocial.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    @Length(min = 5, max = 10, message = "Campo título deve possuir entre 5 a 10 caracteres.")
    private String title;
    @Length(min = 5, max = 10, message = "Campo descrição deve possuir entre 50 a 255 caracteres.")
    private String description;
    private Date dateCreation;
}