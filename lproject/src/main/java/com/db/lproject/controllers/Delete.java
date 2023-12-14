package com.db.lproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.lproject.services.ServicesAll;

@RestController
@RequestMapping("/api/delete")
public class Delete {

    @Autowired
    private ServicesAll servicesAll;
    
    @DeleteMapping("jogador/{name}")
    public void deleteJogador(@PathVariable String name){
        servicesAll.getJogadorServices().delete(name);
    }

    @DeleteMapping("time/{name}")
    public void deleteTime(@PathVariable String name){
        servicesAll.getTimesServices().delete(name);
    }

    @DeleteMapping("campeonato/{name}")
    public void deleteCampeonato(@PathVariable String name){
        servicesAll.getCampeonatoService().delete(name);
    }

}
