<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formata��o	 -->
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Cliente"%>

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

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da p�gina -->

<title>Relat�rio Plano de Gerenciamento das Comunica��es</title>

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
						String mostra_data = data_formatada.format(data); //Vari�vel para armazenar a data
						
						SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
						String mostra_hora = hora_formatada.format(data); //Vari�vel para armazenar a hora(aproveitando o mesmo objeto data)
						
						con = ConexaoHelper.conectar();						
						st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						
						//Implementando fun��o ordena��o de orden Crescente e Alfabetica
						//ResultSet rs = null;
						
						String sql;
						sql = "select * from planogerenciamentocomunicacao where codigoprojeto like '"+request.getParameter("consProjeto")+"'";
						rs = st.executeQuery(sql);//executeQuery � usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery � usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
				    	<!--Vai preencher a tabela com os registros nesta linha-->
							
						<div align="" >    								
							<table style="border: 1px solid;"	align="center"	border="0" bordercolor="gray" cellpadding="2" width="800px">
							
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><h2>RELAT�RIO PLANO DE GERENCIAMENTO DAS COMUNICA��ES</h2></strong><hr></center></td>					        				        	
					        	<!-- <td bgcolor="#FFFFFF">&nbsp;<img align="left" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"> </td> -->
					        				        	
					        </tr> 					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>C�digo do Registro..:</strong> <%=rs.getString("codigo")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Data..:</strong> <%=rs.getString("data")%></td>				  							  
					          			        				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Plano de Ger. Comunica��es..:</strong> <%=rs.getString("planogerenciamentocomunicacao")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Nome do Projeto..:</strong> <%=rs.getString("projeto")%></td>
							  				
					         </tr>
					         
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>C�digo do Projeto..:</strong> <%=rs.getString("codigoprojeto")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Vers�o..:</strong> <%=rs.getString("versao")%></td>
					        </tr>
					        
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>
					        				        	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Autor..:</strong> <%=rs.getString("autor")%></td>
					        	<td bgcolor="#FFFFFF" >&nbsp;</td>				        	
					        </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Nota de Revis�o..:</strong> <%=rs.getString("notarevisao")%></td>
					        	<td bgcolor="#FFFFFF" >&nbsp;</td>				        	
					        </tr>
					       <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>1	Objetivo do Plano de gerenciamento das comunica��es </strong><br><br><font >&nbsp;<%=rs.getString("objetivo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2	Processos do Gerenciamento das Comunica��es </strong><br><br><font >&nbsp;<%=rs.getString("processo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.1	Requisitos de comunica��o das partes interessadas</strong><br><br><font >&nbsp;<%=rs.getString("requisito")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.2	Informa��es a serem comunicadas</strong><br><br><font >&nbsp;<%=rs.getString("informcacao")%></font></td>						          				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.3	Tecnologias e Ferramentas usados para comunicar</strong><br><br><font >&nbsp;<%=rs.getString("tecnologia")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4	Diretrizes e procedimentos usados para comunicar</strong><br><br><font >&nbsp;<%=rs.getString("diretrize")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.1	Comunica��o geral</strong><br><br><font >&nbsp;<%=rs.getString("comunicacao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        	<tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.2	Gest�o de mudan�a de Escopo</strong><br><br><font >&nbsp;<%=rs.getString("gestao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.3	Status Report / Relat�rios de desempenho</strong><br><br><font >&nbsp;<%=rs.getString("status")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.4	Ger�ncia de reuni�es</strong><br><br><font >&nbsp;<%=rs.getString("gerenciareunioes")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.5	Ger�ncia de quest�es e problemas</strong><br><br><font >&nbsp;<%=rs.getString("gerenciaquestoes")%></font></td>						          				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.6	Plano de Escalonamento</strong><br><br><font >&nbsp;<%=rs.getString("planoescalonamento")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>5	Eventos da comunica��o</strong><br><br><font >&nbsp;<%=rs.getString("eventocomunicacao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>6	Anexos</strong><br><br><font >&nbsp;<%=rs.getString("anexo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>Aprova��o</strong><br><br><font >&nbsp;<%=rs.getString("aprovacao")%></font></td>						          				
					         </tr>					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relat�rio Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relat�rio Gerado..:</strong> <%=mostra_hora %></td>
					        </tr>
					       					      					         
				         </table>
				         </div>
				         <br>

					<%
					 		}
						rs.close();
						st.close();
						con.close();
						}
						 
							catch(SQLException erroSQL)
							{
								out.println("Classe de conex�o com o Banco de Dados, erro"+erroSQL);
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
					
				<br>		
		</div>
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao'" title="Voltar p�gina"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	
</body>
</html>