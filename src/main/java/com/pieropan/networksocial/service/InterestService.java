package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.dto.EmailDto;
import com.pieropan.networksocial.http.MicroServiceEmail;
import com.pieropan.networksocial.repository.PostRepostirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService {

    @Autowired
    MicroServiceEmail microServiceEmail;

    @Autowired
    PostRepostirory postRepostirory;

    public void interestPost(Long idPost, String email){

        Post post = postRepostirory.findById(idPost).get();
        String subject = "CANDITADO PARA VAGA " + post.getTitle();
        String bodyEmail = "Há um interessado pela vaga " + post.getTitle() +
                "Entrar em contato pelo e-mail: " + email;

        microServiceEmail.send(new EmailDto("matheus.pieropan@viannasempre.com.br",
                post.getUsers().getEmail(), subject, bodyEmail));
    }
}