package com.pieropan.networksocial.secutiry;

import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    TokenService tokenService;

    public String login(UsersDto user) {
        var token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        var authenticatiomanager = manager.authenticate(token);
        return tokenService.generateToken((Users) authenticatiomanager.getPrincipal());
    }
}