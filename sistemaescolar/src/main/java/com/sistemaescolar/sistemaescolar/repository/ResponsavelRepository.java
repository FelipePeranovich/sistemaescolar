package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, String> {
    List<Responsavel> findByNome(String nome);
}
