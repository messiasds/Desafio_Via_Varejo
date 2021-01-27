package com.desafio.Seguradora.controller;

import java.util.List;

import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.service.ApoliceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ApoliceController {

        private final ApoliceService apoliceService;
    
        public ApoliceController(ApoliceService service){
            this.apoliceService = service;
        }
        
        @GetMapping("/apolices")
        public ResponseEntity<List<Apolice>> listarTodos(){
            List<Apolice> apolices = apoliceService.listarTodos();
            return ResponseEntity.ok().body(apolices);
            
        }
        @GetMapping("/apolices/{id}")
        public ResponseEntity<Apolice>buscarPorId(@PathVariable int id){
            Apolice apolice = apoliceService.buscarPorId(id);
            
            if (apolice != null)  
                return ResponseEntity.ok().body(apolice);
            else
                return ResponseEntity.notFound().build();
            
        }
        @PostMapping("/apolices")
        public ResponseEntity<?> criarApolice(@RequestBody Apolice apolice ){
            
            apoliceService.criar(apolice);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    
        }
    
        @PutMapping("/apolices/{id}")
        public ResponseEntity<?> editarApolice(@PathVariable int id,
                                               @RequestBody Apolice apolice){
            
        Apolice apoliceObj = apoliceService.buscarPorId(id);
        
        if (apoliceObj == null){
            return ResponseEntity.ok().body(apoliceObj);
        }
        else
            ResponseEntity.notFound().build();
    
            apoliceObj.setNumero(apolice.getNumero());
            apoliceObj.setPlacaVeiculo(apolice.getPlacaVeiculo());
            apoliceObj.setValor(apolice.getValor());
            apoliceObj.setVigenciaInicio(apolice.getVigenciaInicio());
            apoliceObj.setVigenciaFim(apolice.getVigenciaInicio());
    
            apoliceService.criar(apoliceObj);
            return ResponseEntity.ok().build();
            
        }
    
        @DeleteMapping("/apolices/{id}")
        public ResponseEntity<?> deletarApolice(@PathVariable int id){
            Apolice apolice = apoliceService.apagar(id);
            if(apolice != null)
                return ResponseEntity.ok().build();
            else
                return ResponseEntity.notFound().build();
    
        }
    
    }
    
}
