package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Cliente;

public interface ClienteService {

    public List<Cliente> listarTodos();

    public Cliente buscarPorId(String id);

    public Cliente salvar(Cliente cliente);

    public Cliente editar(String id, Cliente cliente);

    public void apagar(String id);
    
}
