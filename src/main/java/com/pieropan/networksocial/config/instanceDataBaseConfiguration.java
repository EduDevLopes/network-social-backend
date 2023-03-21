package com.pieropan.networksocial.config;

import com.pieropan.networksocial.domain.Category;
import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.repository.CategoryRepository;
import com.pieropan.networksocial.repository.PostRepostirory;
import com.pieropan.networksocial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class instanceDataBaseConfiguration {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PostRepostirory postRepostirory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public void instanceDataBase() {
        if (userRepository.findAll().isEmpty()) {
            Users userMatheus = new Users("Matheus Pieropan", "matheuspieropan",
                    passwordEncoder.encode("123"), "matheus.2015jf@hotmail.com", 'M');

            Users userSamira = new Users("Samira Pieropan", "samirapieropan",
                    passwordEncoder.encode("123"), "samiliralira@gmail.com", 'F');

            Users userPedro = new Users("Pedro Rocha", "pedrorocha",
                    passwordEncoder.encode("123"), "pedrorocha@hotmail.com", 'M');

            userRepository.saveAll(Arrays.asList(userMatheus, userSamira, userPedro));

            Category categoryTec = new Category("Tecnologia");
            Category categoryServ = new Category("Serviços Gerais");
            Category categoryAdm = new Category("Administração");

            categoryRepository.saveAll(Arrays.asList(categoryTec, categoryServ, categoryAdm));

            Post postTech = new Post("Desenvolvedor JAVA -  Trabalho remoto!", "Participar das discussões sobre arquitetura de sistemas.\n" +
                    "• Traduzir requisitos do negócio em arquiteturas e sistemas.\n" +
                    "• Participar da execução de soluções para a plataforma de microsserviços.\n" +
                    "• Participar da pesquisa e implantação de novas tecnologias.\n" +
                    "• Interagir com outras áreas para garantir a integração das ferramentas.\n" +
                    "• Cuidar da monitoração do ambiente e criar ações proativas que garantam a saúde da plataforma.\n" +
                    "• Interagir com a equipe de segurança para garantir a confiabilidade da plataforma.\n" +
                    "• Criar ferramentas para garantir que os recursos estão sendo utilizados de forma consciente.\n" +
                    "• Participar nas melhorias do processo de desenvolvimento técnico do time (DoJo, Pair, entre outras).", new Date(),
                    userMatheus, categoryTec);

            Post postServ = new Post("Auxiliar de Limpeza -  Trabalho presencial juiz de fora!", "Escolaridade mí\u00ADnima: Ensino Fundamental concluí\u00ADdo. Obrigatória experiência comprovada na área de limpeza. Ter boa comunicação e relação interpessoal. Disponibilidade para trabalhar em diferentes escalas, horários e postos.", new Date(),
                    userSamira, categoryServ);

            Post postAdm = new Post("Estagiário em Administração", "Estagio para estudante de administração entre 4° e 8° período", new Date(),
                    userPedro, categoryAdm);

            postRepostirory.saveAll(Arrays.asList(postTech, postServ, postAdm));
        }

    }
}