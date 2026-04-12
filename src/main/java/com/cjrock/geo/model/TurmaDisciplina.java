package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_turma_has_disciplina")
public class TurmaDisciplina {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma_disciplina", nullable = false)
    private Long idTurmaDisciplina;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @Column(name = "ano_letivo")
    private Integer anoLetivo;

    public TurmaDisciplina(Long idTurmaDisciplina, Turma turma, Disciplina disciplina, Integer anoLetivo) {
        this.idTurmaDisciplina = idTurmaDisciplina;
        this.turma = turma;
        this.disciplina = disciplina;
        this.anoLetivo = anoLetivo;
    }

    public TurmaDisciplina() {
    }

    public Long getIdTurmaDisciplina() {
        return idTurmaDisciplina;
    }

    public void setIdTurmaDisciplina(Long idTurmaDisciplina) {
        this.idTurmaDisciplina = idTurmaDisciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
}
