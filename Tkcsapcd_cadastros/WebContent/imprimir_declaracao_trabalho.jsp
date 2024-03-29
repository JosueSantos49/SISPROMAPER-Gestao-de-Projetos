<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 --> 
 <%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="sessao.jsp" />
<% 

	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>

<meta http-equiv="Content-Type" contentType="text/html; charset=ISO-8859-1" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da p�gina -->

<title>Imprimir Declara��o de Trabalho</title>

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css"></link>

<style type="text/css">
	.style1 {font-size: 24px;font-weight: bold;}
	.style2 {font-size: 36px;color: #FFCC00;font-style: italic;}
	.style5 {color: #333333}
	.style6 {color: #333333; font-weight: bold; }
</style>

</head>

<body>

	<table border="0" width="900" align="center" >
		<tr>			
			<td width="350" height="70" align="center">
				<!-- <img align="right" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"></img> -->
				<font color="#0404B4"><h3>RELAT�RIO GERAL DECLARA��O DE TRABALHO</h3></font>	
								<div align="right">
						        	<font color="#1C1C1C"> Usu�rio: 						
											<%=session.getAttribute("theName")%>
											<%  //verifica se a sessao do usuario � v�lida  
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
	</table>

<div align="center">
  <table width="1100" border="0">
    <tr bgcolor="#CCCCCC">
    	<td width="90"><div align="" class="style6"><a href="imprimir_declaracao_trabalho.jsp?ordenacao=crescente">C�DIGO PROJETO</a></div></td>
      	<td width="90"><div align="" class="style6"><a href="imprimir_declaracao_trabalho.jsp?ordenacao=alfabetica">NOME DO PROJETO</a></div></td>
      	<td width="90"><div align="" class="style5"><strong>DECLARA��O TRABALHO</strong></div></td>  
      	<td width="90"><div align="" class="style5"><strong>VERS�O</strong></div></td>
      	<td width="90"><div align="" class="style5"><strong>DATA</strong></div></td> 
      	<td width="90"><div align="" class="style5"><strong>AUTOR</strong></div></td>
      	<td width="90"><div align="" class="style5"><strong>NOTA DE REVIS�O</strong></div></td>   
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
		//Perguntar se teve a��o(usuario.jsp?acao=excluir&codigo=<rs.getString("log_codigo")) de exclus�o.
		if(request.getParameter("acao") != null)
		{
			//executar uma atualiza��o
			st.executeUpdate("delete from declaracaotrabalho where codigo = "+request.getParameter("codigo"));
		}
		
		//Implementando fun��o ordena��o de orden Crescente e Alfabetica
		//ResultSet rs = null;
		
		if(request.getParameter("ordenacao") == null)
			{
				rs = st.executeQuery("select * from declaracaotrabalho order by codigoprojeto");
			}
		else if(request.getParameter("ordenacao").equals("crescente"))
			{
				rs = st.executeQuery("select * from declaracaotrabalho");
			}		
		else if(request.getParameter("ordenacao").equals("alfabetica"))
			{
				rs = st.executeQuery("select * from declaracaotrabalho order by notarevisao");
			}
		
		//executeQuery � usado para retorna uma consulta
		//ResultSet rs = st.executeQuery("select * from login");
		
		while(rs.next())
		{	
			
	%>
        <tr bgcolor="#FFFFFF">
         	<td><div align="left"><%=rs.getString("codigoprojeto")%></div></td>
          	<td><div align="left"><%=rs.getString("projeto")%></div></td>          
          	<td><div align="left"><%=rs.getString("declaracaotrabalho")%></div></td>
          	<td><div align="left"><%=rs.getString("versao")%></div></td>
          	<td><div align="left"><%=rs.getString("data")%></div></td>
          	<td><div align="left"><%=rs.getString("autor")%></div></td>
          	<td><div align="left"><%=rs.getString("notarevisao")%></div></td>
        </tr>
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
  </table> 
 </div>
  <br>
	 <div align="center">
     	<input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
        <input type="button" name="imprimir" id="imprimir" value="Impress�o em tela" onclick="window.open('imprimir_declaracao_trabalho.jsp')"/>
       	<input type="button" name="imprimir" id="imprimir" value="Relat�rio pop up" onclick="window.open('imprimir_declaracao_trabalho.jsp','relatorio','toolbar=0,scrollbars=1,location=0,directories=0,copyhistory=0,status=0,menubar=0,resizable=0,width=800,height=600,z-lock,screenX=90,screenY=100,Left=100,Top=20')"/>
 	</div>
</body>
</html>
