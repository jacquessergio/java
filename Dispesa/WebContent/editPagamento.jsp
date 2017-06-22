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
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.maskMoney.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	$(".moeda").maskMoney({prefix:'R$ ', allowNegative: true, thousands:'', decimal:'.', affixesStay: false});
});

function reload(){
	
	window.opener.document.location.reload();
	
}

</script>

<% Salario d = new SalarioDAO().busca(Long.parseLong(request.getParameter("id"))); %>

<body onload="reload()">


<form action="salario" method="post"  >
	
	<input type="hidden" name="id_salario" value="<%=request.getParameter("id") %>">
	<input type="hidden" name="id_user" value="<%=request.getParameter("action") %>">
	<label>Data</label><br />
	<input type="text" name="data" value="<%=d.getFilraData() %>" /><br />
	<label>(R$) Valor</label><br />
	<input class="moeda" type="text" name="valor" value="<%=d.getValor() %>" /><br />
		
	<br />
	<input type="submit" value="Registrar" >

</form>

</html>