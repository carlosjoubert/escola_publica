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

    public Horario(Long id, Enum<Dia_semana> dia_semana, int num_aula) {
        this.id = id;
        this.dia_semana = dia_semana;
        this.num_aula = num_aula;
    }

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum<Dia_semana> getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(Enum<Dia_semana> dia_semana) {
        this.dia_semana = dia_semana;
    }

    public int getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(int num_aula) {
        this.num_aula = num_aula;
    }
}
