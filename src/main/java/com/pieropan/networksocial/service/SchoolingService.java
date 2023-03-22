package com.pieropan.networksocial.service;

import com.pieropan.networksocial.dto.SchoolingDto;
import com.pieropan.networksocial.enums.SchoolingEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolingService {

    @Autowired
    ModelMapper modelMapper;

    public List<SchoolingDto> findAll() {

        return Arrays.stream(SchoolingEnum.values()).
                map(p-> modelMapper.map(p,SchoolingDto.class)).collect(Collectors.toList());
    }
}