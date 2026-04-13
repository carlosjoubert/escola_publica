package com.cjrock.geo.model;

import com.cjrock.geo.model.enums.Fase;
import com.cjrock.geo.model.enums.Turno;
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

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola escola;

    @Column(name = "turno")
    private Enum<Turno> turno;

    public Turma(Long id, String serie, String turma, Enum<Fase> fase, Escola escola, Enum<Turno> turno) {
        this.id = id;
        this.serie = serie;
        this.turma = turma;
        this.fase = fase;
        this.escola = escola;
        this.turno = turno;
    }

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Enum<Fase> getFase() {
        return fase;
    }

    public void setFase(Enum<Fase> fase) {
        this.fase = fase;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Enum<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Enum<Turno> turno) {
        this.turno = turno;
    }
}
