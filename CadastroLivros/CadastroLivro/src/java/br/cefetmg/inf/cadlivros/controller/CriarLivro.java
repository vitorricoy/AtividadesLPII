package br.cefetmg.inf.cadlivros.controller;

import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.cadlivros.model.service.ManterLivros;
import br.cefetmg.inf.cadlivros.model.service.impl.ManterLivrosImpl;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CriarLivro {
    public static String processar(HttpServletRequest request) throws ServletException{
        Livro l = new Livro();
        l.setAutor(request.getParameter("autor"));
        String data = request.getParameter("data");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            l.setData(sdf.parse(data));
        } catch (ParseException ex) {
            throw new ServletException(ex.getMessage());
        }
        l.setEditora(request.getParameter("editora"));
        l.setIsbn(Long.parseLong(request.getParameter("isbn")));
        l.setNome(request.getParameter("nome"));
        l.setNumPaginas(Integer.parseInt(request.getParameter("numPaginas")));
        l.setVolume(Integer.parseInt(request.getParameter("volume")));
        ManterLivros manter = new ManterLivrosImpl();
        try {
            manter.cadastrar(l);
        } catch (PersistenciaException | NegocioException ex) {
            request.setAttribute("erro", ex.getMessage());
            return "erro.jsp";
        }
        return "index.html";
    }
}
