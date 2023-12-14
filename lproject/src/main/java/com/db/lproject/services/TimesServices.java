package com.db.lproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.lproject.model.dto.JogadorDto;
import com.db.lproject.model.dto.TimesDto;
import com.db.lproject.model.dto.TimesDtoAlter;
import com.db.lproject.model.entitys.Campeonatos;
import com.db.lproject.model.entitys.Jogador;
import com.db.lproject.model.entitys.Times;
import com.db.lproject.model.repositories.Repository;

import lombok.Data;

@Service
public class TimesServices {

    @Autowired
    private Repository repository;

    public void CreateAndSave(TimesDto dto, List<Jogador> type) throws Exception{
        if(type == null){type = new ArrayList<>();}
        Campeonatos campeonato = repository.getCampeonatosRepository().findByNomeCampeonato(dto.getCampeonatoNome()).get(0);
        List<Jogador> jogadores = type;
        Times time = new Times(0, dto.getNomeTime(), dto.getNJogadores(), campeonato, null);

        for (JogadorDto element : dto.getJogadores()) {
            Jogador jogador = new Jogador(0, element.getNomeJogador(), element.getNumero(), time);
            verifyNumber(element.getNumero(), jogadores);
            jogadores.add(jogador);
        }

        time.setJogadores(jogadores);
        repository.getTimesRepository().save(time);
    }

    public void alter(String nome, TimesDtoAlter dto) throws Exception{
        List<Times> times = repository.getTimesRepository().findByNomeTime(nome);
        if(!times.isEmpty()){
            Times time = times.get(0);

            if(dto.getNovoNomeTime() != null){
                if(!dto.getNovoNomeTime().isEmpty()){
                    time.setNomeTime(dto.getNovoNomeTime());
                }
            }

            if(dto.getQuantidadeJogadores() != time.getQuantidadeJogadores()){
                time.setQuantidadeJogadores(dto.getQuantidadeJogadores());
            }

            if(dto.getNomeCampeonato() != null){
                if(!dto.getNomeCampeonato().isEmpty()){
                    List<Campeonatos> cmp =  repository.getCampeonatosRepository().findByNomeCampeonato(dto.getNomeCampeonato());
                    if(cmp != null && !cmp.isEmpty()){
                     time.setCampeonatos(cmp.get(0));
                    }
                }
            }

            repository.getTimesRepository().save(time);
        }else{
            throw new Exception("time inexistente");
        }
    }

    public void delete(String name){
        Times time = repository.getTimesRepository().findByNomeTime(name).get(0);
        repository.getJogadorReposritory().deleteAll(time.getJogadores());
        repository.getTimesRepository().delete(time);

    }

    private void verifyNumber(Integer number, List<Jogador> jogadores) throws Exception{
        if(!jogadores.isEmpty()){
            for (Jogador element : jogadores) {
               if(element.getNumero() == number) {throw new Exception("jogador não pode ter numero repetido");}
            }
        }
    }


}
