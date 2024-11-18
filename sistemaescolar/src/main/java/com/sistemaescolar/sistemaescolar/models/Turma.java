package com.sistemaescolar.sistemaescolar.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@NoArgsConstructor 
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;

    private String nome;

    @OneToMany(mappedBy = "turma")private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "turma")private List<Aula> aulas = new ArrayList<>();
}
