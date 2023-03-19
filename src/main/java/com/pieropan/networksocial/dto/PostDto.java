package com.pieropan.networksocial.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private Date dateCreation;
    private UsersDto users;
}