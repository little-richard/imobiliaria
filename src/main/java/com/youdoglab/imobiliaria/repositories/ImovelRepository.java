package com.youdoglab.imobiliaria.repositories;

import com.youdoglab.imobiliaria.modelo.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

}
