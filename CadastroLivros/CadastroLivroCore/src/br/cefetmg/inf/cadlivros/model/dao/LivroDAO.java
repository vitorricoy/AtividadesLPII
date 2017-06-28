package br.cefetmg.inf.cadlivros.model.dao;

import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface LivroDAO {
    public boolean inserir(Livro livro) throws PersistenciaException;
    public boolean remover(Long isbn) throws PersistenciaException;
    public boolean atualizar(Livro livro) throws PersistenciaException;
    public Livro obterPorISBN(Long isbn) throws PersistenciaException;
    public List<Livro> obterTodosLivros() throws PersistenciaException;
}
