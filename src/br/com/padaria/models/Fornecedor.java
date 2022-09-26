/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.models;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Fornecedor {
    private int id;
    private int cnpj;
    private String nome;
    private String endereco;
//    private Date criadoEm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

//    public Date getCriadoEm() {
//        return criadoEm;
//    }
//
//    public void setCriadoEm(Date criadoEm) {
//        this.criadoEm = criadoEm;
//    }
   
}
