package com.recife.ifpe.industry.report.service;

import com.recife.ifpe.industry.report.entity.Setor;
import com.recife.ifpe.industry.report.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    // Método para salvar um setor
    public void save(Setor setor) {
        setorRepository.save(setor);
    }

    // Método para buscar todos os setores
    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    // Método para buscar um setor pelo ID
    public Setor findById(Long id) {
        return setorRepository.findById(id);
    }

    public void update(Setor setor) {
        setorRepository.update(setor);
    }

    public void delete(Long id) {
        setorRepository.delete(id);
    }
}