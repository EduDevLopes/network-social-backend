package com.pieropan.networksocial.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComplementaryDataDto {
    @NotBlank(message = "Campo Categoria de preenchimento obrigatório!")
    private String category;

    @NotBlank(message = "Campo Escolaridade de preenchimento obrigatório!")
    private String schooling;

    @NotBlank(message = "Campo Modalidade de contratação de preenchimento obrigatório!")
    private String modality;

    @NotBlank(message = "Campo Nome da empresa de preenchimento obrigatório!")
    private String company;

    @NotBlank(message = "Campo Localização de preenchimento obrigatório!")
    private String location;

    @NotBlank(message = "Campo Localização de preenchimento obrigatório!")
    private String requirements;

    @NotBlank(message = "Campo Benefícios de preenchimento obrigatório!")
    private String benefits;
}