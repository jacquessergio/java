<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo 1</title>
</head>
<body>
	
	<h1>Formulário</h1>
	
	<s:form action="Teste">
		
		<s:label value="Informe seu Nome:" />
		
		<s:textfield name="texto" />
		
		<s:submit value="Enviar" />
	
	</s:form>
	
</body>
</html>