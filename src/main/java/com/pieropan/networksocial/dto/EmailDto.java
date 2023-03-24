package com.pieropan.networksocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDto {

    private String emailFrom;
    private String emailTo;
    private String subject;
    private String bodyEmail;

    public static EmailDto buildEmailDto(UsersDto dto){
        return new EmailDto("matheus.pieropan@viannasempre.com.br",
                dto.getEmail(), "BEM VINDO ANUNCIANTE!",
                "Seu cadastro foi realizado com sucesso!");
    }
}