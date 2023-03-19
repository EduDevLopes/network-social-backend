package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.UsersDto;
import com.pieropan.networksocial.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsersDto save(UsersDto dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Users users = modelMapper.map(dto, Users.class);
        return modelMapper.map(repository.save(users), UsersDto.class);
    }

    public UsersDto findById(Long id) {
        return modelMapper.map(repository.findById(id).get(), UsersDto.class);
    }
}