package com.desafio.Seguradora.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.desafio.Seguradora.dto.ApoliceConsultaDTO;
import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.model.Cliente;
//import com.desafio.Seguradora.repository.Apolice
import com.desafio.Seguradora.repository.ApoliceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApoliceConsultaImp implements ApoliceConsultaService {

    //private final ClienteRepository clienteRepository;

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Override
    public ApoliceConsultaDTO buscarApoliceComDiasVencimentoCalculado(String numero) {
        
        Apolice apolice;

        apolice = apoliceRepository.findById(numero).get();

        ApoliceConsultaDTO apoliceCalculada = null;

        ApoliceConsultaDTO apoliceDTO = new ApoliceConsultaDTO();
        apoliceDTO.setNumero(apolice.getNumero());
        apoliceDTO.setPlacaVeiculo(apolice.getPlacaVeiculo());
        apoliceDTO.setValor(apolice.getValor());
        apoliceDTO.setVigenciaFim(apolice.getVigenciaFim());
        apoliceDTO.setVigenciaInicio(apolice.getVigenciaInicio());

        apoliceCalculada = calcularVencimentoApolice(apoliceDTO);
        
        return apoliceCalculada;
        
    }

    @Override
    public Cliente buscarCliente(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApoliceConsultaDTO calcularVencimentoApolice(ApoliceConsultaDTO apolice) {
        
        LocalDate vencimento = apolice.getVigenciaFim();
        LocalDate dataHoje = LocalDate.now();

        long dias = ChronoUnit.DAYS.between(dataHoje, vencimento);

        if( dias < 0){
            apolice.isVencida(true);
            dias = dias * (-1);
            apolice.setDiasVencida(dias);
        }
        else {
            apolice.setdiasParaVencer(dias);
        }

        return apolice;
        
    }
    
}
