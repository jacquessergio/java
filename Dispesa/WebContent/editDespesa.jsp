<%@page import="local.dispesa.entidades.Dispesas"%>
<%@page import="local.dispesa.dao.DispesasDAO"%>
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

<% Dispesas d = new DispesasDAO().busca(Long.parseLong(request.getParameter("id"))); %>

<body onload="reload()">


<form action="novaDespesa" method="post"  >
	
	<input type="hidden" name="id_disp" value="<%=request.getParameter("id") %>">
	<input type="hidden" name="id" value="<%=request.getParameter("action") %>">
	<label>Descrição</label><br />
	<input type="text" name="descricao" value="<%=d.getDescricao() %>" /><br />
	<label>Data</label><br />
	<input type="text" name="data" value="<%=d.getFiltraData()%>" /><br />
	<label>Qtd. Parcelas</label><br />
	<input type="text" name="parcelas" value="<%=d.getParcelas() %>" /><br />
	<label>(R$) Valor</label><br /> 
	<input class="moeda" type="text" name="valor" value="<%=d.getValor() %>" /><br />
	<label>Observação</label><br />
	<textarea rows="4" name="observacao" ><%=d.getObservacao() %></textarea>
	
	<br />
	<input type="submit" value="Registrar" >

</form>

</html>