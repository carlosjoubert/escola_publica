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
}
