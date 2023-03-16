package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.repository.PostRepostirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepostirory repostirory;

    public List<Post> findAll(){
        return repostirory.findAll();
    }
}