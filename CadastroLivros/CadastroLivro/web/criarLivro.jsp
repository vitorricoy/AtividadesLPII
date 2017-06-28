<%-- 
    Document   : criarLivro
    Created on : 27/06/2017, 23:53:31
    Author     : umcan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Livro</title>
    </head>
    <body>
        <h1>Criar Livro</h1>
        <form name="formLivro" method="post" action="/ControllerServlet?pagina=criarLivro">
            Nome do Livro: <input name="nome" type="text" required="required"/><br><br>
            Autor do Livro: <input name="autor" type="text" required="required"/><br><br>
            ISBN do Livro: <input name="isbn" type="number" required="required"/><br><br>
            Volume do Livro: <input name="volume" type="number" required="required"/><br><br>
            Data de Lançamento: <input name="data" type="date" required="required"/><br><br>
            Editora do Livro: <input name="editora" type="text" required="required"/><br><br>
            Número de Páginas <input name="numPaginas" type="number" required="required"/><br><br>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
