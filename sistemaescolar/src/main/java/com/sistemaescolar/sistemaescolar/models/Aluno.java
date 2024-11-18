package com.sistemaescolar.sistemaescolar.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Aluno")
public class Aluno extends Pessoa {
    public Aluno(String cpf, String nome, String senha){
        super(nome, cpf, senha);  
    }
    @Id
    @Column(name = "ra", length = 16, nullable = false)
    private int ra;

    @Column(name = "dataNasc" , length = 50 ,nullable = false)
    private Date dataNasc;

    private Boletim boletim;
    
    private Turma turma;

    
}