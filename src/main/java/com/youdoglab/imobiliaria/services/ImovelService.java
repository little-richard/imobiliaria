package com.youdoglab.imobiliaria.services;

import com.youdoglab.imobiliaria.modelo.Imovel;
import com.youdoglab.imobiliaria.repositories.ImovelRepository;
import com.youdoglab.imobiliaria.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    public Imovel buscar(Integer id){
        Optional<Imovel> obj = repository.findById(id);

        return obj.orElseThrow(()->
                new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Imovel.class.getName()));
    }
}
