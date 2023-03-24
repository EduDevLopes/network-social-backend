package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.dto.PostDto;
import com.pieropan.networksocial.repository.PostRepostirory;
import com.pieropan.networksocial.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepostirory postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsersRepository userRepository;

    public List<PostDto> findAll() {

        return postRepository.findAllByOrderByIdDesc().stream().
                map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    public PostDto findById(Long id) {

        return  modelMapper.map(postRepository.findById(id), PostDto.class);
    }

    public List<PostDto>  findAllByUser(Long idUser) {

        return postRepository.findAllByUsersId(idUser, Sort.by(Sort.Direction.DESC, "id")).stream().
                map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    public PostDto save(PostDto postDto, Long idUser) {
        Post post = generatePost(postDto, idUser);

        return modelMapper.map(postRepository.save(post), PostDto.class);
    }

    Post generatePost(PostDto postDto, Long idUser) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setUsers(userRepository.findById(idUser).get());
        post.setDateCreation(new Date());

        return post;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}