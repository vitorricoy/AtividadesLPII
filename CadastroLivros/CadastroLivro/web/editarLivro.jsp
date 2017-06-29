<%-- 
    Document   : editarLivro
    Created on : 27/06/2017, 23:53:58
    Author     : umcan
--%>

<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.inf.cadlivros.model.domain.Livro" %>
<%  Livro livro = (Livro) request.getAttribute("livro");
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Livro <%=livro.getNome()%></title>
    </head>
    <body>
        <h1>Editar Livro</h1>
        <form name="formLivro" method="post" action="/CadastroLivro/ControllerServlet?pagina=editarLivro">
            Nome do Livro: <input name="nome" type="text" required="required" value="<%=livro.getNome()%>" /><br><br>
            Autor do Livro: <input name="autor" type="text" required="required" value="<%=livro.getAutor()%>"/><br><br>
            ISBN do Livro: <input name="isbn" type="number" required="required" value="<%=livro.getIsbn()%>"/><br><br>
            Volume do Livro: <input name="volume" type="number" required="required" value="<%=livro.getVolume()%>"/><br><br>
            Data de Lançamento: <input name="data" type="date" required="required" value="<%=formatter.format(livro.getData())%>"/><br><br>
            Editora do Livro: <input name="editora" type="text" required="required" value="<%=livro.getEditora()%>"/><br><br>
            Número de Páginas <input name="numPaginas" type="number" required="required" value="<%=livro.getNumPaginas()%>"/><br><br>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
