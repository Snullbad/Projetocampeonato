package com.db.lproject.services;




import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.lproject.model.dto.JogadorDto;
import com.db.lproject.model.entitys.Jogador;
import com.db.lproject.model.entitys.Times;
import com.db.lproject.model.repositories.Repository;


@Service
public class JogadorServices {

    @Autowired
    private Repository repository;

    public void CreateAndSave(JogadorDto dto) throws Exception{
        verifyNumber(dto.getNumero(), dto.getNomeTime());
        Jogador jogador = new Jogador(0, dto.getNomeJogador(), dto.getNumero(), repository.getTimesRepository().findByNomeTime(dto.getNomeTime()).get(0));
        repository.getJogadorReposritory().save(jogador);
    }

    public void alter(JogadorDto dto, String name) throws Exception{
        List<Jogador> jogadors = repository.getJogadorReposritory().findByNomeJogador(name);
        if(!jogadors.isEmpty()){
            Jogador jogador = jogadors.get(0);
            verifyNumberInTime(dto.getNumero(), jogador);
            if(dto.getNomeTime() != null){
                List<Times> times = repository.getTimesRepository().findByNomeTime(dto.getNomeTime());
                if(times.isEmpty()){throw new Exception("Time tem que existir");}
                jogador.setTime(times.get(0));
            }
            if(dto.getNumero() > 0){
                jogador.setNumero(dto.getNumero());
            }
            if(dto.getNomeJogador() != null){
                jogador.setNomeJogador(dto.getNomeJogador());
            }
            repository.getJogadorReposritory().save(jogador);
        }else{
            throw new Exception("jogador inexistente");
        }
    }

    public void delete(String nome){
        Jogador jogador  = repository.getJogadorReposritory().findByNomeJogador(nome).get(0);
        repository.getJogadorReposritory().delete(jogador);
    }

    private void verifyNumber(Integer number, String nomeTime) throws Exception{
        List<Times> times = repository.getTimesRepository().findByNomeTime(nomeTime);
        if(times.isEmpty()){throw new Exception("Time tem que existir");}
        List<Boolean> numb = new ArrayList<>();
        if(!times.isEmpty()){
            for (Times time : times) {
                numb = time.getJogadores().stream().map(e -> e.getNumero() == number).collect(Collectors.toList());
            }
        }

        for (boolean element : numb) {
            if (element) {
                throw new Exception("jogador não pode ter numero repetido");
            }
        }
    }

    private void verifyNumberInTime(Integer number, Jogador jogaodr) throws Exception{
        Times time = jogaodr.getTime();
        List<Jogador> jogadoresList = time.getJogadores();
        jogadoresList.remove(jogaodr);
        for (Jogador element : jogadoresList) {
            if(element.getNumero() == number){ throw new Exception("jogador não pode ter numero repetido");}
        }
    }
}
