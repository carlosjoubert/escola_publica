package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_historico_frequencia")
public class HistoricoFrequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq", nullable = false)
    private Integer numSQHistoricoFrequencia;

    @ManyToOne
    @JoinColumn(name = "tb_aluno_id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "tb_turma_has_disciplina_id_turma_disciplina", nullable = false)
    private TurmaDisciplina turmaDisciplina;

    @Column(name = "qtd_faltas")
    private Integer qtdFaltas;

    public HistoricoFrequencia(Integer numSQHistoricoFrequencia, Aluno aluno, TurmaDisciplina turmaDisciplina, Integer qtdFaltas) {
        this.numSQHistoricoFrequencia = numSQHistoricoFrequencia;
        this.aluno = aluno;
        this.turmaDisciplina = turmaDisciplina;
        this.qtdFaltas = qtdFaltas;
    }

    public HistoricoFrequencia() {
    }

    public Integer getNumSQHistoricoFrequencia() {
        return numSQHistoricoFrequencia;
    }

    public void setNumSQHistoricoFrequencia(Integer numSQHistoricoFrequencia) {
        this.numSQHistoricoFrequencia = numSQHistoricoFrequencia;
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

    public Integer getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(Integer qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }
}
