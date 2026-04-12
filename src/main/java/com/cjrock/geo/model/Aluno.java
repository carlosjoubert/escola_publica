package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;
}
