/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.controller;

import br.cefetmg.inf.cadlivros.model.service.ManterLivros;
import br.cefetmg.inf.cadlivros.model.service.impl.ManterLivrosImpl;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author umcan
 */
public class RemoverLivro {
    public static String processar(HttpServletRequest request) throws ServletException{
        ManterLivros manter = new ManterLivrosImpl();
        try {
            manter.remover(Long.parseLong(request.getParameter("isbn")));
        } catch (PersistenciaException | NegocioException ex) {
            request.setAttribute("erro", ex.getMessage());
            return "erro.jsp";
        }
        return "index.html";
    }
}
