package com.db.lproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.lproject.model.dto.CampeonatoDto;
import com.db.lproject.model.dto.JogadorDto;
import com.db.lproject.model.dto.TimesDto;
import com.db.lproject.model.entitys.Campeonatos;
import com.db.lproject.model.entitys.Jogador;
import com.db.lproject.model.entitys.Times;
import com.db.lproject.model.repositories.Repository;

@Service
public class CampeonatoService {

    @Autowired
    private Repository repository;

    public void CreateAndSave(CampeonatoDto dto, List<Times> times, List<Jogador> jogadores) throws Exception{
        if(times == null || jogadores == null){times = new ArrayList<>();jogadores = new ArrayList<>();}
        Campeonatos chm = new Campeonatos(0, dto.getNomeCompeonato(), dto.getModalidade(), null);

        for (TimesDto time : dto.getTimes()) {
            Times timeNovo = new Times(0, time.getNomeTime(), time.getNJogadores(), chm, null);
            jogadores = getallJogadores(time.getJogadores(), timeNovo);
            timeNovo.setJogadores(jogadores);
            times.add(timeNovo);
        }
        chm.setTimes(times);
        repository.getCampeonatosRepository().save(chm);
    }

    private List<Jogador> getallJogadores(List<JogadorDto> jDto, Times timeNovo) throws Exception{
        List<Jogador> jogadores = new ArrayList<>();
        for (JogadorDto jgd : jDto) {
            Jogador jogador = new Jogador(0, jgd.getNomeJogador(), jgd.getNumero(), timeNovo);
            verifyNumber(jgd.getNumero(), jogadores);
            jogadores.add(jogador);
        }
        return jogadores;
    }

    public void verifyNumber(Integer number, List<Jogador> jogadores) throws Exception{
        if(!jogadores.isEmpty()){
            for (Jogador element : jogadores) {
               if(element.getNumero() == number) {throw new Exception("jogador não pode ter numero repetido");}
            }
        }
    }

    public void delete(String name){
        Campeonatos camp = repository.getCampeonatosRepository().findByNomeCampeonato(name).get(0);
        camp.getTimes().forEach(e -> repository.getJogadorReposritory().deleteAll(e.getJogadores()));
        repository.getTimesRepository().deleteAll(camp.getTimes());
        repository.getCampeonatosRepository().delete(camp);
    }
}
