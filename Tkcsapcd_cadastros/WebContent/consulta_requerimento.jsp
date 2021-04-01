<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Requerimento"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<title>Consultar Requerimento</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<!-- <link rel="stylesheet" href="css/menuperante.css" type="text/css"> -->
<script type="text/javascript" src="js/ajax.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaPesquisarRelatorioRequerimento.js"></script>
<script language="javascript" src="js/funcoes.js"></script>
<script type="text/javascript">$(document).ready(function(){ $('#tabela').dataTable();});</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<div id="preloader"><h1><img src="img/ajax-loaderazul.gif" height="30px"></h1></div>

<div id="conteudo">

<%@include file="menuperantecssadm.jsp" %>

				<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 		
				<br>
				<center><p><font color="red">Consultar Requerimento</font></p></center><br>
				 
				<form id="formConsRequerimento" name="formConsRequerimento" method="post" action="pesquisar_requerimento.jsp" onSubmit="return validaPesquisarRelatorioRequerimento(this)">
					<div align="left">					
					<strong>Cód. Requerimento (relatório)..:</strong>
					<input name="consRequerimento" type="text" id="consRequerimento" required="true" Placeholder="Cód. Requerimento">				
					<input class="button" name="pesqRequerimento" type="submit" id="pesqRequerimento" value="Exibir" onclick="validaPesquisarRelatorioRequerimento();">
					</div>
				</form>
				
				<br>
				<br>
		
		<div class="table-responsive">	
		<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Click aqui para exportar para Excel." height="20" width="27" src="img/xls.jpg"></a> 
		<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>		
			<table id="tabela"	cellpadding="5" cellspacing="5" class="display">
				<thead>
					<tr>	
						<th>Cód. Requerimento</th>
						<th>Requerimento Nome</th>					
						<th>Requerimento Status</th>
						<th>Editar</th>
						<th>Excluir</th>					
					</tr>
				</thead>			
					<%
						List<Requerimento> requerimentos = (List<Requerimento>) request.getAttribute("requerimentos");
						for (Requerimento requerimento: requerimentos) {
					%>
				<tr>					
					<td><%=requerimento.getCodigo() %></td>
					<td><%=requerimento.getNome()%></td>
					<td><%=requerimento.getRqstatus()%></td>
					<td><a	class="link_atualizar" href='TkcsapcdController?cmd=editarRequerimento&codigo=<%=requerimento.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td><a	class="link_delete" href='TkcsapcdController?cmd=excluirRequerimento&codigo=<%=requerimento.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
				</tr>
				<%
					}
				%>
			</table>	
		</div>
</div>
<%@include file="rodape.jsp" %>
</body>
</html>	