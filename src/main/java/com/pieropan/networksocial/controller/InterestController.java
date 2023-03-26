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
    @GetMapping("/{idPost}/{idUser}")
    public ResponseEntity interestCandidate(@PathVariable Long idPost, @PathVariable Long idUser) {

        interestService.interestCandidate(idPost, idUser);
        return ResponseEntity.ok().build();
    }
}