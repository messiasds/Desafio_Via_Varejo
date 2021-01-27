package com.desafio.Seguradora.service;

import java.util.List;

import com.desafio.Seguradora.model.Cliente;

public interface ClienteService {

    public List<Cliente> listarTodos();

    public Cliente buscarPorId(int id);

    public Cliente criar(Cliente cliente);

    public Cliente editar(int id, Cliente cliente);

    public Cliente apagar(int id);

    public Boolean validarCPF(String cpf);
    
}
