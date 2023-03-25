package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.EmailDto;
import com.pieropan.networksocial.http.MicroServiceEmail;
import com.pieropan.networksocial.repository.PostRepostirory;
import com.pieropan.networksocial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService {

    @Autowired
    MicroServiceEmail microServiceEmail;

    @Autowired
    PostRepostirory postRepostirory;

    @Autowired
    UsersRepository usersRepository;

    public void interestPost(Long idPost, Long idUser){

        Post post = postRepostirory.findById(idPost).get();
        Users user = usersRepository.findById(idUser).get();

        String subject = "CANDITADO PARA VAGA " + post.getTitle();
        String bodyEmail = "Há um interessado pela vaga " + post.getTitle() +
                "Entrar em contato pelo e-mail: " + user.getEmail();

        microServiceEmail.send(new EmailDto("matheus.pieropan@viannasempre.com.br",
                post.getUsers().getEmail(), subject, bodyEmail));
    }
}