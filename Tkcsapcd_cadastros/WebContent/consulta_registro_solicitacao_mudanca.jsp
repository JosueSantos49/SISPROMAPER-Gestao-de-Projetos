<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca"%>
<%@page import="br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca"%>
<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3")
			&& !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da p�gina -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Consultar Registro de Solicita��o de Mudan�a</title>

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

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

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
					<font color="red">Consultar Registro de Solicita��es de Mudan�as</font>
				</p>
			</div>
			<br>

			<div align="left">

				<form id="formConsProjeto" name="formConsProjeto" method="post"
					action="pesquisar_registro_solicitacao_mudanca.jsp"
					onSubmit="return validaPesquisarRelatorio(this)">

					<strong>Relat�rio..:</strong> <input name="consProjeto" type="text"
						id="consProjeto"
						title="Digite o C�digo do Projeto para exibir o relat�rio."
						required="true" Placeholder="C�digo do Projeto!"> <input
						class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
						value="Exibir"
						title="Digite o C�digo do Projeto para exibir o relat�rio."
						onclick="validaPesquisarRelatorio();">
				</form>
			</div>
			<br> <a download="somedata.xls" href="#"
				onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img
				alt="" title="Export to Excel" height="20" width="27"
				src="img/xls.jpg"></a>
				<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
				 <br />
			<div class="table-responsive">
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
						<tr>
							<th>C�d. Registro</th>
							<th>C�d. Projeto</th>
							<th>Projeto</th>
							<th>R. Sol. Mudan�a</th>
							<th>Vers�o</th>
							<th>Data</th>
							<th>Autor</th>
							<th>Nota de Revis�o</th>							
							<th>Refer�ncia</th>
							<th>Prioridade</th>
							<th>Solicita��o</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
							<%
								List<RegistroSolicitacaoMudanca> registroSolicitacaoMudancas = (List<RegistroSolicitacaoMudanca>) request.getAttribute("registroSolicitacaoMudancas");
								for (RegistroSolicitacaoMudanca registroSolicitacaoMudanca : registroSolicitacaoMudancas) {
							%>
						<tr>							
							<td><%=registroSolicitacaoMudanca.getCodigo()%></td>
							<td><%=registroSolicitacaoMudanca.getProjetoinicio().getCodigo()%></td>
							<td><%=registroSolicitacaoMudanca.getProjetoinicio().getProjeto()%></td>
							<td><%=registroSolicitacaoMudanca.getSolicitacaomudanca()%></td>
							<td><%=registroSolicitacaoMudanca.getVersao()%></td>
							<td><%=registroSolicitacaoMudanca.getData()%></td>
							<td><%=registroSolicitacaoMudanca.getAutor()%></td>
							<td><%=registroSolicitacaoMudanca.getNotarevisao()%></td>
							<td><%=registroSolicitacaoMudanca.getReferencia()%></td>
							<td><%=registroSolicitacaoMudanca.getPrioridade()%></td>
							<td><%=registroSolicitacaoMudanca.getSolicitacao()%></td>
							<td><a class="link_atualizar"
								href='TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca&codigo=<%=registroSolicitacaoMudanca.getCodigo()%>'><img
									alt="" title="Atualizar" height="20" width="27"
									src="img/alterar.gif"></a></td>
							<td><a class="link_delete"
								href='TkcsapcdController?cmd=excluirRegistroSolicitacaoMudanca&codigo=<%=registroSolicitacaoMudanca.getCodigo()%>'><img
									alt="" title="Excluir" height="20" width="27"
									src="img/delete.gif"></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>