<%-- 
    Document   : crud01
    Created on : 31 de jan de 2022, 20:19:52
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Unidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css">
        <title>IFRS Restinga</title>        
    </head>
    <body>

        <div id="principal">

            <div id="banner"><i class="fas fa-sign-out-alt"></i></div>

            <div id="logo">
                <img src="images/logo.png" alt="logo do Instituto Federal"/>
            </div>


            <div id="menu">
                <ul class="itens"> 
                    <li><a href="index.html"><i class="fas fa-align-justify"></i></i> Home</a></li><br><br>
                    <li><a href="crud.html"><i class="fas fa-address-card"></i> CRUD 1</a></li><br><br>
                    <li><a href="crud2.html"><i class="fas fa-address-card"></i> CRUD 2</a></li><br><br>
                </ul>
            </div>

            <div id="conteudo">
                <h1>CRUD 1</h1>
                <hr>
                <label for="pesquisa">Filtro 01</label>
                <input type="text" id="pesquisa" name="pesquisa"> <button class="bt-filtro">Filtrar</button>

                <div class="lista-consulta">
                    <table border="1">
                        <tr>
                            <th>CNPJ</th>
                            <th>Nome</th>
                            <th>Logradouro</th>
                            <th>Numero</th>
                            <th>Complemento</th>
                            <th>Bairro</th>
                            <th>CEP</th>
                            <th>Telefone</th>
                            <th>Microregião</th>
                            <th>E-mail</th>
                        </tr>

                        <%
                            List<Unidade> unidades = (List<Unidade>) request.getAttribute("resultado");
                            for (int i = 0; i < unidades.size(); i++) {
                                Unidade u = unidades.get(i);
                        %>

                        <tr>
                            <td><%= u.getCnpj()%></td>
                            <td><%= u.getNome()%></td>
                            <td><%= u.getLogradouro()%></td>
                            <td><%= u.getNumero()%></td>
                            <td><%= u.getComplemento()%></td>
                            <td><%= u.getBairro()%></td><!-- comment -->
                            <td><%= u.getCep()%></td>
                            <td><%= u.getTelefone()%></td>
                            <td><%= u.getMicroregiao()%></td> 
                            <td><%= u.getEmail()%></td>
                        </tr>
                        <%
                            }
                        %>
                </div>

                <a href="inserirUnidade.html"><button class="bt-inserir">Inserir</button></a> <button class="bt-atualizar">Atualizar</button> <button class="bt-excluir">Excluir</button>

            </div>
            <div id="rodape-crud">

                <a href="index.html"><i class="fa fa-home"></i></a>
            </div>

        </div>

    </body>
</html>
