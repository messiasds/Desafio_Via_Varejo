package com.desafio.Seguradora.service;

import com.desafio.Seguradora.dto.ApoliceConsultaDTO;

public interface ApoliceConsultaService {

    public ApoliceConsultaDTO buscarApoliceComDiasVencimentoCalculado(String numero);

    public Object calcularVencimentoApolice(ApoliceConsultaDTO apolice);

    
    
}
