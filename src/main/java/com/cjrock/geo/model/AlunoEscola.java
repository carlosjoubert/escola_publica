package com.cjrock.geo.model;

import com.cjrock.geo.model.enums.Turno;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno_has_tb_escola")
public class AlunoEscola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_matricula", nullable = false)
    private Integer matricula;

    @ManyToOne
    @JoinColumn(name = "tb_aluno_id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "tb_escola_id_escola", nullable = false)
    private Escola escola;

    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(name = "ano_letivo", nullable = false)
    private Integer anoLetivo;

    public AlunoEscola(Integer matricula, Aluno aluno, Escola escola, Turno turno, Integer anoLetivo) {
        this.matricula = matricula;
        this.aluno = aluno;
        this.escola = escola;
        this.turno = turno;
        this.anoLetivo = anoLetivo;
    }

    public AlunoEscola() {
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
}
