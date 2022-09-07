/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dal;

import java.sql.*;
/**
 *
 * @author Aluno
 */
public class ModuloConexao {

 //Metodo responsável por estabelecer a conexao coma o Banco de Dados
    public static Connection conector() {
 //connection é um conjunto de funcionalidades que vem do pacote java.sql e conector é o nome do meu método 
        java.sql.Connection conexao = null; //variavel para armazenar as informações que vem do Banco de Dados
        // a linha abaixo "chama" o driver que importei para a biblioteca 
        String driver = "com.mysql.cj.jdbc.Driver";
        //Variaveis para armazenar informações referentes ao Banco de Dados
        String url = "jdbc:mysql://localhost:3306/padaria?characterEncoding=utf-8";
        String user = "root";
        String password = "";
        
        //Estabelecendo a conexão com o Banco de Dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
           //A linha abaixo serve de apoio para esclarecer o erro de conexao
            //Porém não posso devolver essa mensagem para o usuário
           //System.out.println (e);
            return null;
        }
    }
}

