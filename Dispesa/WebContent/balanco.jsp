<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="local.dispesa.dao.BalancoDao"%>
<%@page import="local.dispesa.dao.SalarioDAO"%>
<%@page import="local.dispesa.entidades.Salario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova despesa</title>
</head>
<style type="text/css">

body{
	
	font-family: Arial;
	font-size: 16px;

}
</style>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.maskMoney.min.js"></script>

<script type="text/javascript">


</script>

<%
    Integer id = Integer.parseInt(request.getParameter("action")); 
	BalancoDao b = new BalancoDao();
	SimpleDateFormat ano = new SimpleDateFormat("yyyy");
%>

<body>
<h3>*Balanço Anual - <%=ano.format(new Date())%></h3>

<fieldset>
	<legend>Total em Despesas</legend>
	
	<b>R$   <%=b.dispesaAno(id) %></b>

</fieldset>

<hr />

<fieldset>
	<legend>Total em Pagamentos</legend>
	
	<b>R$ <%=b.pagamentoAno(id) %></b>

</fieldset>
</html>