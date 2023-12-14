package com.db.lproject.model.dto.res;

import java.util.ArrayList;
import java.util.List;

import com.db.lproject.model.entitys.Jogador;

import lombok.Data;

@Data
public class JogadoresRes {
    
    private List<InnerJogadoresRes> jogadores = new ArrayList<>();

    public JogadoresRes(List<Jogador> jogadorList){
        for (Jogador element : jogadorList) {
            jogadores.add(new InnerJogadoresRes(element));
        }
    }

    @Data
    public static class InnerJogadoresRes {
        private String nomeJogador;
        private Integer numero;
        private String nomeTime;

        public InnerJogadoresRes(Jogador jogador){
            this.nomeJogador = jogador.getNomeJogador();
            this.numero = jogador.getNumero();
            this.nomeTime = jogador.getTime().getNomeTime();
        }
    }
}
