/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.converter;

import com.guilherme.cadastrosthymeleaf.domain.Cargo;
import com.guilherme.cadastrosthymeleaf.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Guilherme
 */
@Component
public class StringToCargoConverter implements Converter<String, Cargo> {

    @Autowired
    private CargoService cargoService;

    @Override
    public Cargo convert(String s) {
        if (s.isEmpty()) {
            return null;
        } else {
            Long id = Long.valueOf(s);
            return cargoService.findById(id);
        }
    }

}
