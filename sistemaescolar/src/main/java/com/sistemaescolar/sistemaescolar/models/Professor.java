package com.sistemaescolar.sistemaescolar.models;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter 
@Table(name="Professor")
public class Professor extends Funcionario {
   
    @OneToMany(mappedBy = "professor", cascade = CascadeType.MERGE, fetch =FetchType.LAZY)
    private Set<Aula> aula = new HashSet<>();

    @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Materia materia; 
   

}
