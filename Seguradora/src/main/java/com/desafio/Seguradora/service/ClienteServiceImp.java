package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Cliente;
import com.desafio.Seguradora.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();

    }

    @Override
    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).get();

    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(String id, Cliente cliente) {
        Cliente clienteDestino = buscarPorId(id);
        clienteDestino.setCidade(cliente.getCidade());
        clienteDestino.setCpf(cliente.getCpf());
        clienteDestino.setNome(cliente.getNome());
        clienteDestino.setUf(cliente.getUf());

        return clienteRepository.save(clienteDestino);
    }

    @Override
    public void apagar(String id) {
        Cliente cliente = clienteRepository.findById(id).get();
        clienteRepository.delete(cliente);

    }

}
