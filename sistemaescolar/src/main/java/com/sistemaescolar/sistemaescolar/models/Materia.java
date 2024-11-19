package com.sistemaescolar.sistemaescolar.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "Materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codMateria", length = 15, nullable = false)
    private int codMateria;
    @Column(name="descMateria", length = 60, nullable = false)
    private String descMateria;
   
    @ManyToMany(mappedBy = "materia")
    private Set<Turma> turma = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_professor", referencedColumnName = "cpf")
    private Professor professor;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.MERGE, fetch =FetchType.LAZY) 
    private Set<Boletim> boletim = new HashSet<>();
  
}
