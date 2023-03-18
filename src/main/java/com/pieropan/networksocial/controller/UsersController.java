package com.pieropan.networksocial.controller;

import com.pieropan.networksocial.dto.UsersDto;
import com.pieropan.networksocial.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/user")
public class UsersController {

    @Autowired
    UsersService service;

    @PostMapping
    public ResponseEntity<UsersDto> save(@RequestBody UsersDto usersDto, UriComponentsBuilder uriBuilder){

        UsersDto user = service.save(usersDto);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}