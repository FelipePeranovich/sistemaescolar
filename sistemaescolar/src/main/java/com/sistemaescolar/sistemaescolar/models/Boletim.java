package com.sistemaescolar.sistemaescolar.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter 
@Table(name="Boletim")
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codBoletim", length = 15, nullable = false)
    private int codBoletim;

    @Column(name = "n1", length = 15)
    private Float n1;
    @Column(name = "n2", length = 15)
    private Float n2;
    @Column(name = "n3", length = 15)
    private Float n3;
    @Column(name = "n4", length = 15)
    private Float n4;
    @Column(name = "recuperacao", length = 15)
    private Float recuperacao;
    @Column(name = "Media", length = 15)
    private Float mediaFinal;
    @Column(name = "situacao", length = 60)
    private String situacao;
    @Column(name = "frequencia", length = 15)
    private Float frequencia;



    @ManyToOne
    @JoinColumn(name="cpf_aluno", referencedColumnName = "cpf")  
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="codMateria" , referencedColumnName = "codMateria")
    private Materia materia;



}
