package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_escola")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola", nullable = false)
    private Long id;

    @Column(name = "nome_escola")
    private String nome;
}
