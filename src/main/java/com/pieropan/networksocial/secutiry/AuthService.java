package com.pieropan.networksocial.secutiry;

import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.LoginSucessDto;
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

    public LoginSucessDto login(UsersDto user) {

        var authenticatiomanager = manager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getLogin(), user.getPassword()));

        Users users = (Users) authenticatiomanager.getPrincipal();
        String token = tokenService.generateToken(users);

        return new LoginSucessDto(token, users.getId());
    }
}