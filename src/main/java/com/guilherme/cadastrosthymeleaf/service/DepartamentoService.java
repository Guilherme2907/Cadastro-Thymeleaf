/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.service;

import com.guilherme.cadastrosthymeleaf.domain.Departamento;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public interface DepartamentoService {

    void save(Departamento dep);

    void update(Departamento dep);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();

    boolean departamentoTemCargo(Long id);
}
