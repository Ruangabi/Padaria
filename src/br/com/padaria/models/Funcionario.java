/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.models;

import java.math.BigDecimal;

/**
 *
 * @author Aluno
 */
public class Funcionario {

    private String cpf_fun;
    private String nome;
    private int carteira_trabalho;
    private String cargo;
    private BigDecimal salario_R$;

    public String getCpf_fun() {
        return cpf_fun;
    }

    public void setCpf_fun(String cpf_fun) {
        this.cpf_fun = cpf_fun;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarteira_trabalho() {
        return carteira_trabalho;
    }

    public void setCarteira_trabalho(int carteira_trabalho) {
        this.carteira_trabalho = carteira_trabalho;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario_R$() {
        return salario_R$;
    }

    public void setSalario_R$(BigDecimal salario_R$) {
        this.salario_R$ = salario_R$;
    }

}
