package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;
}
