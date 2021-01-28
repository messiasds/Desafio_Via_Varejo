package com.desafio.Seguradora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Seguradora.dto.ApoliceConsultaDTO;
import com.desafio.Seguradora.service.ApoliceConsultaImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/consultas")
public class ConsultaApoliceController {

    @Autowired
    private ApoliceConsultaImp service;

    @GetMapping("/apolice/{numero}")
    public ApoliceConsultaDTO buscarApolices(@PathVariable String numero) {
        return service.buscarApoliceComDiasVencimentoCalculado(numero);

    }

}
