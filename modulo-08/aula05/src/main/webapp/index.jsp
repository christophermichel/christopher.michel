<%@page import="br.com.crescer.aula04.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="br.com.crescer.aula04.FuncionarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Pessoa</title>
    </head>

    <body>
        <%
        FuncionarioDao fDao = new FuncionarioDao();
        List<Funcionario> funcionarios = fDao.findAll();

        for (Funcionario funcionario : funcionarios ) {
        %>
        <li><%=funcionario.getNome()%>, <%=funcionario.getRg()%></li>

    </body>

</html>