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
public class Venda {

    private String codigo_venda;
    private Date horario;
    private String codigo_pro;
    private String cpf_fun;

    public String getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(String codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getCpf_fun() {
        return cpf_fun;
    }

    public void setCpf_fun(String cpf_fun) {
        this.cpf_fun = cpf_fun;
    }

}
