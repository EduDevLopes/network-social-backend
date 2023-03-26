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
    EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsersDto save(UsersDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users user = modelMapper.map(userDto, Users.class);
        user = repository.save(user);

        emailService.sendWelcome(userDto);
        return modelMapper.map(user, UsersDto.class);
    }

    public UsersDto findById(Long id) {
        return modelMapper.map(repository.findById(id).get(), UsersDto.class);
    }
}