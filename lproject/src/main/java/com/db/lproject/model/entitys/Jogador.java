package com.db.lproject.model.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "jogador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Jogador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeJogador;

    @Column(nullable = false)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "time_id", nullable = false)
    private Times time;

}
