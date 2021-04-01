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

	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>

<meta http-equiv="Content-Type" contentType="text/html; charset=ISO-8859-1" />
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Imprimir Relatório Específico</title>

<%@include file="configuracao_relatorio_link_css_js.jsp" %>

</head>

<body>

	<table border="0" width="900" align="center" >
		<tr>			
			<td width="350" height="70" align="center">
				<!-- <img align="right" height="40" width="60" alt="" src="/Tkcsapcd_cadastros/img/"></img> -->
				<font color="#0404B4"><h3>Relatório Específico do Projeto</h3></font>	
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

<div class="table-responsive">
   <table class="table" id="tableID"> 
    <tr class="info">
    	<td ><div align="" ><strong>Descrição Projeto</strong></div></td>
      	<td ><div align="" ><strong>Data Registro Projeto</strong></div></td>
      	<td ><div align="" ><strong>Termo Abertura Projeto</strong></div></td>
      	<td ><div align="" ><strong>Aprovação Termo Abertura Projeto</strong></div></td>
      	<td ><div align="" ><strong>Parte Interessada</strong></div></td>
      	<td ><div align="" ><strong>Data Registro Parte Interessada</strong></div></td>
      	<td ><div align="" ><strong>Plano Requisito</strong></div></td> 
      	<td ><div align="" ><strong>Autor Plano Requisito</strong></div></td>   
      	<td ><div align="" ><strong>Plano G. Projeto</strong></div></td> 
      	<td ><div align="" ><strong>Data Plano G. Projeto</strong></div></td>    
      	<td ><div align="" ><strong>EAP Descrição</strong></div></td> 
      	<td ><div align="" ><strong>Data EAP</strong></div></td> 
    </tr>
    
    <%!   
    Connection con = null;
    Statement st = null;  // Ou PreparedStatement
    ResultSet rs = null;
    %>
    <%
	try
	{
		con = ConexaoHelper.conectar();
		
				//Processo Paginação
				int limite = 30;// quantidade de resultados por página
				String numPagina = request.getParameter("numpagina");
				
				if(numPagina == null)
					numPagina = "1";
				
				int offset = (Integer.parseInt(numPagina) * limite) - limite;
				//out.println("Limite = "+limite);
				//out.println("numPagina = "+numPagina);
				//out.println("Offset = "+offset+"<br><br>");			
				String sql1 = "select * from projetoinicio LIMIT 30 OFFSET 0"+offset;
				PreparedStatement ps = con.prepareStatement(sql1);
				System.out.println(sql1);
				ResultSet rs1 = ps.executeQuery();
				//Processo Paginação
				
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//Implementando função ordenação de orden Crescente e Alfabetica
		ResultSet rs = null;

		/*query complexa executando junção de várias colunas da seguintes tabelas: 
		use tkcsapcd;
		SELECT 	cdprojeto.projeto AS projeto,
			    cdprojeto.data AS data, 
				cdtermo.termoaberturaprojeto AS termoaberturaprojeto,
				cdtermo.aprovacao AS aprovacao,
				cdinteressada.registroparteinteressada AS registroparteinteressada,
				cdinteressada.data AS data,
				cdrequisito.planogerenciamentorequisito AS planogerenciamentorequisito,
				cdrequisito.autor AS autor,
				cdgerenciamentoprojeto.planogerenciamentoprojeto AS planogerenciamentoprojeto,
				cdgerenciamentoprojeto.data AS data,
				cdorgchart.descricao AS descricao,
				cdorgchart.data AS data 
		FROM   projetoinicio AS cdprojeto
		INNER JOIN termoabertura AS cdtermo
		ON cdprojeto.codigoprojeto = cdtermo.codigoprojeto
		INNER JOIN registroparteinteressada AS cdinteressada
		ON cdprojeto.codigoprojeto = cdinteressada.codigoprojeto
		INNER JOIN planogerenciamentorequisito AS cdrequisito
		ON cdprojeto.codigoprojeto = cdrequisito.codigoprojeto
		INNER JOIN planogerenciamentoprojeto AS cdgerenciamentoprojeto
		ON cdprojeto.codigoprojeto = cdgerenciamentoprojeto.codigoprojeto 
		INNER JOIN orgchart AS cdorgchart
		ON cdprojeto.codigoprojeto = cdorgchart.codigoprojeto;	
				
		*/
		String sql;
		//sql = "	SELECT 	cdprojeto.projeto AS projeto,cdprojeto.data AS data,cdtermo.termoaberturaprojeto AS termoaberturaprojeto,cdtermo.aprovacao AS aprovacao, cdinteressada.registroparteinteressada AS registroparteinteressada, cdinteressada.data AS data,cdrequisito.planogerenciamentorequisito AS planogerenciamentorequisito, cdrequisito.autor AS autor,cdgerenciamentoprojeto.planogerenciamentoprojeto AS planogerenciamentoprojeto, cdgerenciamentoprojeto.data AS data,cdorgchart.descricao AS descricao, cdorgchart.data AS data FROM   projetoinicio AS cdprojeto INNER JOIN termoabertura AS cdtermo ON cdprojeto.codigoprojeto = cdtermo.codigoprojeto INNER JOIN registroparteinteressada AS cdinteressada ON cdprojeto.codigoprojeto = cdinteressada.codigoprojeto INNER JOIN planogerenciamentorequisito AS cdrequisito ON cdprojeto.codigoprojeto = cdrequisito.codigoprojeto INNER JOIN planogerenciamentoprojeto AS cdgerenciamentoprojeto ON cdprojeto.codigoprojeto = cdgerenciamentoprojeto.codigoprojeto INNER JOIN orgchart AS cdorgchart ON cdprojeto.codigoprojeto = cdorgchart.codigoprojeto;";
		
		sql = "SELECT 	cdprojeto.projeto AS projeto, cdprojeto.data AS data, cdtermo.termoaberturaprojeto AS termoaberturaprojeto, cdtermo.aprovacao AS aprovacao, cdinteressada.registroparteinteressada AS registroparteinteressada, cdinteressada.data AS data, cdrequisito.planogerenciamentorequisito AS planogerenciamentorequisito, cdrequisito.autor AS autor, cdgerenciamentoprojeto.planogerenciamentoprojeto AS planogerenciamentoprojeto, cdgerenciamentoprojeto.data AS data, cdorgchart.descricao AS descricao, cdorgchart.data AS data FROM   projetoinicio AS cdprojeto INNER JOIN termoabertura AS cdtermo ON cdprojeto.codigo = cdtermo.codigo INNER JOIN registroparteinteressada AS cdinteressada ON cdprojeto.codigo = cdinteressada.codigo INNER JOIN planogerenciamentorequisito AS cdrequisito ON cdprojeto.codigo = cdrequisito.codigo INNER JOIN planogerenciamentoprojeto AS cdgerenciamentoprojeto ON cdprojeto.codigo = cdgerenciamentoprojeto.codigo INNER JOIN orgchart AS cdorgchart ON cdprojeto.codigo = cdorgchart.codigo;";
		
		rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta

		//sql = "select * from projeto where dataprojeto like '"+request.getParameter("consProjeto1")+"%'";
		//sql = "select * from cliente where nome like '"+request.getParameter("consCliente")+"'"; //Exemplo 1, pesquisa pelo nome todo.
		//sql = "select * from cliente where autorprojeto like '"+request.getParameter("consCliente")+"%'";//Exemplo 2, tudo que inicia com a primeira letra. 

		rs = st.executeQuery(sql);//executeQuery é usado para retorna uma consulta	
		
		while(rs.next())
		{	
	%>
	<tr class="default">
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
        <tr class="success">
         	<td><div align="left"><%=rs.getString("projeto")%></div></td>
          	<td><div align="left"><%=rs.getString("data")%></div></td>          
          	<td><div align="left"><%=rs.getString("termoaberturaprojeto")%></div></td>
          	<td><div align="left"><%=rs.getString("aprovacao")%></div></td>
          	<td><div align="left"><%=rs.getString("registroparteinteressada")%></div></td>
          	<td><div align="left"><%=rs.getString("data")%></div></td>            	
          	<td><div align="left"><%=rs.getString("planogerenciamentorequisito")%></div></td>
          	<td><div align="left"><%=rs.getString("autor")%></div></td>
          	<td><div align="left"><%=rs.getString("planogerenciamentoprojeto")%></div></td>
          	<td><div align="left"><%=rs.getString("data")%></div></td>
          	<td><div align="left"><%=rs.getString("descricao")%></div></td>
          	<td><div align="left"><%=rs.getString("data")%></div></td>
        </tr>
	<%
	//Processo Paginação
    String sqlConta = "select count(*) AS contaRegistros from projetoinicio";
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
		out.println("<li><a href=imprimir_relatorio_colunas.jsp?numpagina="+pagAnterior+"> << Anterior </a></li>");
		out.println("</ul>");
	}			
	for(int i=1;i<=totalPaginas;i++){
		if(i == Integer.parseInt(numPagina))
			out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
		else
			out.println("<a href=imprimir_relatorio_colunas.jsp?numpagina="+i+"></a>");
			out.println("<ul class='pagination'>");
			out.println("<li><a href=imprimir_relatorio_colunas.jsp?numpagina="+i+">"+ i +"</a></li>");
			out.println("</ul>");
	}											
	int proximaPag;
	if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
		proximaPag = Integer.parseInt(numPagina) + 1;
		out.println("<ul class='pagination'>");
		out.println("<li><a href=imprimir_relatorio_colunas.jsp?numpagina="+proximaPag+"> Próxima >> </a></li>");
		out.println("</ul>");
	}
	//Fim Processo Paginação
	
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
  <br>
	 <div align="center">
     	<input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="window.print();"/>
        <input type="button" name="imprimir" id="imprimir" value="Impressão em tela" onclick="window.open('imprimir_relatorio_colunas.jsp')"/>
       	<input type="button" name="imprimir" id="imprimir" value="Relatório pop up" onclick="window.open('imprimir_relatorio_colunas.jsp','relatorio','toolbar=0,scrollbars=1,location=0,directories=0,copyhistory=0,status=0,menubar=0,resizable=0,width=800,height=600,z-lock,screenX=90,screenY=100,Left=100,Top=20')"/>
 	</div>
</body>
</html>
