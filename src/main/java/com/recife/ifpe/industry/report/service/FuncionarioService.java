package com.recife.ifpe.industry.report.service;

import com.recife.ifpe.industry.report.entity.Funcionario;
import com.recife.ifpe.industry.report.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void save(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void update(Funcionario funcionario) {
        funcionarioRepository.update(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.delete(id);
    }
}
