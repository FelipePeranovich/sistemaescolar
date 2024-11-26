package com.sistemaescolar.sistemaescolar.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.InheritanceType;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public abstract class Pessoa implements Serializable {
    @Id
    @Column(name="cpf")
    private String cpf;

    @Column(name = "nome",length = 60, nullable = false)
    private String nome;

    @Column(name="senha",length = 60, nullable = false)
    private String senha;

}
