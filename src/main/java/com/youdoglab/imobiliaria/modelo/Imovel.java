package com.youdoglab.imobiliaria.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "imovel")
    private Endereco endereco;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "imovel")
    private Caracteristicas caracteristicas;

    private BigDecimal valorNegocio;

    @Enumerated(EnumType.STRING)
    private TipoNegocio tipoNegocio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return Objects.equals(id, imovel.id) &&
                Objects.equals(endereco, imovel.endereco) &&
                Objects.equals(caracteristicas, imovel.caracteristicas) &&
                Objects.equals(valorNegocio, imovel.valorNegocio) &&
                tipoNegocio == imovel.tipoNegocio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endereco, caracteristicas, valorNegocio, tipoNegocio);
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", caracteristicas=" + caracteristicas +
                ", valorNegocio=" + valorNegocio +
                ", tipoNegocio=" + tipoNegocio +
                '}';
    }
}
