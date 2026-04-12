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

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private Dia_semana diaSemana;

    @Column(name = "num_aula")
    private  Integer numAula;

    public Horario(Long id, Dia_semana diaSemana, Integer numAula) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.numAula = numAula;
    }

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dia_semana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Dia_semana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getNumAula() {
        return numAula;
    }

    public void setNumAula(Integer numAula) {
        this.numAula = numAula;
    }
}
