package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.interfaces.IResponsavel;
import com.sistemaescolar.sistemaescolar.models.Responsavel;
import com.sistemaescolar.sistemaescolar.repository.ResponsavelRepository;



@Service
public class ResponsavelService implements IResponsavel<Responsavel,String> {

    private ResponsavelRepository rr;

    public ResponsavelService(ResponsavelRepository rr) {
        this.rr = rr;
    }

    @Override
    public Responsavel novo(Responsavel r){  
          return rr.save(r);
    }

    @Override
    public Optional<Responsavel> busca(String chave){
        Optional<Responsavel> r = rr.findById(chave);
        return r;
    }

    @Override
    public List<Responsavel> buscaPorNome(String nome){
        return rr.findByNome(nome);
    }

    @Override
    public List<Responsavel> todos(){
        return rr.findAll();
    }

    @Override
    public Responsavel atualizar(Responsavel r){
        return rr.save(r);
    }

    @Override
    public void excluir(Responsavel r){
        rr.delete(r);
    }
   
}