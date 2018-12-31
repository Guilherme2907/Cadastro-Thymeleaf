/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.cadastrosthymeleaf.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long>{
    @NotBlank(message = "Informe um nome para o cargo")
    @Size(min = 3,max = 60,message = "O nome do cargo deve ter entre {min} e {max} caracteres")
    @Column(nullable = false,unique = true,length = 60)
    private String nome;
    
    @NotNull(message = "Selecione o departamento relativo ao cargo")
    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;
    
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}