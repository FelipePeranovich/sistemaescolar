package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.interfaces.ITurma;
import com.sistemaescolar.sistemaescolar.models.Turma;
import com.sistemaescolar.sistemaescolar.repository.TurmaRepository;

@Service
public class TurmaService implements ITurma<Turma, String>{
    
    private TurmaRepository tr;

    public TurmaService(TurmaRepository tr){
        this.tr = tr;
    }

    @Override
    public List<Turma> todos(){
        return tr.findAll();
    }

    @Override
    public Turma novo(Turma tm){  
          return tr.save(tm);
    }

    @Override
    public List<Turma> buscaPorNome(String nome){
        return tr.findByNome(nome);
    }

    @Override
    public Turma atualizar(Turma tm){
        return tr.save(tm);
    }

    @Override
    public void excluir(Turma tm){
        tr.delete(tm);
    }

    @Override
    public Optional<Turma> busca(String chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'busca'");
    }

    
}
