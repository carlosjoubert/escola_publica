package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplina_alocada_horario")
@IdClass(DisciplinaHorario.class)
public class DisciplinaHorario {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "id_turma_disciplina", nullable = false)
    private TurmaDisciplina turmaDisciplina;

    public DisciplinaHorario(Horario horario, TurmaDisciplina turmaDisciplina) {
        this.horario = horario;
        this.turmaDisciplina = turmaDisciplina;
    }

    public DisciplinaHorario() {
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public TurmaDisciplina getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }
}
