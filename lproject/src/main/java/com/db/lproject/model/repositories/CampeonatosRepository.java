package com.db.lproject.model.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.db.lproject.model.entitys.Campeonatos;


@Repository
public interface CampeonatosRepository extends JpaRepository<Campeonatos, Long>{
    List<Campeonatos> findByNomeCampeonato(String nomeCampeonato);
    List<Campeonatos> findByModalidade(String modalidade);
}
