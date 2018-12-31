/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.service;

import com.guilherme.cadastrosthymeleaf.domain.Cargo;
import com.guilherme.cadastrosthymeleaf.dao.CargoDao;
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
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao dao;

    @Override
    public void save(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void update(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionario(Long id) {
        if (!dao.findById(id).getFuncionarios().isEmpty()) {
            return true;
        }
        return false;
    }

}
