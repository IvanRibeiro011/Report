package com.recife.ifpe.industry.report.service;

import com.recife.ifpe.industry.report.entity.Problema;
import com.recife.ifpe.industry.report.repository.ProblemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemaService {

    private final ProblemaRepository problemaRepository;

    public ProblemaService(ProblemaRepository problemaRepository) {
        this.problemaRepository = problemaRepository;
    }

    public void save(Problema problema) {
        problemaRepository.save(problema);
    }

    public List<Problema> findAll() {
        return problemaRepository.findAll();
    }

    public List<Problema> findBySetorId(Long setorId) {
        return problemaRepository.findBySetorId(setorId);
    }

    public Problema findById(Long id) {
        return problemaRepository.findById(id);
    }

    public void update(Problema problema) {
        problemaRepository.update(problema);
    }

    public void delete(Long id) {
        problemaRepository.delete(id);
    }
}