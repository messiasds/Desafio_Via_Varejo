package com.desafio.Seguradora.repository;

import java.util.List;

import com.desafio.Seguradora.model.Apolice;

public interface ApoliceRepository {

    public List<Apolice> findAll();

    public Apolice findById(int id);

}
