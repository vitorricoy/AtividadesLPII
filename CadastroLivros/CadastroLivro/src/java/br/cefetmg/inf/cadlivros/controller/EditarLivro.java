/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.cadlivros.controller;

import br.cefetmg.inf.cadlivros.model.domain.Livro;
import br.cefetmg.inf.cadlivros.model.service.ManterLivros;
import br.cefetmg.inf.cadlivros.model.service.impl.ManterLivrosImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author umcan
 */
public class EditarLivro {
    public static String processar(HttpServletRequest request){
        String jsp = "";
        try {
            Livro l = new Livro();
            l.setAutor(request.getParameter("autor"));
            String data = request.getParameter("data");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
            manter.atualizar(l);
            jsp="index.html";
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
