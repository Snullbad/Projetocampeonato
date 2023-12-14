package com.db.lproject.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.lproject.model.entitys.Campeonatos;
import com.db.lproject.model.entitys.Times;

@Repository
public interface TimesRepository extends JpaRepository<Times, Long>{
    List<Times> findByNomeTime(String nomeTime);
    List<Times> findByQuantidadeJogadores(Integer quantidadeJogadores);
    List<Times> findByCampeonatos(Campeonatos campeonatos);
}
