package com.sistemaescolar.sistemaescolar.models;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name="Aula")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codAula", length = 15, nullable = false)
    private int codAula;

    @Column(name="dataAula", length = 10,nullable = false)
    private Date dataAula;
    
    @ManyToOne
    @JoinColumn(name = "cpf_professor", referencedColumnName = "cpf")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="codTurma", referencedColumnName = "codTurma")
    private Turma turma;
}
