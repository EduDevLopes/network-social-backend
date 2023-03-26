package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Interest;
import com.pieropan.networksocial.repository.InterestServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService {

    @Autowired
    InterestServiceRepository interestServiceRepository;

    @Autowired
    EmailService emailService;

    public void interestCandidate(Long idPost, Long idUser) {
        interestServiceRepository.save(new Interest(idPost, idUser));
        emailService.sendEmailCandidate(idPost, idUser);
    }
}