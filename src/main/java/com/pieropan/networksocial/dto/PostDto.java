package com.pieropan.networksocial.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Categoria de preenchimento obrigatório!")
    private String category;

    @NotBlank(message = "Escolaridade de preenchimento obrigatório!")
    private String schooling;

    @NotBlank(message = "Modalidade de contratação de preenchimento obrigatório!")
    private String modality;

    @NotBlank(message = "Nome da empresa de preenchimento obrigatório!")
    private String company;

    @NotBlank(message = "Localização de preenchimento obrigatório!")
    private String location;
}