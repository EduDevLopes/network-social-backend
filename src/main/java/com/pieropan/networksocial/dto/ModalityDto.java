package com.pieropan.networksocial.dto;

import lombok.Data;

@Data
public class ModalityDto {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}