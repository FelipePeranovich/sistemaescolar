package com.sistemaescolar.sistemaescolar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa {
    public Funcionario(String cpf, String senha, String nome){
        super(nome, cpf, senha);
    }
    @Column(name = "salario_Mensal")
    private float salarioMensal;
}