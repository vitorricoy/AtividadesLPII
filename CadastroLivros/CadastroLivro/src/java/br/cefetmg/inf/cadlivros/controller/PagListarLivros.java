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
public class PagListarLivros {
    public static String processar(HttpServletRequest request){
        String jsp = "";
        try {
            ManterLivros manter = new ManterLivrosImpl();
            List<Livro> lista = manter.pesquisarTodosLivros();
            request.setAttribute("ListaLivros", lista);
            jsp="listarLivros.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
