/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.dao;

import com.guilherme.cadastrosthymeleaf.domain.Funcionario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Guilherme
 */
@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    @Override
    public List<Funcionario> findByName(String name) {
        return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')", name);
    }

    @Override
    public List<Funcionario> findFuncionarioByCargoId(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }

//    @Override
//    public List<Funcionario> findByName(String name) {
//        TypedQuery<Funcionario> query = getEntityManager().createQuery("select f from Funcionario f where f.nome like concat('%',:nome,'%')", Funcionario.class);
//        query.setParameter("nome", name);
//        return query.getResultList();
//    }
    @Override
    public List<Funcionario> buscarFuncionarioPorEntradaSaida(LocalDate entrada, LocalDate saida) {
        return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 and f.dataSaida <= ?2 order by f.dataEntrada asc", entrada, saida);
    }

    @Override
    public List<Funcionario> buscarFuncionarioPorEntrada(LocalDate entrada) {
        return createQuery("select f from Funcionario f where f.dataEntrada = ?1 order by f.dataEntrada asc", entrada);
    }

    @Override
    public List<Funcionario> buscarFuncionarioPorSaida(LocalDate saida) {
        return createQuery("select f from Funcionario f where f.dataSaida = ?1 order by f.dataEntrada asc", saida);
    }
}
