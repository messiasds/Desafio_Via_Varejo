package com.desafio.Seguradora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.desafio.Seguradora.model.Cliente;

public interface ClienteRepository  extends MongoRepository<Cliente, String>{
    
}
