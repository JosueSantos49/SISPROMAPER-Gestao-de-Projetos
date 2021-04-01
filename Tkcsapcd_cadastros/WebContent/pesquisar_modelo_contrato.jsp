<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
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

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Relatório Adjudicação do contrato de aquisição</title>

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
						sql = "select * from modelocontrato where codigoprojeto like '"+request.getParameter("consProjeto")+"'";
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
				    	<!--Vai preencher a tabela com os registros nesta linha-->
							
						<div align="" >    								
							<table style="border: 1px solid;"	align="center"	border="0" bordercolor="gray" cellpadding="2" width="800px">
							
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><h2>RELATÓRIO ADJUDIAÇÃO DO CONTRATO DE AQUISIÇÃO</h2></strong><hr></center></td>					        				        	
					        	<!-- <td bgcolor="#FFFFFF">&nbsp;<img align="left" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"> </td> -->
					        				        	
					        </tr> 					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Data..:</strong> <%=rs.getString("data")%></td>
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Contrato..:</strong> <%=rs.getString("modelocontrato")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Nome do Projeto..:</strong> <%=rs.getString("projeto")%></td>
							  				
					         </tr>
					         
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					         <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Código do Projeto..:</strong> <%=rs.getString("codigoprojeto")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Versão..:</strong> <%=rs.getString("versao")%></td>
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
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" >&nbsp;<strong>Nota de Revisão..:</strong> <%=rs.getString("notarevisao")%></td>
					        	<td bgcolor="#FFFFFF" >&nbsp;</td>				        	
					        </tr>
					       <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>1 Objetivos deste documento </strong><br><br><font >&nbsp;<%=rs.getString("objetivo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2 Declaração do trabalho ou entregas</strong><br><br><font >&nbsp;<%=rs.getString("declaracao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2.1	Linha de base do cronograma</strong><br><br><font >&nbsp;<%=rs.getString("linha")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2.2	Relatórios de desempenho</strong><br><br><font >&nbsp;<%=rs.getString("relatorio")%></font></td>						          				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2.3	Período de desempenho</strong><br><br><font >&nbsp;<%=rs.getString("periodo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2.4	Papéis e responsabilidades</strong><br><br><font >&nbsp;<%=rs.getString("papeis")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>2.5	Local de desempenho do fornecedor</strong><br><br><font >&nbsp;<%=rs.getString("local")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        	<tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3 Definição de preços</strong><br><br><font >&nbsp;<%=rs.getString("definicao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.1	Suporte ao produto</strong><br><br><font >&nbsp;<%=rs.getString("suporte")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.2	Limitação de responsabilidade</strong><br><br><font >&nbsp;<%=rs.getString("limitacao")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.3	Remuneração e retenções</strong><br><br><font >&nbsp;<%=rs.getString("remuneracao")%></font></td>						          				
					         </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>3.4	Penalidades</strong><br><br><font >&nbsp;<%=rs.getString("penalidade")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4 Incentivos</strong><br><br><font >&nbsp;<%=rs.getString("incentivo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.1	Seguros e seguros-desempenhoo</strong><br><br><font >&nbsp;<%=rs.getString("seguro")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>4.2	Aprovações de subcontratadas subordinadas</strong><br><br><font >&nbsp;<%=rs.getString("aprovacaocontratacao")%></font></td>							          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>5 Tratamento de solicitações de mudança</strong><br><br><font >&nbsp;<%=rs.getString("tratamento")%></font></td>						          				
					         </tr>					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					          <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>5.1 Mecanismos de rescisão e de resolução alternativa de disputas</strong><br><br><font >&nbsp;<%=rs.getString("mecanismo")%></font></td>						          				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					         <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong>6 Aprovação</strong><br><br><font >&nbsp;<%=rs.getString("aprovacao")%></font></td>						          				
					         </tr>					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relatório Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relatório Gerado..:</strong> <%=mostra_hora %></td>
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
					
				<br>		
		</div>
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarModeloContrato'" title="Voltar página"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	
</body>
</html>