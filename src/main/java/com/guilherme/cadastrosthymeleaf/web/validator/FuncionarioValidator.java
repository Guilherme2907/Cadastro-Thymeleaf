/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.web.validator;

import com.guilherme.cadastrosthymeleaf.domain.Funcionario;
import java.time.LocalDate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Guilherme
 */
public class FuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Funcionario.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Funcionario f = (Funcionario) o;
        LocalDate entrada = f.getDataEntrada();
        LocalDate saida = f.getDataSaida();
        if (saida != null) {
            if (saida.isBefore(entrada)) {
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }
    }

}
