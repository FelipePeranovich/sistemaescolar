package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.interfaces.IAula;
import com.sistemaescolar.sistemaescolar.models.Aula;
import com.sistemaescolar.sistemaescolar.repository.AulaRepository;



@Service
public class AulaService implements IAula<Aula,String> {

    private AulaRepository ar;

    public AulaService(AulaRepository ar) {
        this.ar = ar;
    }

    @Override
    public Aula novo(Aula a){  
          return ar.save(a);
    }

    @Override
    public List<Aula> buscaPorCod(int codAula){
        return ar.findByCodAula(codAula);
    }

    @Override
    public List<Aula> todos(){
        return ar.findAll();
    }

    @Override
    public Aula atualizar(Aula a){
        return ar.save(a);
    }

    @Override
    public void excluir(Aula a){
        ar.delete(a);
    }

    @Override
    public Optional<Aula> busca(String chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'busca'");
    }

    
   
}