package com.pieropan.networksocial.dto;

import jakarta.validation.Valid;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Data
public class PostDto {
    private Long id;

    @Length(min = 10, max = 38, message = "Campo título deve possuir entre 10 e 38 caracteres.")
    private String title;

    @Length(min = 50, max = 255, message = "Campo descrição deve possuir entre 50 a 255 caracteres.")
    private String description;

    private Date dateCreation;
    private UsersDto users;

    @Valid
    private ComplementaryDataDto complementaryData;
    private List<InterestDto> interests;
}