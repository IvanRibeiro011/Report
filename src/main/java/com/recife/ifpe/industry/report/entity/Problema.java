package com.recife.ifpe.industry.report.entity;

import com.recife.ifpe.industry.report.enumeration.TipoProblema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problema {

    private Long id;
    private LocalDateTime dataOcorrido;
    private TipoProblema tipoProblema;
    private Funcionario funcionario;
    private Setor setor;
}
