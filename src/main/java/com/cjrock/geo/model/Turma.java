package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma", nullable = false)
    private Long id;

    @Column(name = "serie")
    private String serie;

    @Column(name = "turma")
    private String turma;

    @Column(name = "fase")
    private Enum<Fase> fase;

    private Long id_escola;

    @Column(name = "turno")
    private Enum<Turno> turno;
}
