package com.youdoglab.imobiliaria;

import com.youdoglab.imobiliaria.modelo.*;
import com.youdoglab.imobiliaria.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ImobiliariaApplication implements CommandLineRunner {

    @Autowired
    private ImovelRepository imovelRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImobiliariaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Imovel imovel1 = new Imovel();
        Endereco endereco = new Endereco();
        endereco.setBairro("Bairro Teste");
        endereco.setCep("75.570-000");
        endereco.setCidade("Bom Jesus de Goias");
        endereco.setComplemento("teste");
        endereco.setBairro("bairro");
        endereco.setLogradouro(Logradouro.RUA);
        endereco.setEstado("GO");
        endereco.setImovel(imovel1);
        endereco.setNumero("3333");

        imovel1.setEndereco(endereco);

        Caracteristicas caracteristicas = new Caracteristicas();
        caracteristicas.setImovel(imovel1);
        caracteristicas.setQuantidadeBanheiros(1);
        caracteristicas.setQuantidadeQuartos(2);
        caracteristicas.setQuantidadeSalas(3);
        caracteristicas.setQuantidadeVagasGaragem(4);

        imovel1.setCaracteristicas(caracteristicas);
        imovel1.setTipoNegocio(TipoNegocio.ALUGAR);
        imovel1.setValorNegocio(BigDecimal.valueOf(800));

        imovelRepository.save(imovel1);
    }
}
