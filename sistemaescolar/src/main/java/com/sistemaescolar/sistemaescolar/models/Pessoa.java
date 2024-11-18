package com.sistemaescolar.sistemaescolar.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
    @Id
    @Column(length = 14, unique = true, nullable = false)
    private String cpf;
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 60, nullable = false)
    private String senha;
    
    public Pessoa(String nome, String cpf, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
    public void verificarLogin(){

    }
    public void alterarSenha(){
        
    }

}
