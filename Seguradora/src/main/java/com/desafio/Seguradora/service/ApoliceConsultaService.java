package com.desafio.Seguradora.service;

import com.desafio.Seguradora.dto.ApoliceConsultaDTO;
import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.model.Cliente;

public interface ApoliceConsultaService {

    public ApoliceConsultaDTO buscarApoliceComDiasVencimentoCalculado(String numero);

    public Cliente buscarCliente(String id);

    public Object calcularVencimentoApolice(ApoliceConsultaDTO apolice);

    
    
}
