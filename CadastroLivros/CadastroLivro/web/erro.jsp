<%-- 
    Document   : erro
    Created on : 29/06/2017, 08:17:54
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  String erro = (String) request.getAttribute("erro"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Erro</h1>
        <p><%=erro %></p>
    </body>
</html>
