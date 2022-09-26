/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dao;

import br.com.padaria.models.Fornecedor;
import conexao.Conexao;
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
public class FornecedorDAO {

    public List<Fornecedor> Select() throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM fornecedor");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setCnpj(rs.getInt("cnpj"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedores.add(fornecedor); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;   // Retorna a lista
    }

    public Fornecedor SelectOne(int id) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Fornecedor fornecedor = new Fornecedor();
        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor AS f WHERE f.id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                fornecedor.setId(rs.getInt("id"));

                fornecedor.setCnpj(rs.getInt("cnpj"));

                fornecedor.setNome(rs.getString("nome"));

                fornecedor.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fornecedor;
    }

    public Fornecedor SelectOne(String nome) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Fornecedor fornecedor = new Fornecedor();
        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor AS f WHERE f.nome like ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                fornecedor.setId(rs.getInt("id"));

                fornecedor.setCnpj(rs.getInt("cnpj"));

                fornecedor.setNome(rs.getString("nome"));

                fornecedor.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fornecedor;
    }

    public void Insert(Fornecedor f) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO fornecedor VALUES (DEFAULT, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setInt(1, f.getCnpj());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getEndereco());
//            stmt.setDate(4, new Date(f.getCriadoEm().getTime()));

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

    public List<Fornecedor> Pesquisar(String termo) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> fornecedores = new ArrayList();

        try {

            stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE nome like ?");

            stmt.setString(1, "%" + termo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setCnpj(rs.getInt("cnpj"));
                f.setNome(rs.getString("nome"));
                f.setEndereco(rs.getString("endereco"));
                fornecedores.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }

    public void Update(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE fornecedor SET cnpj = ?, nome = ?, endereco =? WHERE id = ?");
            stmt.setInt(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setInt(4, fornecedor.getId());
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

}
