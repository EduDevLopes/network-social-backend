package com.pieropan.networksocial.service;

import com.pieropan.networksocial.dto.CategoryDto;
import com.pieropan.networksocial.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<CategoryDto> findAll() {

        return categoryRepository.findAllByOrderByNameDesc().stream().
                map(p -> modelMapper.map(p, CategoryDto.class)).collect(Collectors.toList());
    }
}