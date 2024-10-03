package com.recife.ifpe.industry.report.entity;

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
public class Setor {

    private Long id;
    private String nome;

    private List<Funcionario> funcionarios = new ArrayList<>();

}
