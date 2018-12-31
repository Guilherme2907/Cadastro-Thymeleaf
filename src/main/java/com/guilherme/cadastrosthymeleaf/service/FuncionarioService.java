/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.service;

import com.guilherme.cadastrosthymeleaf.domain.Funcionario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public interface FuncionarioService {

    void save(Funcionario func);

    void update(Funcionario func);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

    List<Funcionario> findFuncionarioByName(String name);
    
    List<Funcionario> findFuncionarioByCargoId(Long id);

    List<Funcionario> getFuncionarioByDate(LocalDate entrada, LocalDate saida);

}
