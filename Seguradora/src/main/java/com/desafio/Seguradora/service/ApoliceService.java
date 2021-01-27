package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Apolice;

public interface ApoliceService {

    public List<Apolice> listarTodos();

    public Apolice buscarPorId(int id);

    public Apolice criar(Apolice apolice);

    public Apolice editar(int id, Apolice apolice);

    public Apolice apagar(int id);
    
}
