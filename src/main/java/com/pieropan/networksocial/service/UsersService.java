package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.UsersDto;
import com.pieropan.networksocial.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public UsersDto save(UsersDto dto){
        Users user = modelMapper.map(dto, Users.class);
        return modelMapper.map(repository.save(user), UsersDto.class);
    }

}