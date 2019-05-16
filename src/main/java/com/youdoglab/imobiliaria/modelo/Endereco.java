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
public class Endereco implements Serializable {

    @Id
    private Integer id;

    private String estado;

    private String cidade;

    private String bairro;

    private String complemento;

    private String numero;

    @Enumerated(value = EnumType.STRING)
    private Logradouro logradouro;

    private String cep;

    @JsonBackReference
    @JoinColumn(name = "imovel_id")
    @OneToOne
    @MapsId
    private Imovel imovel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) &&
                Objects.equals(estado, endereco.estado) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(complemento, endereco.complemento) &&
                Objects.equals(numero, endereco.numero) &&
                logradouro == endereco.logradouro &&
                Objects.equals(cep, endereco.cep) &&
                Objects.equals(imovel, endereco.imovel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, cidade, bairro, complemento, numero, logradouro, cep, imovel);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero='" + numero + '\'' +
                ", logradouro=" + logradouro +
                ", cep='" + cep + '\'' +
                ", imovel=" + imovel +
                '}';
    }
}
