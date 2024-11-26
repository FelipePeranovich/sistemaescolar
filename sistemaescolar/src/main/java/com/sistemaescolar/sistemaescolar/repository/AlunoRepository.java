package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.models.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {
    List<Aluno> findByNome(String nome);
    @Query(value = "SELECT a FROM Aluno a WHERE a.responsavel.cpf = :cpf")
    List<Aluno> findByResp(@Param("cpf") String cpf);
}
