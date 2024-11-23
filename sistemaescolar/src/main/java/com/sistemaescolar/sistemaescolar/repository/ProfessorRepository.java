package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    List<Professor> findByNome(String nome);
}
