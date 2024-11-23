package com.sistemaescolar.sistemaescolar.interfaces;

import java.util.List;
import java.util.Optional;



public interface IAula<T,K> {

    T novo(T obj);

    Optional<T> busca(K chave);

    List<T> buscaPorCod(int codAula);

    List<T> todos();

    T atualizar(T obj);

    void excluir(T obj);

}