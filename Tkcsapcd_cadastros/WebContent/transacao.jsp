<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="java.io.PrintWriter" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.FileBean"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.FileBean"%>
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

<title>Pesquisar Transação</title>

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

<body onLoad="setFocus()">

	<%@include file="menuperantecssadm.jsp"%>


		
		<div align="left">

		<form action="transacao_processo.jsp" id="formulario" name="formulario" method="post">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PESQUISAR TRANSAÇÃO</font></th></tr></table><br>
				
			<div id="main">
			<div class="wow fadeInDown top__element" data-wow-delay="2s">
				 <div class="alert alert-danger">
					Olá, 
					<%=session.getAttribute("theName")%>
						<%  
						//verifica se a sessao do usuario é válida  
						if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
					%>
					seja bem-vindo a etapa de pesquisar transação. Ao informar o código da transação, você será direcionado para uma página que informa, se a transação existe. Caso, exista o sistema permite o acesso de acordo com o nível de acesso estabelecido.  
				</div>
			</div>
		</div>				
				
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					<tr>
						<td>
							<p>
								<font color="red">Campos de (*) obrigatório.</font>
							</p>
							<br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Transação <font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="codigotransacao" id="codigotransacao" required="true" Placeholder="Informar o Código da Transação" style="height: 30px; width: 379px" maxlength="150" class="input"><br/>
							<p class="hint">[Informar o Código da Transação.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
				</table>				
					<input type="submit" value="Enviar" class="prev acao"/><!--  onclick="show_confirm();" -->
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>

