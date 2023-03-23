package com.pieropan.networksocial.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComplementaryDataDto {
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