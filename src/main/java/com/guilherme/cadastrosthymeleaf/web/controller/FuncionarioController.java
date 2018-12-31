/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.controller;

import com.guilherme.cadastrosthymeleaf.domain.Cargo;
import com.guilherme.cadastrosthymeleaf.domain.Funcionario;
import com.guilherme.cadastrosthymeleaf.domain.UF;
import com.guilherme.cadastrosthymeleaf.service.CargoService;
import com.guilherme.cadastrosthymeleaf.service.FuncionarioService;
import com.guilherme.cadastrosthymeleaf.web.validator.FuncionarioValidator;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Guilherme
 */
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @InitBinder
    public void initBinder(WebDataBinder web) {
        web.addValidators(new FuncionarioValidator());
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "funcionario/cadastro";
        }
        funcionarioService.save(funcionario);
        redirectAttributes.addFlashAttribute("success", "Funcionário salvo com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario funcionario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "funcionario/cadastro";
        }
        funcionarioService.update(funcionario);
        redirectAttributes.addFlashAttribute("success", "Funcionário editado com sucesso");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        funcionarioService.delete(id);
        model.addAttribute("success", "Funcionário removido com sucesso");
        return listar(model);
    }

    @GetMapping("/buscar/nome")
    public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.findFuncionarioByName(nome));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String buscarPorCargo(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.findFuncionarioByCargoId(id));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/data")
    public String buscarPorData(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
            @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, ModelMap model) {

        model.addAttribute("funcionarios", funcionarioService.getFuncionarioByDate(entrada, saida));
        return "funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> listarCargos() {
        return cargoService.findAll();
    }

    @ModelAttribute("ufs")
    public UF[] listarUfs() {
        return UF.values();
    }
}
