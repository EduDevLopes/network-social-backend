package com.pieropan.networksocial.enums;

import lombok.Getter;

@Getter
public enum SchoolingEnum {
    ENSINO_MEDIO_COMPLETO("Ensino Médio Completo"),
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"),
    ENSINO_SUPERIOR_COMPLETO("Ensino Superior Completo"),
    ENSINO_SUPERIOR_INCOMPLETO("Ensino Superior Incompleto"),
    POS_GRADUCAO_INCOMPLETA("Pós-Graduação Completa"),
    POS_GRADUCAO_COMPLETA("Pós-Graduação Incompleta");

    private String name;

    SchoolingEnum(String name) {
        this.name = name;
    }
}