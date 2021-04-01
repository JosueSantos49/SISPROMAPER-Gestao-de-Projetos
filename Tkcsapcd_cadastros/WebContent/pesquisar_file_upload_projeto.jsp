<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page language="java" import = "java.util.*" import = "java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- Acessando a biblioteca java -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formata��o	 -->
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBeanProjeto"%>

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

<title>Relat�rio Pedido de Cota��o</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/validaPesquisarRelatorioProjeto.js"></script>

</head>

<body>

<%@include file="menuperantecssadm.jsp"%>

		<br><br>		

		<div align="center">
			  <%!Connection con = null;
			    Statement st = null;  // Ou PreparedStatement
			    ResultSet rs = null;
			   %>
			   <%
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
						sql = "select * from fileprojeto where codigoprojeto like '"+request.getParameter("consProjeto")+"%'";
						rs = st.executeQuery(sql);//executeQuery � usado para retorna uma consulta
						
						//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
						//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
						//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 
						
						rs = st.executeQuery(sql);//executeQuery � usado para retorna uma consulta						
												
						while(rs.next())
						{	
					%>
				    	<!--Vai preencher a tabela com os registros nesta linha-->
						<div class="table-responsive">
						<div class="container">	  								
							<table class="table" style="border: 0px solid;"	align="center"	border="0" bordercolor="gray" cellpadding="2" width="700px">								
					        <tr>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>C�digo Projeto..:</strong> <%=rs.getString("codigoprojeto")%></td>
					        	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Data registro..:</strong> <%=rs.getString("dataregistro")%></td>
					         </tr>
					        <tr>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Descri��o..:</strong> <%=rs.getString("description")%></td>
					          	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>E-mail..:</strong> <%=rs.getString("email")%></td>	
					         </tr>
					        <tr>									           
			                	<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Descarregar arquivo..:</strong> <a class='btn btn-info btn-xs' href="downloadProjeto.do?id=<%=rs.getInt("id")%>"><span class="glyphicon glyphicon-edit"></span> Baixar</a></td>
								<td align="left" bgcolor="#FFFFFF">&nbsp;<strong>Nome..:</strong> <%=rs.getString("name")%></td>	
							</tr>
					         <tr>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>
					        	<td bgcolor="#FFFFFF">&nbsp;</td>					        	
					        </tr>					       					      					         
				         </table>
				         </div>				         
				     </div>

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
		</div>	
	
		<div align="center">
		  <table width="400" border="0">
		    <tr>
		      <td><div align="center"> <span class="style1 style2 style5">
		        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
		        <input type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarFilebeanProjeto'" title="Voltar p�gina"></input>

		      </span></div></td>
		    </tr>
		  </table>
		</div>
	<%@include file="gif_load_page.jsp" %> 
</body>
</html>