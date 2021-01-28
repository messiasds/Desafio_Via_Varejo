package com.desafio.Seguradora.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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
        public ResponseEntity<Apolice>buscarPorId(@PathVariable String id){
            Apolice apolice = apoliceService.buscarPorId(id);
            
            if (apolice != null)  
                return ResponseEntity.ok().body(apolice);
            else
                return ResponseEntity.notFound().build();
            
        }
        @PostMapping("/apolices")
        public ResponseEntity<Object> criarApolice(@RequestBody @Valid Apolice apolice ){
            
            apoliceService.salvar(apolice);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    
        }
    
        @PutMapping("/apolices/{id}")
        public ResponseEntity<Object> editarApolice(@PathVariable @Valid String id,
                                               @RequestBody Apolice apolice){
            
            apoliceService.editar(id, apolice);
       
            return ResponseEntity.ok().build();
            
        }
    
        @DeleteMapping("/apolices/{id}")
        public ResponseEntity<Object> deletarApolice(@PathVariable String id){

            apoliceService.apagar(id);
            return ResponseEntity.ok().build();
    
        }
    
    }
    
