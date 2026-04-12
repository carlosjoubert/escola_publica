package com.cjrock.geo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_escola")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola", nullable = false)
    private Long id;

    @Column(name = "nome_escola")
    private String nome;

    public Escola(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Escola() {
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
