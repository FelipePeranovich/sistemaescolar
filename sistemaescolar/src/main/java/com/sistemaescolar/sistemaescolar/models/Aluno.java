package com.sistemaescolar.sistemaescolar.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Aluno")
public class Aluno extends Pessoa {
    @Column(name = "ra", length = 16, nullable = false)
    private int ra;

    @Column(name = "dataNasc" , length = 10 ,nullable = false)
    private Date dataNasc;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Boletim> boletim = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="codTurma", referencedColumnName = "codTurma")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name="cpf_responsavel", referencedColumnName = "cpf")
    private Responsavel responsavel;
  
}