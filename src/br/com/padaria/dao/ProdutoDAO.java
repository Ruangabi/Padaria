/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dao;

import br.com.padaria.dal.ModuloConexao;
import br.com.padaria.models.Produto;

import conexao.Conexao;
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

public class ProdutoDAO {

    public List<Produto> Select() throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Produto> produtos = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setCodigo_pro(rs.getString("codigo_pro"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome(rs.getString("nome"));
                produto.setValor_R$(rs.getBigDecimal("valor_R$"));
                produtos.add(produto);

            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;   // Retorna a lista
    }

    public Produto SelectOne(String codigo_pro) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Produto produto = new Produto();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto AS p WHERE p.codigo_pro = ?");
            stmt.setString(1, codigo_pro);

            rs = stmt.executeQuery();

            while (rs.next()) {

                produto.setCodigo_pro(rs.getString("codigo_pro"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome(rs.getString("nome"));
                produto.setValor_R$(rs.getBigDecimal("valor_R$"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    public void Insert(Produto p) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO produto VALUES (?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro           
            stmt.setString(1, p.getCodigo_pro());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getNome());
            stmt.setBigDecimal(4, p.getValor_R$());
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

    public List<Produto> Pesquisar(String termo, String opcao) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Produto> produtos = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            if (opcao.equals("Nome")) {
                stmt = con.prepareStatement("SELECT * FROM produto WHERE nome like ?");
            } else {
                stmt = con.prepareStatement("SELECT * FROM produto WHERE codigo_pro like ?");
            }
            stmt.setString(1, "%" + termo + "%");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setCodigo_pro(rs.getString("codigo_pro"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome(rs.getString("nome"));
                produto.setValor_R$(rs.getBigDecimal("valor_R$"));
                produtos.add(produto);
                // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    public void Update(Produto produto) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ?, nome= ?, valor_R$ = ? WHERE codigo_pro = ?");

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getNome());
            stmt.setBigDecimal(3, produto.getValor_R$());
            stmt.setString(4, produto.getCodigo_pro());
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
