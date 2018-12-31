/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Guilherme
 */
@Component
public class StringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String s) {
        String text = s.trim();
        if (text.matches("[0-9]+")) {
            return Integer.valueOf(s);
        }
        return null;
    }

}
