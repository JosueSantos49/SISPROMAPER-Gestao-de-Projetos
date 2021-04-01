<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page import="java.io.PrintWriter"	language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"	import="java.util.Date" import="java.text.SimpleDateFormat"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("2") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Usuário Chave</title>

<link rel="stylesheet" type="text/css" href="ajax_googleapis/jquery-ui.css">      
<link rel="stylesheet" type="text/css" href="ajax_googleapis/jquery.dataTables_themeroller.css">      
<script type='text/javascript' src="ajax_googleapis/jquery.min.js"></script>      
<script type='text/javascript' src="ajax_googleapis/jquery-ui.min.js"></script>      
<script type='text/javascript' src="ajax_googleapis/jquery.dataTables.min.js"></script>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link rel="stylesheet" type="text/css" media="screen, print" href="fluxogramaslickmap/slickmap_consultar_processos.css" />
<%
//Implementando Data e Hora
Date data = new Date();//criando objeto tipo Date e inicializando 
SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
String mostra_data = data_formatada.format(data); //Variável para armazenar a data

SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
%>
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000);">

<%@include file="menuperantecssprincipal.jsp"%>

<!-- <div align="center"><img src="img/s4.png" class="img-responsive" width="50%" height="7%" alt="image"></div>	-->

<div class="container">	
	<div class="alert alert-danger">
	 	<strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %>
	 	<p><strong><a href="menu_sugerido_principal.jsp" target="_parent">Clique aqui!</a></strong> Opções de ajuda para executar o sistema com desenvoltura! <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong>
	 	
	 	<p>
			Olá,
			<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response);}  
			%>
			você já criou o projeto? Caso, sim, siga nosso mapa. Para começar clique <strong><a href="mapa.jsp" target="_parent">aqui!</a></strong>!
		</p>
		
	</div>
						
	<div id="main">
		<div class="row small center wow fadeInDown top__element" data-wow-delay="2s">	
			<%@include file="tabela_operacoes.jsp" %>
		</div>
	</div>
	<!-- <div align="center">
		<a href="mapa.jsp"><img src="img/mapa.gif" width="73%"></a>
	</div>-->	
</div>	
<%@ include file="rodape.jsp" %>
</body>
</html>