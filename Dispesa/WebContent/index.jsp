<%@page import="local.dispesa.dao.UsuarioDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="local.dispesa.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de Dispesa</title>

<style type="text/css">
#index {
	margin: 100px 350px 200px 350px;
	font-family: arial;
	background-color: white;
	padding: 20px;
}

body{
	background-color: silver;
}
#nav{
	background-color: orange;
	padding: 10px;
	color: white;
}
#nav a{
	color: red;
	font-weight: bold;
	font-size: 16px;
	text-decoration: none;
}


</style>

<script type="text/javascript">

	function newPopup(URL){
		
		  var width = 200;
		  
		  var height = 300;
		  var left = 99;
		  var top = 150;
		 
		  window.open(URL,'janela', 'width='+width+', height='+height+', top='+top+', left='+left+', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');
		
		
	}

</script>

</head>
<body>

	<div id="index">
		<center>
			<h2>Controle de Despesas - Versão 1.0</h2>
			
			<%
			 
				
			 out.print("<p id='nav'><a href="+"javascript:newPopup('novoUsuario.jsp')"+"> Inserir usuario</a></p>");
			
			%>

			<%	
				SimpleDateFormat data = new SimpleDateFormat("yyyy-MM");
				
			    List<Usuario> u = new UsuarioDAO().lista();
			
				
			%>
				<% if(u.isEmpty()){
								
								out.print("<p>(!) Nenhum usuário cadastrado no sistema...</p>");
								
							}else{ %>
		
				<table border="1" width="100%">
					<thead>
						<tr>
							<th bgcolor="#CAE1FF">Nome</th>
							<th bgcolor="#CAE1FF">Email</th>
							<th bgcolor="#CAE1FF" colspan="3">Ação</th>

						</tr>
					</thead>
					<tbody>

						<%
							
							
							for (Usuario l : u) {
						%>

						<tr>
							<td><%=l.getNome()%></td>
							<td><%=l.getEmail()%></td>
							<td align="center"><a href="admin?action=<%=l.getId()%>&data=<%=data.format(new Date())%>">Acessar</a></td>
							<td align="center"><a href="javascript:newPopup('editUsuario.jsp?id=<%=l.getId()%>')">Editar</a></td>
							<td align="center"><a href="admin?action=del&id=<%=l.getId()%>">Remover</a></td>
						</tr>

						<%
							}
							
						%>

					</tbody>
				</table>
				<% } %>
			
			<hr />
			<small>Tecnologia >> JSP - JPA</small>
		</center>

	</div>
</body>
</html>