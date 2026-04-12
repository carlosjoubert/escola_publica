package com.cjrock.geo.model.enums;

public enum Dia_semana {
    SEGUNDA("Segunda-feira", "SEG"),
    TERCA("Terça-feira", "TER"),
    QUARTA("Quarta-feira", "QUA"),
    QUINTA("Quinta-feira", "QUI"),
    SEXTA("Sexta-feira", "SEX"),
    SABADO("Sábado", "SAB"),
    DOMINGO("Domingo", "DOM");

    private final String descricao;
    private final String codigo;

    Dia_semana(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
