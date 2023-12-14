package com.db.lproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ServicesAll {
    @Autowired
    private JogadorServices jogadorServices;

    @Autowired
    private TimesServices timesServices;

    @Autowired
    private CampeonatoService campeonatoService;
}
