package com.pieropan.networksocial.enums;

import lombok.Getter;

@Getter
public enum CategoryEnum {

    TECNOLOGIA(1,"Tecnologia"),
    SERVIOS_GERAIS(2,"Serviços Gerais"),
    ADMINISTRACAO(3,"Administração");

     Integer id;
    private String name;

    CategoryEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}