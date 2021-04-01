<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
 <%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="sessao.jsp" />
<% 

	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<title>Relatório RFP-Projeto</title>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<style type="text/css">
	.style1 {	font-size: 24px;	font-weight: bold;}
	.style2 {	font-size: 36px;	color: #FFCC00;	font-style: italic;}
	.style5 {color: #333333}
	.style6 {color: #333333; font-weight: bold; }
</style>

<script src="excellentexport-master/excellentexport.js"></script><!-- Função p/ exportar para Excell -->
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>

</head>

<body>

<table border="0" width="1100" align="center" >
		<tr>			
			<td width="350" height="70" align="center">
				<!-- <img align="right" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"></img>-->
				<font color="#0404B4"><h3>RELATÓRIO GERAL RFP-PROJETO</h3></font>	
								<div align="right">
						        	<font color="#1C1C1C"> Usuário: 						
											<%=session.getAttribute("theName")%>
											<%  //verifica se a sessao do usuario é válida  
												if(session.getAttribute("theName")==null)  
												{  request.getRequestDispatcher("testelogin.jsp").forward(request, response);    
													//response.sendRedirect("testelogin.jsp");  
												}  
											%>						
									</font>
								</div>			
			</td>
		</tr>
		<tr>
			<%@include  file="data_hora_formatada.jsp" %>	
			<td align="right" bgcolor="#FFFFFF">&nbsp;<font color="#D6D6D6" ><strong>Data de Acesso: </strong><%=mostra_data %> <%=mostra_hora %></font></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
<div align="center">
  <table width="1100" border="0">
    <tr bgcolor="#CCCCCC">
      <td><div align="center" class="style5"><strong><a href="imprimir_rfpprojeto.jsp?ordenacao=crescente">CÓDIGO PROJETO</a></strong></div></td>
      <td><div align="center" class="style5"><strong>CÓDIGO ITEM</strong></div></td>
      <td><div align="center" class="style5"><strong><a href="imprimir_rfpprojeto.jsp?ordenacao=alfabetica">NOME RFP</a></strong></div></td>
      <td><div align="center" class="style5"><strong>NOME EMPRESA</strong></div></td>
      <td><div align="center" class="style5"><strong>REPRESENTANTE</strong></div></td>
      <td><div align="center" class="style5"><strong>TELEFONE</strong></div></td>
      <td><div align="center" class="style5"><strong>E-MAIL</strong></div></td>
      <td><div align="center" class="style5"><strong>DATA</strong></div></td>
    </tr>
    <%
    Connection con = null;
    Statement st = null;  // Ou PreparedStatement
    ResultSet rs = null;
	try
	{
		con = ConexaoHelper.conectar();
		
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//Deletar registro
		//Perguntar se teve ação(usuario.jsp?acao=excluir&codigo=<rs.getString("log_codigo")) de exclusão.
		if(request.getParameter("acao") != null)
		{
			//executar uma atualização
			st.executeUpdate("delete from rfpprojeto where codigo = "+request.getParameter("codigo"));
		}
		
		//Implementando função ordenação de orden Crescente e Alfabetica
		//ResultSet rs = null;
		
		if(request.getParameter("ordenacao") == null)
			{
				rs = st.executeQuery("select * from rfpprojeto order by nomeRfpProjeto");
			}
		else if(request.getParameter("ordenacao").equals("crescente"))
			{
				rs = st.executeQuery("select * from rfpprojeto");
			}		
		else if(request.getParameter("ordenacao").equals("alfabetica"))
			{
				rs = st.executeQuery("select * from rfpprojeto order by nomeRfpProjeto");
			}
		
		//executeQuery é usado para retorna uma consulta
		//ResultSet rs = st.executeQuery("select * from login");
		
		while(rs.next())
		{	
	%>
    	<!--Vai preencher a tabela com os registros nesta linha-->
        <tr bgcolor="#FFFFFF">
	      <td><div align="left"><%=rs.getString("codigoProjeto")%></div></td>
          <td><div align="left"><%=rs.getString("itensProjeto")%></div></td>
          <td><div align="left"><%=rs.getString("nomeRfpProjeto")%></div></td>         
          <td><div align="left"><%=rs.getString("nomeempresa")%></div></td>
          <td><div align="left"><%=rs.getString("representante")%></div></td>
          <td><div align="left"><%=rs.getString("telefone")%></div></td>
          <td><div align="left"><%=rs.getString("emailrepresentante")%></div></td>
          <td><div align="left"><%=rs.getString("data")%></div></td>
        </tr>
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
  </table>
</div>
	<div align="center"><br></br>
        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
        <input  type="button" name="imprimir" id="imprimir" value="Impressão em tela" onclick="window.open('imprimir_rfpprojeto.jsp')"/>
        <input  type="button" name="imprimir" id="imprimir" value="Relatório pop up" onclick="window.open('imprimir_rfpprojeto.jsp','relatorio','toolbar=0,scrollbars=1,location=0,directories=0,copyhistory=0,status=0,menubar=0,resizable=0,width=800,height=600,z-lock,screenX=90,screenY=100,Left=100,Top=20')"/>
 	</div>
</body>
</html>
