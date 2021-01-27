package com.desafio.Seguradora.service;

import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.model.Cliente;

public interface ViewApolice {

    public Apolice buscarApolice(int id);

    public Cliente buscarCliente(int id);

    public Object CalcularVencimentoApolice(Apolice apolice);

    
    
}
