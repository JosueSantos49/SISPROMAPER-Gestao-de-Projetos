<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<table border="0" height="45px" width="100%"  bgcolor="#101f29">
			<tr>
				<td>
					<br>
					<div align="center"><font color="#ffffff"><h4><strong>ALOCA��O M�TRICA</strong></h4></font></div>	
					<div align="right"><font color="#D6D6D6"><strong>Usu�rio: </strong>					
						<%=session.getAttribute("theName")%>
							<%  
							//verifica se a sessao do usuario � v�lida  
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
							String mostra_data = data_formatada.format(data); //Vari�vel para armazenar a data
							
							SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
							String mostra_hora = hora_formatada.format(data); //Vari�vel para armazenar a hora(aproveitando o mesmo objeto data)						
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
					        <li><a href="#">Aloca��o</a>
						            <ul>
						        	    	<li><a href="TkcsapcdController?cmd=editarAlocacao" target="_parent">Cadastrar Aloca��o</a></li>
						                    <li><a href="TkcsapcdController?cmd=consultarAlocacao" target="_parent">Consultar Aloca��o</a></li>
						                    <li><a href="imprimir_alocacao.jsp" target="_parent">Relat�rio Aloca��o</a></li>                  
						            </ul>
						    </li>
						    <li><a href="sair.jsp">Logout</a></li>
					  </ul>													
				</td>
			</tr>
		</table>  
