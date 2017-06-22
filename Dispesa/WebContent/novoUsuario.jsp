<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Usuario</title>
</head>

<script type="text/javascript">


function reload(){
	
	window.opener.document.location.reload();
	
}

</script>

<body onload="reload()">


<form action="admin" method="post"  >

	<label>Nome</label><br />
	<input type="text" name="nome" /><br />
	<label>E-mail</label><br />
	<input type="text" name="email" /><br />
	<label>Senha</label><br />
	<input type="password" name="senha" /><br />


	
	<br />
	<input type="submit" value="Registrar" >

</form>

</html>