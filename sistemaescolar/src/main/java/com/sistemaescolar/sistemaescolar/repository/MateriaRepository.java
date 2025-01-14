package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, String> {
    List<Materia> findByNome(String nome);
}
