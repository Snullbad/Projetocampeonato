package com.db.lproject.model.entitys;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "times")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Times {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeTime;

    @Column(nullable = false)
    private Integer quantidadeJogadores;

    @ManyToOne
    @JoinColumn(name = "id_campeonatos")
    private Campeonatos campeonatos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<Jogador> jogadores;
}
