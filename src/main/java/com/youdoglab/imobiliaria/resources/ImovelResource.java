package com.youdoglab.imobiliaria.resources;

import com.youdoglab.imobiliaria.modelo.Imovel;
import com.youdoglab.imobiliaria.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelResource {

    @Autowired
    private ImovelService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Imovel> find(@PathVariable Integer id){

        Imovel obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
