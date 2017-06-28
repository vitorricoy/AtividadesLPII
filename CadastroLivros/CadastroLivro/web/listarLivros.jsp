<%-- 
    Document   : listarLivros
    Created on : 27/06/2017, 23:56:47
    Author     : umcan
--%>
<%@page import="br.cefetmg.inf.cadlivros.model.domain.Livro" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Livro</title>
    </head>
    <body>
        <h1>Livros Cadastrados</h1>
        <%
            List<Livro> lista = (List<Livro>) request.getAttribute("listaLivros");
            for (Livro livro: lista) {
        %>                 
        <tr>
           <td>
               <%= livro.getNome() %>
           </td>
           <td>
             <a href="/CadastroLivro/ControllerServlet?pagina=PagEditarLivro&isbn=<%=livro.getIsbn()%>">Editar Livro</a>
           </td>
           <td>
              <input type='button' value='Excluir' href="/CadastroLivro/ControllerServlet?pagina=RemoverLivro&isbn=<%=livro.getIsbn()%>"/>
           </td>
        </tr>
        <%  } %>
    </body>
</html>
