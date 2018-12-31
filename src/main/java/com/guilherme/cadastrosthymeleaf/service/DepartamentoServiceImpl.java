/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.service;

import com.guilherme.cadastrosthymeleaf.dao.DepartamentoDao;
import com.guilherme.cadastrosthymeleaf.domain.Departamento;
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
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoDao dao;

    @Override
    public void save(Departamento dep) {
        dao.save(dep);
    }

    @Override
    public void update(Departamento dep) {
        dao.update(dep);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean departamentoTemCargo(Long id) {
        if(findById(id).getCargos().isEmpty()){
            return false;
        }
        return true;
    }

}
