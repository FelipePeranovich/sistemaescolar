package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {
    List<Aluno> findByNome(String nome);
}
