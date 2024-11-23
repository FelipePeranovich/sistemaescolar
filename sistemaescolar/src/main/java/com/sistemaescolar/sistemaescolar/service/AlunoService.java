package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.sistemaescolar.sistemaescolar.interfaces.IAlunos;
import com.sistemaescolar.sistemaescolar.models.Aluno;
import com.sistemaescolar.sistemaescolar.repository.AlunoRepository;



@Service
public class AlunoService implements IAlunos<Aluno,String> {

    private AlunoRepository ar;

    public AlunoService(AlunoRepository ar) {
        this.ar = ar;
    }

    @Override
    public Aluno novo(Aluno al){  
          return ar.save(al);
    }

    @Override
    public Optional<Aluno> busca(String chave){
        Optional<Aluno> al = ar.findById(chave);
        return al;
    }

    @Override
    public List<Aluno> buscaPorNome(String nome){
        return ar.findByNome(nome);
    }

    @Override
    public List<Aluno> todos(){
        return ar.findAll();
    }

    @Override
    public Aluno atualizar(Aluno al){
        return ar.save(al);
    }

    @Override
    public void excluir(Aluno al){
        ar.delete(al);
    }
    @Override
    public void excluirRa(String chave){
        ar.deleteById(chave);
    }
   
}