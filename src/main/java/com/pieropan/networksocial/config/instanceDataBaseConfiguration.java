package com.pieropan.networksocial.config;

import com.pieropan.networksocial.domain.ComplementaryData;
import com.pieropan.networksocial.domain.Post;
import com.pieropan.networksocial.domain.Users;
import com.pieropan.networksocial.enums.CategoryEnum;
import com.pieropan.networksocial.enums.ModalityEnum;
import com.pieropan.networksocial.enums.SchoolingEnum;
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
    PostRepostirory postRepostirory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public void instanceDataBase() {
        if (userRepository.findAll().isEmpty()) {
            Users userMatheus = new Users("Matheus Pieropan", "matheuspieropan",
                    passwordEncoder.encode("123"), "matheus.2015jf@hotmail.com", 'M', false);

            Users userSamira = new Users("Samira Pieropan", "samirapieropan",
                    passwordEncoder.encode("123"), "samiliralira@gmail.com", 'F', false);

            Users userPedro = new Users("Pedro Rocha", "pedrorocha",
                    passwordEncoder.encode("123"), "pedrorocha@hotmail.com", 'M',false);

            userRepository.saveAll(Arrays.asList(userMatheus, userSamira, userPedro));

            Post postTech = new Post("Desenvolvedor JAVA -  Trabalho remoto!", """
                            Participar das discussões sobre arquitetura de sistemas.
                            • Traduzir requisitos do negócio em arquiteturas e sistemas.
                            • Participar da execução de soluções para a plataforma de microsserviços.
                            • Participar da pesquisa e implantação de novas tecnologias.
                            • Interagir com outras áreas para garantir a integração das ferramentas.
                            • Cuidar da monitoração do ambiente e criar ações proativas que garantam a saúde da plataforma.
                            • Interagir com a equipe de segurança para garantir a confiabilidade da plataforma.
                            • Criar ferramentas para garantir que os recursos estão sendo utilizados de forma consciente.
                            • Participar nas melhorias do processo de desenvolvimento técnico do time (DoJo, Pair, entre outras).
                    """, new Date(), userMatheus, new ComplementaryData(CategoryEnum.TECNOLOGIA.getName(),
                    SchoolingEnum.ENSINO_SUPERIOR_COMPLETO.getName(), ModalityEnum.PJ.name(), "Empresa XPTO", "Remoto", "Remoto",
                    """
                            Salário CLT Full;
                            Vale Refeição ou Alimentação (Alelo);
                            Vale Transporte (sempre que houver o deslocamento);
                            Auxílio Home Office (proporcional aos dias em que atuará nesta modalidade);
                            Assistência Médica Sulamérica;
                            Assistência Odontológica Sulamérica;
                            Seguro de Vida;
                            Parcerias (Curso de idiomas, ensino, livraria, restaurante, entre outras);
                            Gympass;
                            Allya;
                            Day Off;
                            Premiação por indicações;
                            Inside Out (Ocorre todas as sextas-feiras. Evento da galera voltado para troca de conhecimento);
                            Oportunidade de crescimento profissional.
                            """));

            Post postServ = new Post("Auxiliar de Limpeza -  Trabalho presencial juiz de fora!", """
                    Ensino médio completo; Experiência com serviços de limpeza e higienização, preferencialmente em ambientes públicos;
                    """, new Date(), userSamira, new ComplementaryData(CategoryEnum.SERVIOS_GERAIS.getName(),
                    SchoolingEnum.ENSINO_MEDIO_COMPLETO.getName(), ModalityEnum.CLT.name(), "Empresa ABCD", "São Paulo", "", ""));

            Post postAdm = new Post("Estagiário em Administração", "Estagio para estudante de administração entre 4° e 8° período", new Date(),
                    userPedro, new ComplementaryData(CategoryEnum.ADMINISTRACAO.getName(),
                    SchoolingEnum.ENSINO_SUPERIOR_COMPLETO.getName(), ModalityEnum.CLT.name(), "Empresa um dois três", "Rio de janeiro!", "", ""));

            postRepostirory.saveAll(Arrays.asList(postTech, postServ, postAdm));
        }
    }
}