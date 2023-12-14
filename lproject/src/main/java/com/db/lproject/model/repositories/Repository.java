package com.db.lproject.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Repository {

    @Autowired
    private CampeonatosRepository campeonatosRepository;

    @Autowired
    private TimesRepository timesRepository;

    @Autowired
    private JogadorReposritory jogadorReposritory;
}
