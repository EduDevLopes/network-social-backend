package com.pieropan.networksocial.enums;

import lombok.Getter;

@Getter
public enum SchoolingEnum {
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"),
    ENSINO_MEDIO_COMPLETO("Ensino Médio Completo"),
    ENSINO_SUPERIOR_INCOMPLETO("Ensino Superior Incompleto"),
    ENSINO_SUPERIOR_COMPLETO("Ensino Superior Completo"),
    POS_GRADUCAO_COMPLETA("Pós-Graduação Incompleta"),
    POS_GRADUCAO_INCOMPLETA("Pós-Graduação Completa");

    private String name;

    SchoolingEnum(String name) {
        this.name = name;
    }
}