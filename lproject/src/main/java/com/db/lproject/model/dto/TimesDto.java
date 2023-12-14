package com.db.lproject.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class TimesDto {
    private String nomeTime;
    private Integer nJogadores;
    private String CampeonatoNome;
    private List<JogadorDto> jogadores;
}
