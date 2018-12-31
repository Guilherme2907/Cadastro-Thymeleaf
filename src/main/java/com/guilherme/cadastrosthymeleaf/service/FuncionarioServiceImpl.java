/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.service;

import com.guilherme.cadastrosthymeleaf.dao.FuncionarioDao;
import com.guilherme.cadastrosthymeleaf.domain.Funcionario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guilherme
 */
@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Override
    public void save(Funcionario func) {
        dao.save(func);
    }

    @Override
    public void update(Funcionario func) {
        dao.update(func);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Funcionario> findFuncionarioByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Funcionario> findFuncionarioByCargoId(Long id) {
       return dao.findFuncionarioByCargoId(id);
    }

    @Override
    public List<Funcionario> getFuncionarioByDate(LocalDate entrada, LocalDate saida) {
        if(entrada != null && saida != null){
           return dao.buscarFuncionarioPorEntradaSaida(entrada,saida);
        } else if(entrada != null){
           return dao.buscarFuncionarioPorEntrada(entrada);
        } else if(saida != null){
           return  dao.buscarFuncionarioPorSaida(saida);
        } else {
            return new ArrayList();
        }
    }
}
