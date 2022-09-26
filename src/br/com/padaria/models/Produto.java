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
public class Produto {

    private String codigo_pro;
    private String descricao;
    private String nome;
    private BigDecimal valor_R$;

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor_R$() {
        return valor_R$;
    }

    public void setValor_R$(BigDecimal valor_R$) {
        this.valor_R$ = valor_R$;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
