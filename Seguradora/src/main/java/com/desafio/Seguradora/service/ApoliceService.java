package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Apolice;

public interface ApoliceService {

    public List<Apolice> listarTodos();

    public Apolice buscarPorId(String id);

    public Apolice salvar(Apolice apolice);

    public Apolice editar(String id, Apolice apolice);

    public void apagar(String id);
    
}
