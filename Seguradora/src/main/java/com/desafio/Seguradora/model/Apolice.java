package com.desafio.Seguradora.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="apolice")
public class Apolice {

    @Id
    private String id;
    private int numero;
    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFim;
    private String placaVeiculo;
    private Float valor;
    @DBRef
    private Cliente cliente;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getNumero() {
        return this.numero;
    }

    public LocalDate getVigenciaInicio() {
        return this.vigenciaInicio;
    }

    public LocalDate getVigenciaFim() {
        return this.vigenciaFim;
    }

    public String getPlacaVeiculo() {
        return this.placaVeiculo;
    }

    public float getValor() {
        return this.valor;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public void setVigenciaFim(LocalDate vigenciaFim) {
        this.vigenciaFim = vigenciaFim;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setValor(float valor) { // corrigir para tipo monetario...
        this.valor = valor;

    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

}
