package com.desafio.Seguradora.dto;

import java.time.LocalDate;

public class ApoliceConsultaDTO {

    private int numero;
    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFim;
    private String placaVeiculo;
    private Float valor;
    private boolean vencida;
    private long diasVencida = 0;
    private long diasParaVencer = 0;

    
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

    public boolean isVencida(){
        return this.vencida;
    }

    public long getdiasParaVencer(){
        return this.diasParaVencer;
    }

    public long getDiasVencida(){
        return this.diasVencida;
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

    public void isVencida(boolean vencida){
        this.vencida = vencida;
    }

    public void setdiasParaVencer(long dias){
        this.diasParaVencer = dias;
    }

    public void setDiasVencida(long dias){
        this.diasVencida = dias;
    }

}


    
}
