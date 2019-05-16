package com.youdoglab.imobiliaria.modelo;

import lombok.Getter;


@Getter
public enum Logradouro {
    AVENIDA("Avenida"),
    RUA("Rua");

    private String label;

    Logradouro(String logradouro){
        this.label = logradouro;
    }

    @Override
    public String toString() {
        return label;
    }
}
