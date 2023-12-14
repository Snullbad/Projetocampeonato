package com.db.lproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.lproject.model.dto.CampeonatoDto;
import com.db.lproject.model.dto.JogadorDto;
import com.db.lproject.model.dto.TimesDto;
import com.db.lproject.services.ServicesAll;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/new")
public class New {

    @Autowired
    private ServicesAll servicesAll;
    
    @Operation(summary = "cadastrar um novo campeonato", description = "essa chamada irá cadastrar um unico campeonato(+jogadores / +times)", tags = "cadastro")
    @PostMapping("/campeonato")
    public ResponseEntity<?> novoCampeonato(@RequestBody CampeonatoDto dto){
        try {
            servicesAll.getCampeonatoService().CreateAndSave(dto, null, null);
            return ResponseEntity.ok().build(); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }


    @Operation(summary = "cadastrar um novo time", description = "essa chamada irá cadastrar um unico time(+jogadores)", tags = "cadastro")
    @PostMapping("/time")
    public ResponseEntity<?> novoTime(@RequestBody TimesDto dto){
        try {
            servicesAll.getTimesServices().CreateAndSave(dto, new ArrayList<>());
            return ResponseEntity.ok().build();
        } catch (Exception  e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @Operation(summary = "cadastrar um novo jogador", description = "essa chamada irá cadastrar um unico jogadore", tags = "cadastro")
    @PostMapping("/jogador")
    public ResponseEntity<?> novoJogador(@RequestBody JogadorDto dto){
         try {
            servicesAll.getJogadorServices().CreateAndSave(dto);
            return ResponseEntity.ok().build();
        } catch (Exception  e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

}
