/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.model.service.impl;

import br.cefetmg.inf.cadlivros.model.dao.LivroDAO;
import br.cefetmg.inf.cadlivros.model.dao.impl.LivroDAOImpl;
import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.cadlivros.model.service.ManterLivros;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ManterLivrosImpl implements ManterLivros{
    
    LivroDAO livroDAO;
    
    public ManterLivrosImpl(LivroDAOImpl dao) {
        livroDAO=dao;
    }

    public ManterLivrosImpl() {
        livroDAO = new LivroDAOImpl();
    }
    
    
    
    @Override
    public boolean cadastrar(Livro livro) throws PersistenciaException, NegocioException {
        if((livro.getNome() == null) || (livro.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        if((livro.getAutor() == null) || (livro.getAutor().isEmpty()))
            throw new NegocioException("Obrigatório informar o autor.");
        if((livro.getEditora() == null) || (livro.getEditora().isEmpty()))
            throw new NegocioException("Obrigatório informar a editora.");
        if(livro.getData() == null)
            throw new NegocioException("Obrigatório informar a data.");
        if((livro.getNumPaginas() == null) || (livro.getNumPaginas() == 0))
            throw new NegocioException("Obrigatório informar o numero de paginas.");
        if((livro.getVolume() == null) || (livro.getVolume() == 0))
            throw new NegocioException("Obrigatório informar o volume.");
        if((livro.getIsbn() == null) || (livro.getIsbn() == 0))
            throw new NegocioException("Obrigatório informar o isbn.");

        return livroDAO.inserir(livro);
    }

    @Override
    public boolean atualizar(Livro livro) throws PersistenciaException, NegocioException {
        if((livro.getNome() == null) || (livro.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        if((livro.getAutor() == null) || (livro.getAutor().isEmpty()))
            throw new NegocioException("Obrigatório informar o autor.");
        if((livro.getEditora() == null) || (livro.getEditora().isEmpty()))
            throw new NegocioException("Obrigatório informar a editora.");
        if(livro.getData() == null)
            throw new NegocioException("Obrigatório informar a data.");
        if((livro.getNumPaginas() == null) || (livro.getNumPaginas() == 0))
            throw new NegocioException("Obrigatório informar o numero de paginas.");
        if((livro.getVolume() == null) || (livro.getVolume() == 0))
            throw new NegocioException("Obrigatório informar o volume.");
        if((livro.getIsbn() == null) || (livro.getIsbn() == 0))
            throw new NegocioException("Obrigatório informar o isbn.");
        
        return livroDAO.atualizar(livro);
    }

    @Override
    public boolean remover(Long isbn) throws PersistenciaException, NegocioException {
        if((isbn == null) || (isbn == 0))
            throw new NegocioException("Obrigatório informar o isbn.");
        return livroDAO.remover(isbn);
    }

    @Override
    public Livro pesquisarPorIsbn(Long isbn) throws PersistenciaException, NegocioException {
        if((isbn == null) || (isbn == 0))
            throw new NegocioException("Obrigatório informar o isbn.");
        return livroDAO.obterPorISBN(isbn);
    }

    @Override
    public List<Livro> pesquisarTodosLivros() throws PersistenciaException, NegocioException {
        return livroDAO.obterTodosLivros();
    }
    
    
}
