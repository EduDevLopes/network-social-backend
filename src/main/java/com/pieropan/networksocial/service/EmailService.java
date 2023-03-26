package com.pieropan.networksocial.service;

import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.dto.EmailDto;
import com.pieropan.networksocial.dto.UsersDto;
import com.pieropan.networksocial.feignclient.MicroServiceEmail;
import com.pieropan.networksocial.repository.PostRepostirory;
import com.pieropan.networksocial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.email.from}")
    String emailFrom;

    @Autowired
    MicroServiceEmail microServiceEmail;

    @Autowired
    PostRepostirory postRepostirory;

    @Autowired
    UsersRepository usersRepository;

    public void sendEmailCandidate(Long idPost, Long idUser){
        Post post = postRepostirory.findById(idPost).get();

        String emailCandidate = usersRepository.findById(idUser).get().getEmail();
        String emailTo =  post.getUsers().getEmail();
        String subject = "CANDIDATO PARA VAGA: " + post.getTitle();

        StringBuilder sb =
                new StringBuilder("Olá, tudo bem? Alguém se interrou no seu anúncio. ").
                append("Entrar em contato: ").append(emailCandidate);

        microServiceEmail.send(new EmailDto(emailFrom, emailTo, subject, sb.toString()));
    }

    public void sendWelcome(UsersDto usersDto){
        microServiceEmail.send(EmailDto.buildEmailDto(usersDto));
    }
}