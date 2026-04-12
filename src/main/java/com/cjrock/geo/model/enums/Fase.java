package com.cjrock.geo.model.enums;

public enum Fase {
    EDUCACAO_INFANTIL("Educação Infantil", "EI"),
    ENSINO_FUNDAMENTAL_ANOS_INICIAIS("Ensino Fundamental - Anos Iniciais", "EF_AI"),
    ENSINO_FUNDAMENTAL_ANOS_FINAIS("Ensino Fundamental - Anos Finais", "EF_AF"),
    ENSINO_MEDIO("Ensino Médio", "EM");

    private final String descricao;
    private final String codigo;

    // Construtor privado para associar valores às constantes
    Fase(String descricao, String codigo) {
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