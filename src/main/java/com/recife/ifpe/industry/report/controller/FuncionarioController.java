package com.recife.ifpe.industry.report.controller;

import com.recife.ifpe.industry.report.entity.Funcionario;
import com.recife.ifpe.industry.report.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public String listFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionario/list";
    }

    @GetMapping("/new")
    public String showNewFuncionarioForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/new";
    }

    @PostMapping
    public String createFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/edit")
    public String showEditFuncionarioForm(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioService.findById(id);
        model.addAttribute("funcionario", funcionario);
        return "funcionario/edit";
    }

    @PostMapping("/{id}")
    public String updateFuncionario(@PathVariable Long id, @ModelAttribute Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioService.update(funcionario);
        return "redirect:/funcionarios";
    }

    @PostMapping("/{id}/delete")
    public String deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return "redirect:/funcionarios";
    }
}
