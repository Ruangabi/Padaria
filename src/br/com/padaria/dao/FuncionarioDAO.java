/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dao;

import br.com.padaria.models.Cliente;
import br.com.padaria.models.Funcionario;
import conexao.Conexao;
import static java.awt.Frame.CROSSHAIR_CURSOR;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {

    public void Insert(Funcionario c) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO funcionario VALUES (?, ?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setString(1, c.getCpf_fun());
            stmt.setString(2, c.getNome());
            stmt.setInt(3, c.getCarteira_trabalho());
            stmt.setString(4, c.getCargo());
            stmt.setBigDecimal(5, c.getSalario_R$());

            // Método responsável por fazer a alteração no banco de dados
            stmt.executeUpdate();
            con.commit();

        } catch (SQLException ex) {  // Tratamento das exceções

            System.out.println(ex);
            con.rollback();
            throw ex;

        } finally { // Encerramento da conexão

            if (stmt != null) {
                stmt.close();
            }
            con.setAutoCommit(true);
        }
    }

    public void Update(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            System.out.println(funcionario.getSalario_R$());
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ?, `carteira_trabalho` = ?, cargo = ?, `salario_R$` = ? WHERE `cpf_fun` = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getCarteira_trabalho());
            stmt.setString(3, funcionario.getCargo());
            stmt.setBigDecimal(4, funcionario.getSalario_R$());
            stmt.setString(5, funcionario.getCpf_fun());

            stmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
            throw ex;

        } finally {

            if (stmt != null) {
                stmt.close();
            }

            con.setAutoCommit(true);
        }
    }

    public List<Funcionario> Select() throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf_fun(rs.getString("cpf_fun"));
                funcionario.setCarteira_trabalho(rs.getInt("carteira_trabalho"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario_R$(rs.getBigDecimal("salario_R$"));
                funcionarios.add(funcionario); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;   // Retorna a lista
    }

    public List<Funcionario> Pesquisa(String nome) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario AS c WHERE c.nome like ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));

                funcionario.setCpf_fun(rs.getString("cpf_fun"));

                funcionario.setCarteira_trabalho(rs.getInt("carteira_trabalho"));

                funcionario.setCargo(rs.getString("cargo"));

                funcionario.setSalario_R$(rs.getBigDecimal("salario_R$"));

                funcionarios.add(funcionario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionarios;
    }
}
