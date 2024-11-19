package com.sistemaescolar.sistemaescolar.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Responsavel")
class Responsavel extends Pessoa {

    @Column(name="telefoneResponsavel", length=60, nullable = false )
    private String telefoneResponsavel;
    @OneToMany
    (mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<Aluno> dependentes = new ArrayList<>();
}
