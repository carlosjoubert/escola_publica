package com.cjrock.geo.model.enums;

public enum Turno {
    MATUTINO("Matutino", "M"),
    VESPERTINO("Vespertino", "V"),
    NOTURNO("Noturno", "N"),
    INTEGRAL("Integral", "I");

    private final String descricao;
    private final String codigo;

    Turno(String descricao, String codigo) {
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
        return this.descricao + " (" + this.codigo + ")";
    }
}
