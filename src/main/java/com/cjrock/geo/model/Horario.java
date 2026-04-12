package com.cjrock.geo.model;

import com.cjrock.geo.model.enums.Dia_semana;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", nullable = false)
    private Long id;

    @Column(name = "dia_semana")
    private Enum<Dia_semana> dia_semana;

    @Column(name = "num_aula")
    private  int num_aula;
}
