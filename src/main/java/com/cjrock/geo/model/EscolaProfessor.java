package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_escola_vincula_professor")
public class EscolaProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_vinculo", nullable = false)
    private Integer numSqEscolaProfessor;

    @ManyToOne
    @JoinColumn(name = "tb_escola_id_escola", nullable = false)
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "tb_professor_id_professor", nullable = false)
    private Professor professor;

    @Column(name = "ano_letivo", nullable = false)
    private Integer anoLetivo;

    public EscolaProfessor(Integer numSqEscolaProfessor, Escola escola, Professor professor, Integer anoLetivo) {
        this.numSqEscolaProfessor = numSqEscolaProfessor;
        this.escola = escola;
        this.professor = professor;
        this.anoLetivo = anoLetivo;
    }

    public EscolaProfessor() {
    }

    public Integer getNumSqEscolaProfessor() {
        return numSqEscolaProfessor;
    }

    public void setNumSqEscolaProfessor(Integer numSqEscolaProfessor) {
        this.numSqEscolaProfessor = numSqEscolaProfessor;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
}
