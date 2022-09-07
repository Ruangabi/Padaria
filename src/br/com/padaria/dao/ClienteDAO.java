/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dao;

import br.com.padaria.dal.ModuloConexao;
import br.com.padaria.models.Cliente;
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
public class ClienteDAO {
    
    public List<Cliente> Select() throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Cliente> clientes = new ArrayList<>();

        try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNome(rs.getString("e_mail"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setNome(rs.getString("endereco"));
                clientes.add(cliente); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;   // Retorna a lista
    }
    
    public Cliente SelectOne(String cpf) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes AS c WHERE c.cpf = ?");
            stmt.setString(1, cpf);

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                cliente.setCpf(rs.getString("cpf"));
                
                cliente.setNome(rs.getString("nome"));
                
                cliente.setE_mail(rs.getNString("e_mail"));
                
                cliente.setTelefone(rs.getString("telefone"));

                cliente.setTelefone(rs.getString("endereco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }
    
    public void Insert(Cliente c) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO cliente VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getE_mail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEndereco());
            stmt.setDate(6, new Date(c.getCriadoEm().getTime()));

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
    
    public void Update(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, e_mail= ?, telefone = ?, endereco =? WHERE cpf = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getE_mail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());
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
    
//    public List<Cliente> Select() {
//        
//       Connection con = ModuloConexao.conector();
//       PreparedStatement stmt = null;
//       ResultSet rs = null;
//       
//       List<Cliente> clientes = new ArrayList<>();
//        ;
//    }
            
//    public Cliente SelectOne(int id){
//        
//    }
}
