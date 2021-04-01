<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
 <%@ page import="br.com.tkcsapcd.model.helper.ConexaoHelper" %>
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

<title>Pesquisar RFP-Projeto</title>

</head>

<body>

		<br>		
			  <%
			  Connection con = null;
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
						sql = "select * from rfpprojeto where codigoProjeto like '"+request.getParameter("consRfpprojeto")+"'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta						
						
						while(rs.next())
						{	
					%>
				    	<br>
						<div align="center" >    								
							<table style="border: 1px solid;" width="900px"	align="center"	border="0" bordercolor="gray" cellpadding="3">
							<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
							<tr>
					        	<td align="center" colspan="0" bordercolor="gray"><center><strong><font color="#0404B4"><h2>RELATÓRIO REQUERIMENTO DE PROPOSTA</h2></font></strong><hr></center></td>					        				        	
					        	<!-- <td bgcolor="#FFFFFF">&nbsp;<img align="left" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/logorelatorio.gif"> </td> -->
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
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Código do Projeto..:</strong> <%=rs.getString("codigoProjeto")%></td>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Item do Projeto..:</strong> <%=rs.getString("itensProjeto")%></td>		        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Nome RFP-Projeto..:</strong> <%=rs.getString("nomeRFpProjeto")%></td>
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Nome Empresa..:</strong> <%=rs.getString("nomeempresa")%></td>					          			        				
					         </tr>
					          <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>					  							  
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Telefone..:</strong> <%=rs.getString("telefone")%></td>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>E-mail..:</strong> <%=rs.getString("emailrepresentante")%></td>		        				
					         </tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>					        	
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Endereço..:</strong> <%=rs.getString("endereco")%></td>
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Cep..:</strong> <%=rs.getString("cep")%></td>
							  				
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>	
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Estado..:</strong> <%=rs.getString("estado")%></td>
							  	<td bgcolor="#FFFFFF">&nbsp;<strong>Cidade..:</strong> <%=rs.getString("cidade")%></td>				        	
					          	<td bgcolor="#FFFFFF">&nbsp;<strong>Numero..:</strong> <%=rs.getString("numero")%></td>
							  				
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>	
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Data..:</strong> <%=rs.getString("data")%></td>
					        	<td bgcolor="#FFFFFF">&nbsp;<strong>Representante Empresa..:</strong> <%=rs.getString("representante")%></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>
					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Histórico..:</strong><br><br><font >&nbsp;<%=rs.getString("historicoempresa")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Produto..:</strong><br><br><font >&nbsp;<%=rs.getString("produtoempresa")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Mercado..:</strong><br><br><font >&nbsp;<%=rs.getString("mercadoempresa")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Valor..:</strong><br><br><font >&nbsp;<%=rs.getString("valoresempresa")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Aquisição..:</strong><br><br><font >&nbsp;<%=rs.getString("aquisicao")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Escopo..:</strong><br><br><font >&nbsp;<%=rs.getString("escopo")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Restrições..:</strong><br><br><font >&nbsp;<%=rs.getString("restricao")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Recurso..:</strong><br><br><font >&nbsp;<%=rs.getString("recurso")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Avaliação..:</strong><br><br><font >&nbsp;<%=rs.getString("avaliacao")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Cronograma..:</strong><br><br><font >&nbsp;<%=rs.getString("cronograma")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					      	<tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Proposta..:</strong><br><br><font >&nbsp;<%=rs.getString("proposta")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td align="center" colspan="8" bordercolor="gray"><center><strong>...</strong><hr></center></td>					        				        	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Condição Proposta..:</strong><br><br><font >&nbsp;<%=rs.getString("condicaoproposta")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>
					        <tr>
					          	<td align="justify" bgcolor="#E6E6E6" colspan="2"><strong>Observação..:</strong><br><br><font >&nbsp;<%=rs.getString("observacao")%></font></td>						          				
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        	<td align="left" bgcolor="#E6E6E6" colspan="2"><strong></strong><br><br><font >&nbsp;</font></td>
					        </tr>
					        <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>	
					        </tr>					        
					         <tr>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Data de Relatório Gerado..:</strong> <%=mostra_data %></td>
					        	<td align="right" bgcolor="#FFFFFF">&nbsp;<strong>Hora de Relatório Gerado..:</strong> <%=mostra_hora %></td>
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
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarRfpProjeto'" title="Voltar página"></input>
		      </span></div></td>
		    </tr>
		  </table>
		</div>
</body>
</html>