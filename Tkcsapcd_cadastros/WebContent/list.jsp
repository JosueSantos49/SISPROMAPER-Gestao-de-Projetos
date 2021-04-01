<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBean"%>
<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Consultar Lista de Arquivos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css">
<link rel="stylesheet" type="text/css" media="screen"	href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen"	href="plugindatatable/css/dataTables.jqueryui.css">
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/funcoes.js"></script>
<script type="text/javascript"	src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"	src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"	src="plugindatatable/js/dataTables.jqueryui.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorio.js"></script>

<script>
	$(document).ready(function() {
		$('#tabela').dataTable();
	});
</script >

	<script type="text/javascript">

	$(document).ready(function() {
		$("#consProjeto1").mask("99/99/9999");
	});
</script >

<script src="excellentexport-master/excellentexport.js"></script>

<style>
table,tr,td {
	border: 0px black solid;
}
</style>

</head>

<body>

	<div id="preloader">
		<h1>
			<img src="img/ajax-loaderazul.gif" height="30px">
		</h1>
	</div>

	<div id="conteudo">

		<div align="justify">

			<%@include file="menuperantecssadm.jsp"%>

			<div align="center">
				<h4>
					<img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font>
				</h4>
			</div>

			<br>
			<div align="center">
				<p>
					<font color="red">Consultar Lista de Arquivos</font>
				</p>
			</div>
			
			<br>

			<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');">
			<img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a> <br />
			<div class="table-responsive">
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome do Arquivo (Extensão)</th>
							<th>Descrição</th>
							<th>Excluir</th>
							<th>Download</th>
						</tr>
					</thead>
					<%
						List<FileBean> fileBeans = (List<FileBean>) request.getAttribute("fileBeans");
						for (FileBean fileBean : fileBeans) {
					%>
					<tr>
						<td><%=fileBean.getId()%></td>
						<td><%=fileBean.getName()%></td>
						<td><%=fileBean.getDescription()%></td>
						<td><a class="link_delete" href='TkcsapcdController?cmd=excluirFileBean&codigo=<%=fileBean.getId()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
						<td><a href="download.do?id=<%=fileBean.getId()%>">Baixar</a></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
				</div>
			</div>
	<%@include file="rodape.jsp" %>
</body>
</html>
