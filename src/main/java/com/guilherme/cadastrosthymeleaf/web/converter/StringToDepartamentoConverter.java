/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.converter;

import com.guilherme.cadastrosthymeleaf.domain.Departamento;
import com.guilherme.cadastrosthymeleaf.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Guilherme
 */
@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    public Departamento convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return service.findById(id);
    }

}
