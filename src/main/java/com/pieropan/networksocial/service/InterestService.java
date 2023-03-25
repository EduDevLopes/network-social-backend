package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.dto.EmailDto;
import com.pieropan.networksocial.feignclient.MicroServiceEmail;
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
        String subject = "CANDITADO PARA VAGA: " + post.getTitle().toLowerCase();

        String html = """ 
                <html>
                    <body>
                            <p>Olá, tudo bem?<p> <br>
                            Alguém se interrou no seu anúncio. Entrar em contato: <b>email<b><br><br>
                            <img src="https://vagaspieropan.vercel.app/assets/images/icons8-procurar-empregos-80.png">
                    <body>
                <html>
                """;

        microServiceEmail.send(new EmailDto("matheus.pieropan@viannasempre.com.br",
                post.getUsers().getEmail(), subject, html.replace("email", user.getEmail())));
    }
}