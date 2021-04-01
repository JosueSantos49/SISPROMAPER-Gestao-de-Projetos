<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
 <%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.Date" import="java.util.*" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Cliente"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Pesquisar Alocação</title>

</head>

<body>
		<br>		
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
						sql = "select * from alocacao where recursoshumanos_codigo like '"+request.getParameter("consAlocacao")+"'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
						
						while(rs.next())
						{	
					%>
				    	<br>
						<div align="center" >    								
							<table style="border: 1px solid;" width="920px"	align="center"	border="0" bordercolor="gray" cellpadding="3">
							
							<tr>
					        	<td align="center" colspan="2" bordercolor="gray" height="55" width="1000"><center><strong><h3>RELATÓRIO ALOCAÇÃO</h3></strong><hr></center></td>					        				        	
					        	<!-- <td bgcolor="#FFFFFF">&nbsp;<img align="left" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/logorelatorio.gif"> </td> -->
					        				        	
					        </tr> 
					        
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Código..:</strong> <%=rs.getString("codigo")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					          	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Cód. Projeto..:</strong> <%=rs.getString("projeto_codigo")%></td>
					          	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Recursos Humanos..:</strong> <%=rs.getString("recursoshumanos_codigo")%></td>	
					          	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Profissão..:</strong> <%=rs.getString("profissao_codigo")%></td>       				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>					  							  
					          	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Períod Inicial..:</strong> <%=rs.getString("data")%></td>
					          	<td bgcolor="#FFFFFF" width="500">&nbsp;<strong>Período Final..:</strong> <%=rs.getString("data0")%></td>        				
					         </tr>					        
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>	
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>						       		        	
					        </tr>
					        <tr>
					          	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Apr</strong><br><br><font >&nbsp;<%=rs.getString("metrica1")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>May</strong><br><br><font >&nbsp;<%=rs.getString("metrica2")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Jun</strong><br><br><font >&nbsp;<%=rs.getString("metrica3")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Jul</strong><br><br><font >&nbsp;<%=rs.getString("metrica4")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Aug</strong><br><br><font >&nbsp;<%=rs.getString("metrica5")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Sep</strong><br><br><font >&nbsp;<%=rs.getString("metrica6")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Oct</strong><br><br><font >&nbsp;<%=rs.getString("metrica7")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Nov</strong><br><br><font >&nbsp;<%=rs.getString("metrica8")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Dec</strong><br><br><font >&nbsp;<%=rs.getString("metrica9")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Jan</strong><br><br><font >&nbsp;<%=rs.getString("metrica10")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Feb</strong><br><br><font >&nbsp;<%=rs.getString("metrica11")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Mar</strong><br><br><font >&nbsp;<%=rs.getString("metrica12")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Apr</strong><br><br><font >&nbsp;<%=rs.getString("metrica13")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>May</strong><br><br><font >&nbsp;<%=rs.getString("metrica14")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400"><strong>Jun</strong><br><br><font >&nbsp;<%=rs.getString("metrica15")%></font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2" width="400" ><strong>Jul</strong><br><br><font >&nbsp;<%=rs.getString("metrica16")%></font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora..:</strong> <%=mostra_hora %></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
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
			
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarAlocacao'" title="Voltar página"></input>
		      </span></div></td>
		    </tr>
		  </table>
		</div>
</body>
</html>