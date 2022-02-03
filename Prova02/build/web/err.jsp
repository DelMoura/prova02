<%-- 
    Document   : erro
    Created on : 31 de jan de 2022, 01:50:36
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERRO!!</h1>

        <%
            String mensagem = (String) request.getAttribute("mensagem");
        %>
        <p><%= mensagem%></p>

    </body>
</html>
