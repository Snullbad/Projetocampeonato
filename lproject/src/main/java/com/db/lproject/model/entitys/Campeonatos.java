package com.db.lproject.model.entitys;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campeonatos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campeonatos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeCampeonato;

    @Column(nullable = false)
    private String modalidade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campeonatos")
    private List<Times> times;

}
