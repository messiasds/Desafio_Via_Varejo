package com.desafio.Seguradora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.conditional.ElseAction;

import java.util.List;
import java.util.Optional;

import com.desafio.Seguradora.model.Cliente;
import com.desafio.Seguradora.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService service){
        this.clienteService = service;
    }
    
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarTodos(){
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok().body(clientes);
        
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id){
        Cliente cliente = clienteService.buscarPorId(id);
        
        if (cliente != null)  
            return ResponseEntity.ok().body(cliente);
        else
            return ResponseEntity.notFound().build();
        
    }
    @PostMapping("/clientes")
    public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente ){

        if( !clienteService.validarCPF(cliente.getCpf())){
            return ResponseEntity.badRequest().body("CPF inválido");
        }
        
        clienteService.criar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> editarCliente(@PathVariable int id,
                                           @RequestBody Cliente cliente){
        
    Cliente clienteObj = clienteService.buscarPorId(id);
    
    if (clienteObj == null){
        return ResponseEntity.ok().body(clienteObj);
    }
    else
        ResponseEntity.notFound().build();

        clienteObj.setNome(cliente.getNome());
        clienteObj.setCidade(cliente.getCidade());
        clienteObj.setCpf(cliente.getCpf());
        clienteObj.setUf(cliente.getUf());

        clienteService.criar(clienteObj);
        return ResponseEntity.ok().build();
        
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable int id){
        Cliente cliente = clienteService.apagar(id);
        if(cliente != null)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();

    }

}