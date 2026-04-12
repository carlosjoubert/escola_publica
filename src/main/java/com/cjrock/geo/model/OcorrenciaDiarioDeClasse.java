package com.cjrock.geo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_ocorrencia_diario_de_classe")
public class OcorrenciaDiarioDeClasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocorrencia", nullable = false)
    private Integer ocorrencia;

    @Column(name = "conteudo_previsto")
    private String conteudoPrevisto;

    @Column(name = "conteudo_realizado")
    private String conteudoRealizado;

    @ManyToOne
    @JoinColumn(name = "id_turma_disciplina", nullable = false)
    private TurmaDisciplina turmaDisciplina;

    @Column(name = "data_hora")
    private Timestamp dataHora;

    public OcorrenciaDiarioDeClasse(Integer ocorrencia, String conteudoPrevisto, String conteudoRealizado, TurmaDisciplina turmaDisciplina, Timestamp dataHora) {
        this.ocorrencia = ocorrencia;
        this.conteudoPrevisto = conteudoPrevisto;
        this.conteudoRealizado = conteudoRealizado;
        this.turmaDisciplina = turmaDisciplina;
        this.dataHora = dataHora;
    }

    public OcorrenciaDiarioDeClasse() {
    }

    public Integer getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Integer ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getConteudoPrevisto() {
        return conteudoPrevisto;
    }

    public void setConteudoPrevisto(String conteudoPrevisto) {
        this.conteudoPrevisto = conteudoPrevisto;
    }

    public String getConteudoRealizado() {
        return conteudoRealizado;
    }

    public void setConteudoRealizado(String conteudoRealizado) {
        this.conteudoRealizado = conteudoRealizado;
    }

    public TurmaDisciplina getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }
}
