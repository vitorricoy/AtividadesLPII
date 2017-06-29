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
        <table style="border-collapse: collapse;">
            <%
                List<Livro> lista = (List<Livro>) request.getAttribute("listaLivros");
                if(!lista.isEmpty()){
            %>
                <tr>
                    <th style="border: 1px solid black">Nome</th>
                    <th style="border: 1px solid black">Editar</th>
                    <th style="border: 1px solid black">Excluir</th>
                </tr>
            <%      for (Livro livro: lista) {
            %>                 
            <tr>
               <td style="border: 1px solid black">
                   <%= livro.getNome() %>
               </td>
               <td style="border: 1px solid black">
                   <a href="/CadastroLivro/ControllerServlet?pagina=pagEditarLivro&isbn=<%=livro.getIsbn()%>"><button>Editar</button></a>
               </td>
               <td style="border: 1px solid black">
                   <a href="/CadastroLivro/ControllerServlet?pagina=removerLivro&isbn=<%=livro.getIsbn()%>"><button>Excluir</button></a>
               </td>
            </tr>
            <%      }
            %>
            </table>
            <%
                }else{
            %>
            </table>
            <p>Sem Livros</p>
            <%
              }  
            %>
    </body>
</html>
