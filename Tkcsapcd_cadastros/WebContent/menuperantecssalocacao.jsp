<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<table border="0" height="45px" width="100%"  bgcolor="#101f29">
			<tr>
				<td>
					<br>
					<div align="center"><font color="#ffffff"><h4><strong>ALOCAÇÃO MÉTRICA</strong></h4></font></div>	
					<div align="right"><font color="#D6D6D6"><strong>Usuário: </strong>					
						<%=session.getAttribute("theName")%>
							<%  
							//verifica se a sessao do usuario é válida  
							if(session.getAttribute("theName")==null)  
							{  
								request.getRequestDispatcher("testelogin.jsp").forward(request, response);    
							}  
						%>						
						</font> </div>
						<div align="right">
						   	<%
							Date data = new Date();//criando objeto tipo Date e inicializando 
							SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
							String mostra_data = data_formatada.format(data); //Variável para armazenar a data
							
							SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
							String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)						
						   	%>					   	
						   <p align="right"><font color="#D6D6D6" ><strong>Data de Acesso: </strong><%=mostra_data %> <%=mostra_hora %></font></p>
					   </div>
				</td>
			</tr>			
		</table>
		<table align="left" bgcolor="#CCCCCC" height="100%"  width="100%" border="0">
			<tr>
				<td>			
					  <ul class="menu">
					        <li><a href="index_principal.jsp">Home</a></li>
					        <li><a href="#">Alocação</a>
						            <ul>
						        	    	<li><a href="TkcsapcdController?cmd=editarAlocacao" target="_parent">Cadastrar Alocação</a></li>
						                    <li><a href="TkcsapcdController?cmd=consultarAlocacao" target="_parent">Consultar Alocação</a></li>
						                    <li><a href="imprimir_alocacao.jsp" target="_parent">Relatório Alocação</a></li>                  
						            </ul>
						    </li>
						    <li><a href="sair.jsp">Logout</a></li>
					  </ul>													
				</td>
			</tr>
		</table>  
