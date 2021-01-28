package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.model.Cliente;
import com.desafio.Seguradora.repository.ApoliceRepository;
import com.desafio.Seguradora.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApoliceServiceImp implements ApoliceService {

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Apolice> listarTodos() {
        return apoliceRepository.findAll();
        
    }

    @Override
    public Apolice buscarPorId(String id) {

        return apoliceRepository.findById(id).get();
               
    }

    @Override
    public Apolice salvar(Apolice apolice) {

        Cliente cliente = clienteRepository.findById(apolice.getCliente().getId())
                                           .orElseThrow(() -> new IllegalArgumentException("Cliente inexistente"));
        apolice.setCliente(cliente);
        return apoliceRepository.save(apolice);
    }

    @Override
    public Apolice editar(String id, Apolice apolice) {
        
        Apolice apoliceEditada = apoliceRepository.findById(id)
                                                  .orElseThrow(() -> new IllegalArgumentException("Cliente inexistente"));
        
        apoliceEditada.setCliente(apolice.getCliente());
        apoliceEditada.setNumero(apolice.getNumero());
        apoliceEditada.setPlacaVeiculo(apolice.getPlacaVeiculo());
        apoliceEditada.setValor(apolice.getValor());
        apoliceEditada.setVigenciaFim(apolice.getVigenciaFim());
        apoliceEditada.setVigenciaInicio(apolice.getVigenciaInicio());

        return apoliceRepository.save(apolice);

    }

    @Override
    public void apagar(String id) {

        Apolice apolice = apoliceRepository.findById(id).get();
        apoliceRepository.delete(apolice);
    }


    
}
