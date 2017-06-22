<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="s" uri="/struts-tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona carro</title>
</head>
<body>

<h1>Adiciona Carro</h1>
<h2>JPA com Struts</h2>

<s:form action="AdicionaCarro">
	
	<s:label value="Marca: "/>
	<s:textfield name="carro.marca" />
	
	<s:label value="Modelo: " />
	<s:textfield name="carro.modelo" />
	
	<s:submit value="Enviar" />
</s:form>

</body>
</html>