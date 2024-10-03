package com.recife.ifpe.industry.report.enumeration;

public enum TipoProblema {
    FALHA_EQUIPAMENTO("Falha equipamento"),
    FALTA_INSUMO("Falta de insumo"),
    ASSEDIO("Assedio"),
    FALHA_PESSOAL("Falha pessoal"),
    ACIDENTE("Acidente");

    private String descricao;

    TipoProblema(String tipoProblema) {
        this.descricao = tipoProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
