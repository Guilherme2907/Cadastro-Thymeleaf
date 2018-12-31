/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.error;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme
 */
@Component
public class MyErrorView implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("status", status.value());

        switch (status.value()) {
            case 404:
                model.addObject("error", "Página não encontrada");
                model.addObject("message", "A url para '" + map.get("path") + "' não existe");
                break;
            case 500:
                model.addObject("error", "Ocorreu um erro no servidor");
                model.addObject("message", "Ocorreu um erro inesperado,tente mais tarde");
                break;
            default:
                model.addObject("error", map.get("error"));
                model.addObject("message", map.get("message"));
                break;
        }

        return model;
    }

}
