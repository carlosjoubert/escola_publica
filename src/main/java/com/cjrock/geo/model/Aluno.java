package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Aluno(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
