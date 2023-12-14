package com.db.lproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.lproject.model.dto.res.JogadoresRes;
import com.db.lproject.model.dto.res.TimesRes;
import com.db.lproject.model.entitys.Jogador;
import com.db.lproject.model.entitys.Times;
import com.db.lproject.model.repositories.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/get")
public class Info {

    @Autowired
    private Repository repository;
    
    @GetMapping("/all/jogadores")
    public ResponseEntity<JogadoresRes> getAllJogadores() {
        List<Jogador> jogadores = repository.getJogadorReposritory().findAll();
        return ResponseEntity.ok().body(new JogadoresRes(jogadores));
    }

    @GetMapping("/all/times")
    public ResponseEntity<TimesRes> getAllTimes() {
        List<Times> times = repository.getTimesRepository().findAll();
        return ResponseEntity.ok().body(new TimesRes(times));
    }
    
}
