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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter; 
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name="Turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codTurma", length = 15, nullable = false)
    private int codTurma;

    @Column(name="nome_turma", length = 60, nullable =false)
    private String nome;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.MERGE, fetch =FetchType.LAZY)
    private Set<Aluno> aluno = new HashSet<>();

    @OneToMany(mappedBy = "turma", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Aula> aula = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
        name="Grade",
        joinColumns = { @JoinColumn(name = "codTurma", referencedColumnName = "codTurma")},
        inverseJoinColumns = { @JoinColumn(name = "codMateria", referencedColumnName="codMateria" )})
    private Set<Materia> materia = new HashSet<>();
    //public Set<Materia> getMateria() {return materia;}

}
