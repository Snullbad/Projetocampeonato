package com.db.lproject.model.dto.res;

import java.util.ArrayList;
import java.util.List;

import com.db.lproject.model.entitys.Times;

import lombok.Data;

@Data
public class TimesRes {

    private List<InnerTimesRes> times = new ArrayList<>();

    public TimesRes(List<Times> timesLIst){
        for (Times timesInner : timesLIst) {
            times.add(new InnerTimesRes(timesInner));
        }
    }


    @Data
    public static class InnerTimesRes {
        private String nomeTime;
        private Integer quantidadeJogadores;
        private JogadoresRes jogadores;

        public InnerTimesRes(Times times){
           this.jogadores = new JogadoresRes(times.getJogadores());
           this.nomeTime = times.getNomeTime();
           this.quantidadeJogadores = times.getQuantidadeJogadores();
        }
    }
}
