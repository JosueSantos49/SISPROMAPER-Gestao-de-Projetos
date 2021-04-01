<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@page import="javax.naming.InitialContext,javax.sql.DataSource"%>
<%@page import="java.io.PrintWriter" import="java.util.*, javax.rmi.*, javax.naming.*, java.io.*, java.lang.*" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />
<jsp:include page="conexao.jsp" />
<jsp:include page="httpservletrequest.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Transação</title>	

<!-- Bootstrap -->  
<link href="bootstrap/css/bootstrapPagination.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script><!-- Modal Relatório -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script><!-- Modal Relatório -->

<script type="text/javascript" src="js/confirmaExclusaoAtualizacao.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorioUsuario.js"></script>
<script src="excellentexport-master/excellentexport.js"></script>
<script language="javascript" src="js/funcoes.js"></script>	

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->



<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

</head>	

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %><br>

<!-- Conexão -->
<%!
	Connection con = null;
	Statement st =  null;
	ResultSet rs1 = null;
	String acesso;//sessao
	String ordenacao;
%>

<% Connection con = ConexaoHelper.conectar(); %>

<% acesso = (String) session.getAttribute("login");%>

<div class="container">

<div id="main">
	<div class="wow slideInLeft" data-wow-duration="2s">
 		<div class="alert alert-danger">
		Olá, 
			<%=session.getAttribute("theName")%>
				<%  
				//verifica se a sessao do usuario é válida  
				if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
			%>
			esta etapa permite listar e executar todas transações que o sistema possui. Basta localizar e clicar no link transação processo informando o código da transação, que será buscado.  
		</div>
	</div>
</div>

<div align="center">
		
		 <%
			int limite = 80;// quantidade de resultados por página
			String numPagina = request.getParameter("numpagina");
			
			if(numPagina == null)
				numPagina = "1";
			
			int offset = (Integer.parseInt(numPagina) * limite) - limite;
			//out.println("Limite = "+limite);
			//out.println("numPagina = "+numPagina);
			//out.println("Offset = "+offset+"<br><br>");			
			
			String sql1 = "select * from transacao LIMIT 80 OFFSET 0"+offset;
			PreparedStatement ps = con.prepareStatement(sql1);
			System.out.println("Consultar transação: " + sql1);
			rs1 = ps.executeQuery();
			
			try{
				
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
									
			out.println("<div class='table-responsive'>");
				out.println("<table border='0' width='55%' align='center'>");
					out.println("<tr>");
						out.println("<td>");			
							out.println("<table id='tabela' border='1' cellspacing='5' cellspacing='5'> ");			   
							out.println("<thead>");
								out.println("<tr>");				
									out.println("<th><strong>CÓDIGO</strong></th>");
									out.println("<th><strong>TRANSAÇÃO</strong></th>");
									out.println("<th><strong>DESCRIÇÃO</strong></th>");
									out.println("<th><strong>PESQUISAR TRANSAÇÃO</strong></th>");
								out.println("</tr>");				    		    
							out.println("</thead>");						
							out.println("<tbody>");							
							
								while(rs1.next()){	
									out.println("<tr>");		
											String codigo = rs1.getString("codigotransacao");
											String transacao = rs1.getString("transacao");
											String descricao = rs1.getString("men_descricao");
																		
											out.println("<td>"+codigo+"</td>");
											out.println("<td>"+transacao+"</td>");
											out.println("<td>"+descricao+"</td>");
											out.println("<td><a href='transacao.jsp' target='_parent'>Transação Processo</a></td>");
											
							out.println("</tr>");				
											}
											
										    String sqlConta = "select count(*) AS contaRegistros from transacao";
											PreparedStatement psConta = con.prepareStatement(sqlConta);
											//System.out.println(sqlConta);
											ResultSet rsConta = psConta.executeQuery();
											rsConta.next();
											
											int totalRegistros = Integer.parseInt(rsConta.getString("contaRegistros"));
											int totalPaginas = totalRegistros / limite;
											
											if(totalRegistros % limite != 0)
												totalPaginas++; 
											//out.println("Quantidade de registros: "+totalRegistros);
											//out.println("Total de páginas a serem mostradas: "+totalPaginas);
								out.println("<br>");
			
											int pagAnterior;
											if(Integer.parseInt(numPagina) > 1){
												pagAnterior = Integer.parseInt(numPagina) -1;
												out.println("<ul class='pagination'>");
												out.println("<li><a href=consulta_transacao.jsp?numpagina="+pagAnterior+"> << Anterior </a></li>");
												out.println("</ul>");
											}			
											for(int i=1;i<=totalPaginas;i++){
												if(i == Integer.parseInt(numPagina))
													out.println();// aqui pode ser colocado o i, esta vazio porque fica mostrando na página
												else
													out.println("<a href=consulta_transacao.jsp?numpagina="+i+"></a>");
													out.println("<ul class='pagination'>");
													out.println("<li><a href=consulta_transacao.jsp?numpagina="+i+">"+ i +"</a></li>");
													out.println("</ul>");
											}											
											int proximaPag;
											if(totalRegistros - (Integer.parseInt(numPagina) * limite) > 0){
												proximaPag = Integer.parseInt(numPagina) + 1;
												out.println("<ul class='pagination'>");
												out.println("<li><a href=consulta_transacao.jsp?numpagina="+proximaPag+"> Próxima >> </a></li>");
												out.println("</ul>");
											}				
								out.println("</tbody>");			
			
								st.close();
								rsConta.close();
								con.close();
			
											}
											catch(SQLException erroSQL)
											{
												out.println("Classe de conexão com o Banco de Dados, erro"+erroSQL);
												
												/*Alert com confirmação de cadastro*/
												PrintWriter oPrintWriter = response.getWriter();  
												response.setContentType("text/html");  
												out.println("<script type=\"text/javascript\">");  
												out.println("alert('Classe de conexão com o Banco de Dados!');");  
												out.println("</script>");
												
											}finally{
												if (rs1 != null && !rs1.isClosed() ) {
											          try { rs1.close(); } catch (SQLException e) { ; }
											          rs1 = null;
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
							out.println("</table>");			
						out.println("</tr>");
					out.println("</td>");
				out.println("</table>");
			out.println("</div'>");				
			
			ps.close();	
			rs1.close();					
			con.close();
	        %>
	      </div>
	</div>	
<%@include file="configuracao_wow.jsp" %>
<%@include file="rodape.jsp" %>
</body>	
</html>