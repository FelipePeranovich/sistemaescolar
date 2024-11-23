package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.interfaces.IProfessores;
import com.sistemaescolar.sistemaescolar.models.Professor;
import com.sistemaescolar.sistemaescolar.repository.ProfessorRepository;



@Service
public class ProfessorService implements IProfessores<Professor,String> {

    private ProfessorRepository pr;

    public ProfessorService(ProfessorRepository pr) {
        this.pr = pr;
    }

    @Override
    public Professor novo(Professor pf){  
          return pr.save(pf);
    }

    @Override
    public Optional<Professor> busca(String chave){
        Optional<Professor> pf = pr.findById(chave);
        return pf;
    }

    @Override
    public List<Professor> buscaPorNome(String nome){
        return pr.findByNome(nome);
    }

    @Override
    public List<Professor> todos(){
        return pr.findAll();
    }

    @Override
    public Professor atualizar(Professor pf){
        return pr.save(pf);
    }

    @Override
    public void excluir(Professor pf){
        pr.delete(pf);
    }
   
}