package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, String> {
    List<Aula> findByCodAula(String codAula);
}
