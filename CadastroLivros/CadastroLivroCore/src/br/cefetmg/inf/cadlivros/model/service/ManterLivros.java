/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.model.service;

import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface ManterLivros {
    public boolean cadastrar(Livro livro) throws PersistenciaException, NegocioException;
    public boolean atualizar(Livro livro) throws PersistenciaException, NegocioException;
    public boolean remover(Long isbn) throws PersistenciaException, NegocioException;
    public Livro pesquisarPorIsbn(Long isbn) throws PersistenciaException, NegocioException;
    public List<Livro> pesquisarTodosLivros() throws PersistenciaException, NegocioException;
}
