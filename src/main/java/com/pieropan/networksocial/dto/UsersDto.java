package com.pieropan.networksocial.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersDto {
    private Long id;

    @NotBlank(message = "É necessário informar seu nome!")
    private String name;

    @NotBlank(message = "É necessário informar o login!")
    private String login;

    @NotBlank(message = "É necessário informar a senha!")
    private String password;

    @NotBlank(message = "É necessário selecionar o gênero!")
    private String gender;

    private String email;
    private boolean iscandidate;
}