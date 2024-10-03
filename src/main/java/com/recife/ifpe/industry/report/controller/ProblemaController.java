package com.recife.ifpe.industry.report.controller;

import com.recife.ifpe.industry.report.entity.Problema;
import com.recife.ifpe.industry.report.service.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/problemas")
public class ProblemaController {

    @Autowired
    private ProblemaService problemaService;

    @GetMapping
    public String listProblemas(Model model) {
        List<Problema> problemas = problemaService.findAll();
        model.addAttribute("problemas", problemas);
        return "problema/list";
    }

    @GetMapping("/new")
    public String showNewProblemaForm(Model model) {
        model.addAttribute("problema", new Problema());
        return "problema/new";
    }

    @PostMapping
    public String createProblema(@ModelAttribute Problema problema) {
        problemaService.save(problema);
        return "redirect:/problemas";
    }

    @GetMapping("/{id}/edit")
    public String showEditProblemaForm(@PathVariable Long id, Model model) {
        Problema problema = problemaService.findById(id);
        model.addAttribute("problema", problema);
        return "problema/edit";
    }

    @PostMapping("/{id}")
    public String updateProblema(@PathVariable Long id, @ModelAttribute Problema problema) {
        problema.setId(id);
        problemaService.update(problema);
        return "redirect:/problemas";
    }

    @PostMapping("/{id}/delete")
    public String deleteProblema(@PathVariable Long id) {
        problemaService.delete(id);
        return "redirect:/problemas";
    }
}
