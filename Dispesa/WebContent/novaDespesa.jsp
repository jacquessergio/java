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

<body onload="reload()">


<form action="novaDespesa" method="post"  >

	<input type="hidden" name="id" value="<%=request.getParameter("action") %>">
	<label>Descrição</label><br />
	<input type="text" name="descricao" /><br />
	<label>Data</label><br />
	<input type="text" name="data" value="<%=request.getParameter("data") %>" /><br />
	<label>Qtd. Parcelas</label><br />
	<input type="text" name="parcelas" /><br />
	<label>(R$) Valor</label><br />
	<input class="moeda" type="text" name="valor" /><br />
	<label>Observação</label><br />
	<textarea rows="4" name="observacao" ></textarea>
	
	<br />
	<input type="submit" value="Registrar" >

</form>

</html>