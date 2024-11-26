package com.sistemaescolar.sistemaescolar.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, String> {
    List<Turma> findByNome(String nome);
}
