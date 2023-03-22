package com.pieropan.networksocial.controller;

import com.pieropan.networksocial.dto.PostDto;
import com.pieropan.networksocial.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<PostDto>> findAllByUser(@PathVariable  Long idUser) {
        return ResponseEntity.ok(service.findAllByUser(idUser));
    }

    @PostMapping("/user/{idUser}")
    public ResponseEntity<PostDto> save(@RequestBody @Validated PostDto postDto,
                                        @PathVariable  Long idUser,
                                        UriComponentsBuilder uriBuilder){

        PostDto post = service.save(postDto, idUser);
        var uri = uriBuilder.path("/post/{id}").buildAndExpand(postDto.getId()).toUri();

        return ResponseEntity.created(uri).body(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}