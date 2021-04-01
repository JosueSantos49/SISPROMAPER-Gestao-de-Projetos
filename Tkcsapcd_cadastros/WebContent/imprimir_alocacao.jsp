<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Relatório Alocação</title>

<%@include file="configuracao_relatorio_link_css_js.jsp" %>

</head>

<body>

	<table border="0" width="800px" align="center" >
		<tr>			
			<td width="350" height="45px" colspan="2" align="center">
				<!-- <img align="right" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"></img>-->
				<h3><font color="#0404B4">RELATÓRIO GERAL DE ALOCAÇÃO</font></h3>	
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
	</table>
<div class="container">
<div class="table-responsive">
   <table class="table" id="tableID"> 
    <tr class="info">
      <td><div align="center" class="style6"><a href="imprimir_alocacao.jsp?ordenacao=crescente">CÓDIGO</a></div></td>      
      <td><div align="center" class="style6"><a href="imprimir_alocacao.jsp?ordenacao=alfabetica">RH</a></div></td>
      <td><div align="center" class="style5"><strong>PROFISSÃO</strong></div></td>
      <td><div align="center" class="style5"><strong>P. INICIAL</strong></div></td>
      <td><div align="center" class="style5"><strong>P. FINAL</strong></div></td>
      <td><div align="center" class="style5"><strong>APR</strong></div></td>
      <td><div align="center" class="style5"><strong>MAY</strong></div></td>
      <td><div align="center" class="style5"><strong>JUN</strong></div></td>  
      <td><div align="center" class="style5"><strong>JUL</strong></div></td>
      <td><div align="center" class="style5"><strong>AUG</strong></div></td>
      <td><div align="center" class="style5"><strong>SEP</strong></div></td>
      <td><div align="center" class="style5"><strong>OCT</strong></div></td>
      <td><div align="center" class="style5"><strong>NOV</strong></div></td>
      <td><div align="center" class="style5"><strong>DEC</strong></div></td>
      <td><div align="center" class="style5"><strong>JAN</strong></div></td>
      <td><div align="center" class="style5"><strong>FEB</strong></div></td>
      <td><div align="center" class="style5"><strong>MAR</strong></div></td>
      <td><div align="center" class="style5"><strong>APR</strong></div></td>
      <td><div align="center" class="style5"><strong>MAY</strong></div></td>
      <td><div align="center" class="style5"><strong>JUN</strong></div></td>
      <td><div align="center" class="style5"><strong>JUL</strong></div></td>       
    </tr>
      <tr bgcolor="#CCCCCC">     
      <td><div align="center" class="style6"></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td> 
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>  
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>  
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>
      <td><div align="center" class="style5"><strong></strong></div></td>       
    </tr>
    <%
    Connection conn = null;
    Statement st = null;  // Ou PreparedStatement
    ResultSet rs = null;
	try
	{		
		Connection con = ConexaoHelper.conectar();	
		
		//Processo Paginação
		int limite = 30;// quantidade de resultados por página
		String numPagina = request.getParameter("numpagina");
		
		if(numPagina == null)
			numPagina = "1";
		
		int offset = (Integer.parseInt(numPagina) * limite) - limite;
		//out.println("Limite = "+limite);
		//out.println("numPagina = "+numPagina);
		//out.println("Offset = "+offset+"<br><br>");			
		String sql1 = "select * from alocacao LIMIT 30 OFFSET 0"+offset;
		PreparedStatement ps = con.prepareStatement(sql1);
		System.out.println(sql1);
		ResultSet rs1 = ps.executeQuery();
		//Processo Paginação
		
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//Deletar registro
		//Perguntar se teve ação(usuario.jsp?acao=excluir&codigo=<rs.getString("log_codigo")) de exclusão.
		if(request.getParameter("acao") != null)
		{
			//executar uma atualização
			st.executeUpdate("delete from alocacao where codigo = "+request.getParameter("codigo"));
		}
		
		//Implementando função ordenação de orden Crescente e Alfabetica
		//ResultSet rs = null;
		
		if(request.getParameter("ordenacao") == null)
			{
			rs = st.executeQuery("select * from alocacao order by recursoshumanos_codigo");
			}
		else if(request.getParameter("ordenacao").equals("crescente"))
			{
				rs = st.executeQuery("select * from alocacao");
			}		
		else if(request.getParameter("ordenacao").equals("alfabetica"))
			{
				rs = st.executeQuery("select * from alocacao order by recursoshumanos_codigo");
			}		
		//executeQuery é usado para retorna uma consulta
		//ResultSet rs = st.executeQuery("select * from login");
		
		while(rs.next())
		{	
	%>
    	<!--Vai preencher a tabela com os registros nesta linha-->
        <tr class="success">
          <td><div align="center" class="style"><%=rs.getString("projeto_codigo")%></div></td>                   
          <td><div align="center"><%=rs.getString("recursoshumanos_codigo")%></div></td>
          <td><div align="center"><%=rs.getString("profissao_codigo")%></div></td>
          <td><div align="center"><%=rs.getString("data")%></div></td>
          <td><div align="center"><%=rs.getString("data0")%></div></td>
          <td><div align="center"><%=rs.getString("metrica1")%></div></td>
          <td><div align="center"><%=rs.getString("metrica2")%></div></td>
          <td><div align="center"><%=rs.getString("metrica3")%></div></td>
          <td><div align="center"><%=rs.getString("metrica4")%></div></td>
          <td><div align="center"><%=rs.getString("metrica5")%></div></td>          
          <td><div align="center"><%=rs.getString("metrica6")%></div></td>
          <td><div align="center"><%=rs.getString("metrica7")%></div></td>
          <td><div align="center"><%=rs.getString("metrica8")%></div></td>
          <td><div align="center"><%=rs.getString("metrica9")%></div></td> 
          <td><div align="center"><%=rs.getString("metrica10")%></div></td>
          <td><div align="center"><%=rs.getString("metrica11")%></div></td>
          <td><div align="center"><%=rs.getString("metrica12")%></div></td>          
          <td><div align="center"><%=rs.getString("metrica13")%></div></td>
          <td><div align="center"><%=rs.getString("metrica14")%></div></td>
          <td><div align="center"><%=rs.getString("metrica15")%></div></td>
          <td><div align="center"><%=rs.getString("metrica16")%></div></td>        
        </tr>
          <tr bgcolor="#7FFFD4"><!-- cor da linha (azul) -->
          <td><div align="center"><br></div></td><!-- pulando linha -->          
          <td ><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>          
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td> 
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>          
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>
          <td><div align="center"></div></td>       
          <td><div align="center"></div></td>  
        </tr>
	<%
			}
		
		//Processo Paginação
	    String sqlConta = "select count(*) AS contaRegistros from alocacao";
		PreparedStatement psConta = con.prepareStatement(sqlConta);
		System.out.println(sqlConta);
		ResultSet rsConta = psConta.executeQuery();
		rsConta.next();
		
		int totalRegistros = Integer.parseInt(rsConta.getString("contaRegistros"));
		int totalPaginas = totalRegistros / limite;
		
		if(totalRegistros % limite != 0)
			totalPaginas++; 
		//out.println("Quantidade de registros: "+totalRegistros);
		//out.println("Total de páginas a serem mostradas: "+totalPaginas);

		int pagAnterior;
		if(Integer.parseInt(numPagina) > 1){
			pagAnterior = Integer.parseInt(numPagina) -1;
			out.println("<ul class='pagination'>");
			out.println("<li><a href=imprimir_alocacao.jsp?numpagina="+pagAnterior+"> << Anterior </a></li>");
			out.println("</ul>");
		}			
		for(int i=1;i<=totalPaginas;i++){
			if(i == Integer.parseInt(numPagina))
				out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
			else
				out.println("<a href=imprimir_alocacao.jsp?numpagina="+i+"></a>");
				out.println("<ul class='pagination'>");
				out.println("<li><a href=imprimir_alocacao.jsp?numpagina="+i+">"+ i +"</a></li>");
				out.println("</ul>");
		}											
		int proximaPag;
		if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
			proximaPag = Integer.parseInt(numPagina) + 1;
			out.println("<ul class='pagination'>");
			out.println("<li><a href=imprimir_alocacao.jsp?numpagina="+proximaPag+"> Próxima >> </a></li>");
			out.println("</ul>");
		}
		//Fim Processo Paginação
		
		rs.close();
		st.close();
		con.close();
		}
			catch(SQLException erroSQL)
			{
				out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
		}
    	finally{
		 // fecha todos os recursos e devolve a conexao ao pool
       if (rs != null && !rs.isClosed() ) {
           try { rs.close(); } catch (SQLException e) { ; }
           rs = null;
       }
       if (st != null && !st.isClosed() ) {
           try { st.close(); } catch (SQLException e) { ; }
           st = null;
       }
       if (conn != null && !conn.isClosed() ) {
           try { conn.close(); } catch (SQLException e) { ; }
           conn = null;
       }
	}
	%>
  </table>
</div>
</div>
<div align="center">
  <table width="400" border="0">
    <tr>
      <td><div align="center"> <span class="style1 style2 style5">
        <input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
        <input type="button" name="imprimir" id="imprimir" value="Impressão em tela" onclick="window.open('imprimir_alocacao.jsp')"/>
        <input type="button" name="imprimir" id="imprimir" value="Relatório pop up" onclick="window.open('imprimir_alocacao.jsp','relatorio','toolbar=0,scrollbars=1,location=0,directories=0,copyhistory=0,status=0,menubar=0,resizable=0,width=800,height=600,z-lock,screenX=90,screenY=100,Left=100,Top=20')"/>
     </span></div></td>
    </tr>
  </table>
</div>
</body>
</html>
