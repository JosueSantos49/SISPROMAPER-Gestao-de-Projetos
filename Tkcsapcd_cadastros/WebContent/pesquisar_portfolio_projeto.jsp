<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Relatório Portfólio de Projeto</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/validaPesquisarRelatorioProjeto.js"></script>

</head>

<body>

		<br><br>		

		<div align="center">
			  <%Connection con = null;
			    Statement st = null;  // Ou PreparedStatement
			    ResultSet rs = null;
					try
					{
						//Implementando Data e Hora
						Date data = new Date();//criando objeto tipo Date e inicializando 
						SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
						String mostra_data = data_formatada.format(data); //Variável para armazenar a data
						
						SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
						String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
						
						con = ConexaoHelper.conectar();						
						st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						
						//Implementando função ordenação de orden Crescente e Alfabetica
						//ResultSet rs = null;
						
						String sql;
						sql = "select * from portfolioprojeto where codigoprojeto like '"+request.getParameter("consProjeto")+"'";
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
				    	<!--Vai preencher a tabela com os registros nesta linha-->
						
						<div class="container">	  								
							<table class="table" style="border: 0px solid;"	align="center"	border="0" bordercolor="gray" cellpadding="2" width="700px">
							
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><h2>RELATÓRIO PORTFÓLIO DE PROJETO</h2></strong><hr></center></td>
					        	<td></td>					        				        						        				        	
					        </tr> 	
					        <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Código Projeto..:</strong> <%=rs.getString("codigoprojeto")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Prioridade..:</strong> <%=rs.getString("prioridade")%></td>
					         </tr>
					        <tr>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Tipo de Projeto..:</strong> <%=rs.getString("tipoprojeto")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Unidade de negócio ..:</strong> <%=rs.getString("unidadenegocio")%></td>	
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Analista de Projeto..:</strong> <%=rs.getString("analista")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Gerente de Projeto..:</strong> <%=rs.getString("gerente")%></td>						  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Fase ..:</strong> <%=rs.getString("fase")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Fase Atual..:</strong> <%=rs.getString("faseatual")%></td>						  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Previsão início do Projeto..:</strong> <%=rs.getString("datainicio")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Previsão Término do Projeto..:</strong> <%=rs.getString("datatermino")%></td>					  				
					         </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Previsão Fase Atual..:</strong> <%=rs.getString("dataatual")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Parte Interessada..:</strong> <%=rs.getString("parteinteressada")%></td>						  				
					         </tr>	
					         <tr>					        		
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Plano de Projeto ..:</strong> <%=rs.getString("planoprojeto")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Declaração do Escopo..:</strong> <%=rs.getString("declaracaoescopo")%></td>					  				
					         </tr>
					          <tr>					        	
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Dicionário da EAP..:</strong> <%=rs.getString("dicionarioeap")%></td>	
					        	<td></td>					  				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	
					         <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Cronograma..:</strong><br><%=rs.getString("cronograma")%></td>					        					        	
					        </tr>	
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Registro dos Riscos e Problemas..:</strong> <%=rs.getString("registrorisco")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Status Report..:</strong> <%=rs.getString("statusreport")%></td>						  				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Escopo..:</strong><br><%=rs.getString("escopo")%></td>					        						        					        	
					        </tr>	
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Custo..:</strong> <%=rs.getString("custo")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Nível..:</strong> <%=rs.getString("nivel")%></td>						  				
					         </tr>	
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Entrega..:</strong><br><%=rs.getString("entrega")%></td>					        					        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Recurso..:</strong><br><%=rs.getString("recursos")%></td>					        					        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	 
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Replanejamento..:</strong><br><%=rs.getString("replanejamento")%></td>					        					        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Estimativa..:</strong><br><%=rs.getString("estimativa")%></td>					        					        	
					        </tr> 
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Linha de Base..:</strong> <%=rs.getString("linhabase")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Esforço..:</strong> <%=rs.getString("esforco")%></td>						  				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Conclusão ..:</strong> <%=rs.getString("conclusao")%></td>
					        	<td></td>		  				
					         </tr> 
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr> 
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Etapa..:</strong><br><%=rs.getString("etapa")%></td>					        					        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>	 
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>EAP..:</strong><br><%=rs.getString("eap")%></td>					        					        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Responsável..:</strong><br><%=rs.getString("responsavel")%></td>					        					        	
					        </tr>    
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relatório Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relatório Gerado..:</strong> <%=mostra_hora %></td>
					        </tr>					       					      					         
				         </table>
				         
				         					
				    </div>

					<%
					 		}
						rs.close();
						st.close();
						con.close();
						}
						 
							catch(SQLException erroSQL)
							{
								out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
						}finally{
							 // fecha todos os recursos e devolve a conexao ao pool
						      if (rs != null && !rs.isClosed() ) {
						          try { rs.close(); } catch (SQLException e) { ; }
						          rs = null;
						      }
						      if (st != null && !st.isClosed() ) {
						          try { st.close(); } catch (SQLException e) { ; }
						          st = null;
						      }
						      if (con != null && !con.isClosed() ) {
						          try { con.close(); } catch (SQLException e) { ; }
						          con = null;
						      }
					}
					%>				
		</div>	
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarPortfolioProjeto'" title="Voltar página"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	<%@include file="gif_load_page.jsp" %> 
</body>
</html>