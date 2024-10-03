package com.recife.ifpe.industry.report.controller;

import com.recife.ifpe.industry.report.entity.Setor;
import com.recife.ifpe.industry.report.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    public String listSetores(Model model) {
        List<Setor> setores = setorService.findAll();
        model.addAttribute("setores", setores);
        return "setor/list";
    }

    @GetMapping("/new")
    public String showNewSetorForm(Model model) {
        model.addAttribute("setor", new Setor());
        return "setor/new";
    }

    @PostMapping
    public String createSetor(@ModelAttribute Setor setor) {
        setorService.save(setor);
        return "redirect:/setores";
    }

    @GetMapping("/{id}/edit")
    public String showEditSetorForm(@PathVariable Long id, Model model) {
        Setor setor = setorService.findById(id);
        model.addAttribute("setor", setor);
        return "setor/edit";
    }

    @PostMapping("/{id}")
    public String updateSetor(@PathVariable Long id, @ModelAttribute Setor setor) {
        setor.setId(id);
        setorService.update(setor);
        return "redirect:/setores";
    }

    @PostMapping("/{id}/delete")
    public String deleteSetor(@PathVariable Long id) {
        setorService.delete(id);
        return "redirect:/setores";
    }
}
