package com.desafio.Seguradora.model;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;
    @NotBlank 
    private String nome;

    @CPF(message="CPF inválido")
    @Indexed(unique=true)
    @NotBlank
    private String cpf;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

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