package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_historico_notas")
public class HistoricoNotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tb_historico_notas", nullable = false)
    private Integer numSq;

    @ManyToOne
    @JoinColumn(name = "tb_aluno_id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "tb_turma_has_disciplina_id_turma_disciplina", nullable = false)
    private TurmaDisciplina turmaDisciplina;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "credito")
    private Integer credito;

    @Column(name = "trimestre")
    private Integer trimestre;

    @Column(name = "maximo_nota")
    private Double maximoNota;

    public HistoricoNotas(Integer numSq, Aluno aluno, TurmaDisciplina turmaDisciplina, Double nota, Integer credito, Integer trimestre, Double maximoNota) {
        this.numSq = numSq;
        this.aluno = aluno;
        this.turmaDisciplina = turmaDisciplina;
        this.nota = nota;
        this.credito = credito;
        this.trimestre = trimestre;
        this.maximoNota = maximoNota;
    }

    public HistoricoNotas() {
    }

    public Integer getNumSq() {
        return numSq;
    }

    public void setNumSq(Integer numSq) {
        this.numSq = numSq;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public TurmaDisciplina getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public Double getMaximoNota() {
        return maximoNota;
    }

    public void setMaximoNota(Double maximoNota) {
        this.maximoNota = maximoNota;
    }
}
