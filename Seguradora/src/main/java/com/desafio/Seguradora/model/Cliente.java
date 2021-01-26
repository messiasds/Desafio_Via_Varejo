package com.desafio.Seguradora.models;

public class Cliente {

    private String nome;
    private String cpf;
    private String cidade;
    private String uf;

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getCidade(){
        return this.cidade;
    }

    public String getUf(){
        return this.uf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setUf(String uf){
        this.uf = uf;
    }

}