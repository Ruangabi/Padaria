/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.padaria.dao;

import br.com.padaria.models.Fornecedor;
import br.com.padaria.models.Usuario;
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
public class UsuarioDAO {
    public List<Usuario> Select() throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
// Instanciando uma nova lista para receber os valores do banco
        List<Usuario> usuarios = new ArrayList<>();
        
         try {
            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery(); // Executa o comando SQL
            /* Loop responsável pela busca dos dados no banco que o repetirá até que não
 haja valores */
            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setIduser(rs.getInt("iduser"));
                usuario.setFone(rs.getString("fone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfil(rs.getString("perfil"));
                usuarios.add(usuario); // Adiciona o objeto na lista
            }
        } catch (SQLException ex) { // Tratamento das exceções
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;   // Retorna a lista  
        
    }
    
    public Usuario SelectOne(int iduser) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios AS u WHERE u.iduser = ?");
            stmt.setInt(1, iduser);

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario.setIduser(rs.getInt("iduser"));

                usuario.setFone(rs.getString("fone"));

                usuario.setLogin(rs.getString("login"));

                usuario.setSenha(rs.getString("senha"));
                
                usuario.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    public Usuario SelectOne(String nome) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Usuario u = new Usuario();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios AS u WHERE u.login like ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                u.setIduser(rs.getInt("iduser"));

                u.setFone(rs.getString("fone"));

                u.setLogin(rs.getString("login"));

                u.setSenha(rs.getString("senha"));
                
                u.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }
    
    public void Insert(Usuario u) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados

        con.setAutoCommit(false);

        PreparedStatement stmt = null;

        try {

            // Inserindo o comando SQL a ser usado
            stmt = con.prepareStatement("INSERT INTO usuarios VALUES (DEFAULT, ?, ?, ?, ?)");

            // O método setString, define que o valor passado será do tipo inteiro
            stmt.setString(1, u.getFone());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            

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
    
    public List<Usuario> Pesquisar(String termo) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList();

        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE login like ? or perfil like ?");
            

            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIduser(rs.getInt("iduser"));
                u.setFone(rs.getString("fone"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
                usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public void Update(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConnection();
        con.setAutoCommit(false);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET fone = ?, login = ?, senha = ?, perfil = ? WHERE iduser = ?");
            stmt.setString(1, usuario.getFone());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPerfil());
            stmt.setInt(5, usuario.getIduser());
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
