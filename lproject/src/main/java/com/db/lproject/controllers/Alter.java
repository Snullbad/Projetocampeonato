package com.db.lproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.lproject.model.dto.JogadorDto;
import com.db.lproject.model.dto.TimesDtoAlter;
import com.db.lproject.services.ServicesAll;

@RestController
@RequestMapping("api/alter")
public class Alter {
    
    @Autowired
    private ServicesAll servicesAll;

    @PutMapping("jogador/{name}")
    public ResponseEntity<?> alterJogador(@RequestBody JogadorDto dto, @PathVariable String name){
        try {
            servicesAll.getJogadorServices().alter(dto, name);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    
    @PutMapping("time/{name}")
    public ResponseEntity<?> alterTime(@RequestBody TimesDtoAlter dto, @PathVariable String name){
        try {
            servicesAll.getTimesServices().alter(name, dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }



    
}
