package com.youdoglab.imobiliaria.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Caracteristicas implements Serializable {

    @Id
    private Integer id;

    private Integer quantidadeVagasGaragem;

    private Integer quantidadeBanheiros;

    private Integer quantidadeSalas;

    private Integer quantidadeQuartos;

    @JsonBackReference
    @JoinColumn(name = "imovel_id")
    @OneToOne
    @MapsId
    private Imovel imovel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristicas that = (Caracteristicas) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantidadeVagasGaragem, that.quantidadeVagasGaragem) &&
                Objects.equals(quantidadeBanheiros, that.quantidadeBanheiros) &&
                Objects.equals(quantidadeSalas, that.quantidadeSalas) &&
                Objects.equals(quantidadeQuartos, that.quantidadeQuartos) &&
                Objects.equals(imovel, that.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidadeVagasGaragem, quantidadeBanheiros, quantidadeSalas, quantidadeQuartos, imovel);
    }

    @Override
    public String toString() {
        return "Caracteristicas{" +
                "id=" + id +
                ", quantidadeVagasGaragem=" + quantidadeVagasGaragem +
                ", quantidadeBanheiros=" + quantidadeBanheiros +
                ", quantidadeSalas=" + quantidadeSalas +
                ", quantidadeQuartos=" + quantidadeQuartos +
                ", imovel=" + imovel +
                '}';
    }
}
