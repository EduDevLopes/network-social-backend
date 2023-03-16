package com.pieropan.networksocial.dto;

import lombok.Data;

@Data
public class UsersDto {
    private Long id;
    private String name;
    private String login;
    private String password;
}