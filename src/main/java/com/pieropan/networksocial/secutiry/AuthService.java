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

    public LoginSucessDto login(UsersDto userDto) {

        var authenticatiomanager = manager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getLogin(), userDto.getPassword()));

        Users user = (Users) authenticatiomanager.getPrincipal();
        String token = tokenService.generateToken(user);

        return new LoginSucessDto(token, user.getId(), user.getName());
    }
}