package com.pieropan.networksocial.secutiry;

import com.pieropan.networksocial.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AuthController {

    @Autowired
    AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<UsersDto> login(@RequestBody UsersDto user) {
        var token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        var authenticatiomanager = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}