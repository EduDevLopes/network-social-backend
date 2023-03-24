package com.pieropan.networksocial.controller;

import com.pieropan.networksocial.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/interest")
public class InterestController {

    @Autowired
    InterestService interestService;
    @GetMapping("/{idPost}/{email}")
    public ResponseEntity interestPost(@PathVariable Long idPost, @PathVariable String email) {

        interestService.interestPost(idPost, email);
        return ResponseEntity.ok().build();
    }
}