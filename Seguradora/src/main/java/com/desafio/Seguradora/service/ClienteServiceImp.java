package com.desafio.Seguradora.service;

import java.util.Arrays;
import java.util.List;

import com.desafio.Seguradora.model.Cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService {

    // private final ClienteRepository clienteRepositorio;

    // public ClienteServiceImp(ClienteRepository clienteRepositorio){
    //
    // this.clienteRepositorio = clienteRepositorio;
    // }

    @Override
    public List<Cliente> listarTodos() {

        Cliente cliente1 = new Cliente();
        cliente1.setCidade("cidade1");
        cliente1.setCpf("cpf1");
        cliente1.setNome("nome1");
        cliente1.setUf("uf1");

        Cliente cliente2 = new Cliente();
        cliente2.setCidade("cidade222");
        cliente2.setCpf("cpf222");
        cliente2.setNome("nome222");
        cliente2.setUf("uf22");
        Cliente cliente3 = new Cliente();
        cliente3.setCidade("cidade333");
        cliente3.setCpf("cpf333");
        cliente3.setNome("nome333");
        cliente3.setUf("uf333");

        List<Cliente> lista = Arrays.asList(cliente1, cliente2, cliente3);

        return lista;

    }

    @Override
    public Cliente buscarPorId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente editar(int id, Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente apagar(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean validarCPF(String cpf) {
        // TODO Auto-generated method stub
        return true;
    }

}
