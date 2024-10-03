package com.recife.ifpe.industry.report.entity;

import com.recife.ifpe.industry.report.enumeration.TipoFuncionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    private Long id;
    private String nome;

    private TipoFuncionario tipoFuncionario;

    private Setor setor;

    private List<Problema> problemas = new ArrayList<>();
}
