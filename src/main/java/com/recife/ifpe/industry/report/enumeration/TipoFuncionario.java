package com.recife.ifpe.industry.report.enumeration;

public enum TipoFuncionario {

    ESCRITORIO("Escritorio"),
    FABRICA("Fabrica");

    private String descricao;

    TipoFuncionario(String tipo) {
        this.descricao = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
