<%@page import="java.util.Date"%>
<%@page import="local.dispesa.entidades.Salario"%>
<%@page import="local.dispesa.dao.SalarioDAO"%>
<%@page import="local.dispesa.util.FormatoMoeda"%>
<%@page import="local.dispesa.dao.DispesasDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="local.dispesa.entidades.Dispesas"%>
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
body{
	background-color: silver;
}

#index {
	margin: 100px 100px 200px 100px;
	font-family: arial;
	background-color: white;
	padding: 20px;
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
#link-mes{
	
	font-size: 13px; 
	font-weight: bold;

}
#link-mes a{
	
	padding: 5px;
	background-color: #CAE1FF;
	text-decoration: none;
	border-radius: 5px;
    color: black;
}
#link-mes a:hover{
	
	background-color: orange;
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


			
			<%
			
			
			Date d= new Date();
			
			SimpleDateFormat ano = new SimpleDateFormat("yyyy");
			
			DispesasDAO disp = new DispesasDAO();

			FormatoMoeda moeda = new FormatoMoeda();

			Integer id = Integer.parseInt(request.getParameter("action"));
				
			String URL   = "?action="+id+"&data="+request.getParameter("data");
			String URL_2 = "?action="+id+"";
			
			List<Dispesas> u = (List) request.getAttribute("lista");
			
			List<Salario> s = (List) request.getAttribute("salario");
			
			%>
			

	<div id="index">
	
	<center>

		<div id="link-mes">

			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-01"%>">JANEIRO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-02"%>">FEVEREIRO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-03"%>">MARÇO</a> |
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-04"%>">ABRIL</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-05"%>">MAIO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-06"%>">JUNHO</a> |
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-07"%>">JULHO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-08"%>">AGOSTO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-09"%>">SETEMBRO</a> |
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-10"%>">OUTUBRO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-11"%>">NOVEMBRO</a> | 
			<a href="?action=<%=id%>&data=<%=ano.format(new Date())+"-12"%>">DEZEMBRO</a>
			<a href="javascript:newPopup('balanco.jsp<%=URL_2%>')">B. ANUAL</a>
			
		</div>
		
	</center>
		
			
			
			
			
		
		

		<%
		   
		   out.print("<p id='nav'><a href="+"javascript:newPopup('novaDespesa.jsp"+URL+"')"+"> Inserir despesa</a> | " + 
				     "<a href="+"javascript:newPopup('novoPagamento.jsp"+URL+"')"+">Inserir pagamento</a> | "+
				     "<a href='usuario?action=list'>Sair (X)</a></p>");
		
		
		    if(s == null){
		    	
		   out.print("<p>(!) Nenhum pagamento adicionado...</p>");
		    	
		    }else{
			
		    	
		    	
			for (Salario g : s) {
				
		%>


		<p><%="Data: " + g.getData().getTime().toLocaleString() + " - Salário:=  "
						+ moeda.frmMoeda((Double) g.getValor())%>
		
		<a href="javascript:newPopup('editPagamento.jsp<%=URL %>&id=<%=g.getId()%>')">Editar</a> | 
		<a href="salario<%=URL %>&id=<%=g.getId()%>">Remover</a>
		</p>

		<%	
			  } 
				
		    
		%>
 
		<h3>
			Total:
			<%=moeda.frmMoeda((Double) request.getAttribute("salarioSoma"))%>
		</h3>
		
		<% } %>
		
		<%
		
		if(u == null){ %>
			
		<h3>Não há lançamentos para o mês: <%=request.getParameter("data") %></h3>	
		
		<% }else{
			
		%>
		
		<h3>Mês: <%=request.getParameter("data") %></h3>
		
		<center>
			
				<table border="1" width="100%">
					<thead>
						<tr>
							<th bgcolor="#CAE1FF">Descrição</th>
							<th bgcolor="#CAE1FF">Data</th>
							<th bgcolor="#CAE1FF">Qtd. Parcelas</th>
							<th bgcolor="#CAE1FF">(R$) Valor</th>
							<th bgcolor="#CAE1FF">Observação</th>
							<th bgcolor="#CAE1FF" colspan="2">Ação</th>

						</tr>
					</thead>
					<tbody>

						<%
							
							for (Dispesas l : u) {
						%>

						<tr>

							<td align="center"><%=l.getDescricao()%></td>
							<td align="center"><%=l.getData().getTime().toLocaleString()%></td>
							<td align="center"><%=l.getParcelas()%></td>
							<td align="center"><%=moeda.frmMoeda((Double) l.getValor())%></td>
							<td><%=l.getObservacao()%></td>
							<td align="center"><a href="javascript:newPopup('editDespesa.jsp<%=URL %>&id=<%=l.getId()%>')">Editar</a></td>
							<td align="center"><a href="novaDespesa<%=URL %>&id=<%=l.getId()%>">Excluir</a></td>

						</tr>

						<%
							}
						%>
						<tr>
							<%
								String getTotal = moeda.frmMoeda(disp.soma(request.getParameter("data"), id));
							%>

							<td align="right" colspan="3">Total em Dispesas</td>
							<td align="center"><%=getTotal%></td>
							<td colspan="3"></td>
						</tr>
						

					</tbody>
				</table>

		
			<h4>
				
				<% if(s == null){
		    	
					out.print("Saldo devedor: " + getTotal );
		  		  
		  		  }else{ %>
				
				 Saldo:
				
				<%=moeda.frmMoeda(((Double) request.getAttribute("salarioSoma")) - disp.soma(request.getParameter("data"),id))%>
				
				  <% } %>
			
			</h4>
			
			<%} %>
			<hr />
			<small>Controle de Despesas - Versão 1.0 - Tecnologia >> JSP - JPA</small>
		</center>

	</div>

</body>
</html>