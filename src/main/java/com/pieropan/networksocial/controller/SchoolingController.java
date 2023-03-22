package com.pieropan.networksocial.controller;

import com.pieropan.networksocial.dto.SchoolingDto;
import com.pieropan.networksocial.service.SchoolingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schooling")
public class SchoolingController {

    @Autowired
    SchoolingService service;

    @GetMapping
    public ResponseEntity<List<SchoolingDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}