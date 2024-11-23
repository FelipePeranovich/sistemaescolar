package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.interfaces.IMateria;
import com.sistemaescolar.sistemaescolar.models.Materia;
import com.sistemaescolar.sistemaescolar.repository.MateriaRepository;



@Service
public class MateriaService implements IMateria<Materia,String> {

    private MateriaRepository mr;

    public MateriaService(MateriaRepository mr) {
        this.mr = mr;
    }

    @Override
    public Materia novo(Materia m){  
          return mr.save(m);
    }

    @Override
    public Optional<Materia> busca(String chave){
        Optional<Materia> m = mr.findById(chave);
        return m;
    }

    @Override
    public List<Materia> buscaPorCod(int codMateria){
        return mr.findByCodMateria(codMateria);
    }

    @Override
    public List<Materia> todos(){
        return mr.findAll();
    }

    @Override
    public Materia atualizar(Materia m){
        return mr.save(m);
    }

    @Override
    public void excluir(Materia m){
        mr.delete(m);
    }

    
   
}