package com.youdoglab.imobiliaria.modelo;

import lombok.Getter;

@Getter
public enum TipoNegocio {
    ALUGAR("Alugar"),
    VENDER("Vender");

    private String label;

    TipoNegocio(String tipo){
        this.label = tipo;
    }

    @Override
    public String toString() {
        return label;
    }

}
