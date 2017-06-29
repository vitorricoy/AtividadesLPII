/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.controller;

import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.cadlivros.model.service.ManterLivros;
import br.cefetmg.inf.cadlivros.model.service.impl.ManterLivrosImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author umcan
 */
public class PagEditarLivro {
    public static String processar(HttpServletRequest request){
        String jsp = "";
        try {
            ManterLivros manter = new ManterLivrosImpl();
            Livro l = manter.pesquisarPorIsbn(Long.parseLong(request.getParameter("isbn")));
            request.setAttribute("livro", l);
            jsp="editarLivro.jsp";
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
