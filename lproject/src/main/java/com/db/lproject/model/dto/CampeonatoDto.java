package com.db.lproject.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class CampeonatoDto {
   private String NomeCompeonato;
   private String modalidade;
   private List<TimesDto> times;
}
