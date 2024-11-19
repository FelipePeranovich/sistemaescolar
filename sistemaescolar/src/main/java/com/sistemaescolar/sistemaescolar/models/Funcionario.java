package com.sistemaescolar.sistemaescolar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public abstract class Funcionario extends Pessoa {  
    
    private float salarioMensal;

}