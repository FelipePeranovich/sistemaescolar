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
    private float n1;
    @Column(name = "n2", length = 15)
    private float n2;
    @Column(name = "n3", length = 15)
    private float n3;
    @Column(name = "n4", length = 15)
    private float n4;
    @Column(name = "recuperacao", length = 15)
    private float recuperacao;
    @Column(name = "Media", length = 15)
    private float mediaFinal;
    @Column(name = "situacao", length = 60)
    private String situacao;
    @Column(name = "frequencia", length = 15)
    private float frequencia;

    public Boletim(){
        n1 = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        recuperacao = 0;
    }

    @ManyToOne
    @JoinColumn(name="cpf_aluno", referencedColumnName = "cpf")  
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="codMateria" , referencedColumnName = "codMateria")
    private Materia materia;

    
    
    public void setMediaFinal(){
        mediaFinal = (n1+n2+n3+n4)/4;
    }


}
