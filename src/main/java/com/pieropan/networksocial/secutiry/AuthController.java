package com.pieropan.networksocial.secutiry;

import com.pieropan.networksocial.dto.LoginSucessDto;
import com.pieropan.networksocial.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping
    public ResponseEntity<LoginSucessDto> login(@RequestBody UsersDto user) {
        return ResponseEntity.ok(service.login(user));
    }
}