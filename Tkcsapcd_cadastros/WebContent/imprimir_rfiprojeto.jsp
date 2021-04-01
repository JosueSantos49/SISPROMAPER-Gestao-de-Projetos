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

<meta http-equiv="Content-Type" contentType="text/html; charset=ISO-8859-1" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="/Tkcsapcd_avaliacao/img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Relatório RFI-Projeto</title>

<style type="text/css">
.style1 {	font-size: 24px;	font-weight: bold;}
.style2 {	font-size: 36px;	color: #FFCC00;	font-style: italic;}
.style5 {color: #333333}
.style6 {color: #333333; font-weight: bold; }
</style>

<style type="text/css">
.style3 {	font-size: 24px;	font-weight: bold;}
.style4 {	font-size: 36px;	color: #E0FFFF;	font-style: italic;}
.style7 {color: #E0FFFF}
.style8 {color: #E0FFFF; font-weight: bold; }
</style>

<script src="excellentexport-master/excellentexport.js"></script><!-- Função p/ exportar para Excell -->
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> 
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>

</head>

<body>

<div id="preloader"><h1><img src="img/loader.gif" height="70px"></h1></div>

<table border="0" width="1070px" align="center" >
		<tr>			
			<td width="350" height="45px" colspan="2" align="center">
				<!-- <img align="right" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"></img>-->
				<h3><font color="#0404B4">RELATÓRIO GERAL PEDIDO DE INFORMAÇÃO (RFP)</font></h3>	
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
	</table><br>

<div align="center">
  <table style="border: 1px solid; text-align: left;" width="1070px" border="0">
    <tr bgcolor="#F3F781"><!-- cor original (cinza) #CCCCCC" -->     
      <td><div align="center" class="style6"><a href="imprimir_rfiprojeto.jsp?ordenacao=crescente">NOME EMPRESA</a></div></td>
      <td><div align="center" class="style5"><strong><a href="imprimir_rfiprojeto.jsp?ordenacao=alfabetica">ANO MERCADO</a></strong></div></td>
      <td><div align="center" class="style5"><strong>TELEFONE</strong></div></td>
      <td><div align="center" class="style5"><strong>E-MAIL</strong></div></td>
      <td><div align="center" class="style5"><strong>PESSOA CONTATO</strong></div></td>
      <td><div align="center" class="style5"><strong>DATA RFI</strong></div></td> 
      <td><div align="center" class="style5"><strong>PÁGINA WEB</strong></div></td> 
    </tr>
        <tr bgcolor="#CCCCCC">    
      <td><div align="center" class="style6"></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td> 
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
			st.executeUpdate("delete from rfiprojeto where codigo = "+request.getParameter("codigo"));
		}
		
		//Implementando função ordenação de orden Crescente e Alfabetica
		//ResultSet rs = null;
		
		if(request.getParameter("ordenacao") == null)
			{
			rs = st.executeQuery("select * from rfiprojeto order by nome");
			}
		else if(request.getParameter("ordenacao").equals("crescente"))
			{
				rs = st.executeQuery("select * from rfiprojeto");
			}		
		else if(request.getParameter("ordenacao").equals("alfabetica"))
			{
				rs = st.executeQuery("select * from rfiprojeto order by nome");
			}
		
		//executeQuery é usado para retorna uma consulta
		//ResultSet rs = st.executeQuery("select * from login");
		
		while(rs.next())
		{	
	%>
    	<!--Vai preencher a tabela com os registros nesta linha-->
        <tr bgcolor="#FFFAFA">                  
          <td ><div ><%=rs.getString("nome")%></div></td>
          <td ><div ><%=rs.getString("anosmercado")%></div></td>
          <td><div ><%=rs.getString("telefone")%></div></td>
          <td><div ><%=rs.getString("email")%></div></td>
          <td><div ><%=rs.getString("pessoacontato")%></div></td>             
          <td ><div ><%=rs.getString("data")%></div></td>
          <td><div ><%=rs.getString("paginaweb")%></div></td>    
        </tr>
          <tr bgcolor="#7FFFD4"><!-- cor da linha (azul) -->
          <td><div align="center"><br></div></td><!-- pulando linha -->                   
          <td ><div align="center"></div></td>
          <td ><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>   
          <td ><div align="center"></div></td> 
          <td ><div align="center"></div></td>
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
<div align="center">
  <table width="400" border="0">
    <tr>
      <td><div align="center"> <span class="style1 style2 style5">
        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
        <input type="button" name="imprimir" id="imprimir" value="Impressão em tela" onclick="window.open('imprimir_avaliacao.jsp')"/>
        <input type="button" name="imprimir" id="imprimir" value="Relatório pop up" onclick="window.open('imprimir_avaliacao.jsp','relatorio','toolbar=0,scrollbars=1,location=0,directories=0,copyhistory=0,status=0,menubar=0,resizable=0,width=800,height=600,z-lock,screenX=90,screenY=100,Left=100,Top=20')"/>
	  </span></div></td>
    </tr>
  </table>
</div>
</body>
</html>
