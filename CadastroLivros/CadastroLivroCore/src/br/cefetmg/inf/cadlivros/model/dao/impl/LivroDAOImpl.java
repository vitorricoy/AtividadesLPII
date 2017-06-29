/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.model.dao.impl;

import br.cefetmg.inf.cadlivros.model.dao.LivroDAO;
import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class LivroDAOImpl implements LivroDAO{
    
    @Override
    public boolean inserir(Livro livro) throws PersistenciaException{
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO livro (nome, autor, isbn, volume, data, editora, numpaginas) VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, livro.getNome());
            pstmt.setString(2, livro.getAutor());
            pstmt.setLong(3, livro.getIsbn());
            pstmt.setInt(4, livro.getVolume());
            pstmt.setDate(5, new java.sql.Date(livro.getData().getTime()));
            pstmt.setString(6, livro.getEditora());
            pstmt.setInt(7, livro.getNumPaginas());
            boolean sucesso = pstmt.execute();
            pstmt.close();
            connection.close();
            return sucesso;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean remover(Long isbn) throws PersistenciaException{
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM livro WHERE isbn = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, isbn);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Livro livro) throws PersistenciaException{
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE livro SET nome = ?, autor = ?, volume = ?, data = ?, editora = ?, numpaginas = ? WHERE isbn = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, livro.getNome());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getVolume());
            pstmt.setDate(4, new java.sql.Date(livro.getData().getTime()));
            pstmt.setString(5, livro.getEditora());
            pstmt.setInt(6, livro.getNumPaginas());
            pstmt.setLong(7, livro.getIsbn());
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();     
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Livro obterPorISBN(Long isbn) throws PersistenciaException{
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM livro WHERE isbn = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            Livro livro = null;
            if (rs.next()) {
                livro = new Livro();
                livro.setIsbn(rs.getLong("isbn"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setData(rs.getDate("data"));
                livro.setEditora(rs.getString("editora"));
                livro.setNumPaginas(rs.getInt("numpaginas"));
                livro.setVolume(rs.getInt("volume"));
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return livro;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public List<Livro> obterTodosLivros() throws PersistenciaException{
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM livro ORDER BY autor";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Livro> todosLivros = new ArrayList<>();
            if (rs.next()) {
                do {
                    Livro livro = new Livro();
                    livro.setIsbn(rs.getLong("isbn"));
                    livro.setNome(rs.getString("nome"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setData(rs.getDate("data"));
                    livro.setEditora(rs.getString("editora"));
                    livro.setNumPaginas(rs.getInt("numpaginas"));
                    livro.setVolume(rs.getInt("volume"));
                    todosLivros.add(livro);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            connection.close();
            return todosLivros;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
    
}
