package com.pieropan.networksocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginSucessDto {
    private String token;
    private Long idUser;
    private String nameUser;
}