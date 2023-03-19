package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.dto.PostDto;
import com.pieropan.networksocial.repository.PostRepostirory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepostirory repostitory;

    @Autowired
    ModelMapper modelMapper;

    public List<Post> findAll(){
        return repostitory.findAll();
    }

    public PostDto save(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return modelMapper.map(repostitory.save(post), PostDto.class);
    }
}