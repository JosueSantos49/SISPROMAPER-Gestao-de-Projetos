<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.FileBean"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.helper.ConexaoHelper"%>

<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<title>Transação Processo</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereQualidade.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
-->
</style>

<!-- Calendário -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<!-- Dialogo -->
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			height : 150,
			modal : true,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#data").mask("99/99/9999");  
	});
</script>

<script>
	$(function() {
		$("#").datepicker({//dataProjeto
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<script>
	function show_confirm() {

		var r = confirm("Click em OK, para continuar!");
		if (r == true) {
			alert("Continuando...");
			return true;
		} else {
			alert("Click em OK, para cancelar!");
			location.href = "TkcsapcdController?cmd=consultarTransacao";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("transacao").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">
			<%!
				Connection con = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;				
			%>
			<%
			try{
				
			
			String campo_coidgo_transacao = request.getParameter("codigotransacao");
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM transacao WHERE codigotransacao = '"+request.getParameter("codigotransacao")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			System.out.println(rs);
			
			while(rs.next()){
				
				Integer codigo_transacao = rs.getInt("codigotransacao");
				
				if(codigo_transacao >= 1){
					System.out.println();
					System.out.println("Busca de Transação - Código informado: " +codigo_transacao);
					%>
					
					<div class="container">
						<div id="main">
							<div class="wow slideInLeft" data-wow-duration="1s">
								 <div class="alert alert-danger">
									Olá, 
									<%=session.getAttribute("theName")%>
										<%  
										//verifica se a sessao do usuario é válida  
										if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
									%>
									segue abaixo o código, nome e link de acesso à transação.
								</div>
							</div>
						</div>		
					</div>
					
					<section class="main container">	
							<div class="miga-de-pan alert-success">				
			    			<!-- Lista ordenada -->
								<ol class="breadcrumb">
									<li><%= rs.getString("codigotransacao")%> - <%= rs.getString("transacao")%></li>
									<li><a href="<%= rs.getString("men_linkacessar")%>" target="_parent"><%= rs.getString("men_descricao")%></a></li>											
								</ol> 
							</div>	
					</section>
					<div align="center">					 
						<input type="button" value="Pesquisar outra Transação" onclick="window.parent.location='transacao.jsp';"/>					       
					</div>
					<%
				}else{
					
					System.out.println("Nenhuma transação encontrada!");
					PrintWriter oPrintWriter = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Nenhuma transação encontrada!');");  
					out.println("</script>");
					
					response.sendRedirect("transacao.jsp");
				}	
			}
			stmt.close();
			rs.close();
			con.close();
			
			}catch (SQLException e) {
	            //tratar erro
	        	e.printStackTrace();
	        	System.out.println("Erro ao exibir lista de transação processo: "+e);
	        	
	        }finally{
				  // fecha todos os recursos e devolve a conexao ao pool
			      if (rs != null && !rs.isClosed() ) {
			          try { rs.close(); } catch (SQLException e) { ; }
			          rs = null;
			      }
			      if (stmt != null && !stmt.isClosed() ) {
			          try { stmt.close(); } catch (SQLException e) { ; }
			          stmt = null;
			      }
			      if (con != null && !con.isClosed() ) {
			          try { con.close(); } catch (SQLException e) { ; }
			          con = null;
			      }
			}
			
			%>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>

