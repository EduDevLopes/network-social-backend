package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.dto.PostDto;
import com.pieropan.networksocial.repository.PostRepostirory;
import com.pieropan.networksocial.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepostirory repostitory;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsersRepository repository;

    public List<Post> findAll() {

        return repostitory.findAllByOrderByIdDesc();
    }

    public PostDto save(PostDto postDto, Long idUser) {
        Post post = generatePost(postDto, idUser);

        return modelMapper.map(repostitory.save(post), PostDto.class);
    }

    Post generatePost(PostDto postDto, Long idUser) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setUsers(repository.findById(idUser).get());
        post.setDateCreation(new Date());

        return post;
    }
}