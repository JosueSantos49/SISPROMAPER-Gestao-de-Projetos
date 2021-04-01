<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<title>Status registro</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>

<body>


	<div align="center"><br><h3 align="center"><center><font color="#0404B4"><strong>STATUS REGISTRO</strong></font></center></h3>
	
	<h3 align="center">
				<br><br>
				<div align="center">		
					<font color="#D6D6D6">Usuário:
						
						<%=session.getAttribute("theName")%>
						<%  
						//verifica se a sessao do usuario é válida  
						if(session.getAttribute("theName")==null)  
						{  
							request.getRequestDispatcher("testelogin.jsp").forward(request, response);    
							//response.sendRedirect("testelogin.jsp");  
						}  
						%>						
					</font>						
				</div>
					<div align="center">
					   	<%
						Date data = new Date();//criando objeto tipo Date e inicializando 
						SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
						String mostra_data = data_formatada.format(data); //Variável para armazenar a data
						
						SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
						String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)						
					   	%>					   	
					   <p align="center"><font color="#D6D6D6">Data de Acesso: <%=mostra_data %> <%=mostra_hora %></font></p>
				   </div>
	</h3>
	
	<br>	
		
					${mensagem}
	
					<br>
					<center>
						<font color="green">
							<%
								//Confirmação de Envio de E-mail
								String msg = (String) request.getAttribute("msg");
								if(msg != null)
			        			out.println(msg);
					        %>
			        	</font>
			        </center>
			        <strong><a href="consulta_organograma_propriedade.jsp" target="_parent">Clique aqui para consultar registro!</a></strong><br>
	
	<br><br>
	<table width="25%" border="0" align="center">
		<tr>		
			<td width="84%"><input class="button" name="" type="button" target="_blank" onClick="window.open('index_principal.jsp')" value="Home"></td>
		</tr>
	</table>	
</body>
</html>