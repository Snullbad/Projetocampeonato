package com.db.lproject.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.lproject.model.entitys.Jogador;
import com.db.lproject.model.entitys.Times;

@Repository
public interface JogadorReposritory extends JpaRepository<Jogador, Long>{
    List<Jogador> findByNomeJogador(String nomeJogador);
    List<Jogador> findByNumero(Integer numero);
    List<Jogador> findByTime(Times time);
}
