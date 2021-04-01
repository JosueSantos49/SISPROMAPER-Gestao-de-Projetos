<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.AtaReuniao"%>
<%@page import="br.com.tkcsapcd.model.bean.AtaReuniao"%>
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

<title>Consultar Ata de Reunião</title>

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

			<script type="text/javascript">
				function visualizarRelatorio() {		
					enviar("visualizar");		
				}
			
				function gerarRelatorioPDF() {		
					enviar("pdf");
				}

				function gerarRelatorioDOC() {		
					enviar("doc");
				}

				function gerarRelatorioPPT() {		
					enviar("ppt");
				}
				
				function enviar(acao) {
					document.forms[0].acao.value = acao;
					document.forms[0].target = "_blank";
					document.forms[0].action = "./RelatorioServletAtaReuniao";
					document.forms[0].submit();
				}
			</script>

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
					<font color="red">Consultar Ata de Reunião</font>
				</p>
			</div>
			<br>
			
			<form action="./RelatorioServletAtaReuniao" name="form" method="post" onsubmit="return false;">
				<input type="hidden" name="acao" />	
				<input type="submit" value="Visualizar Relatorio" onclick="javascript:visualizarRelatorio();">
				<input type="submit" value="PDF" onclick="javascript:gerarRelatorioPDF();">
				<input type="submit" value="DOC" onclick="javascript:gerarRelatorioDOC();">
				<input type="submit" value="PPT" onclick="javascript:gerarRelatorioPPT();">		
			</form>

			<div align="left">

				<form id="formConsProjeto" name="formConsProjeto" method="post"
					action="pesquisar_ata_reuniao.jsp"
					onSubmit="return validaPesquisarRelatorio(this)">

					<strong>Relatório..:</strong> <input name="consProjeto" type="text"
						id="consProjeto"
						title="Digite o Código do Projeto para exibir o relatório."
						required="true" Placeholder="Código do Registro!"> <input
						class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
						value="Exibir"
						title="Digite o Código do Projeto para exibir o relatório."
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
							<th>Cód. Registro</th>
							<th>Cód. Projeto</th>
							<th>Desc. Projeto</th>
							<th>Ata Reunião</th>
							<th>Data</th>
							<th>Local</th>							
							<th>Versão</th>
							<th>Relatório</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
							<%
								List<AtaReuniao> ataReuniaos = (List<AtaReuniao>) request.getAttribute("ataReuniaos");
								for (AtaReuniao ataReuniao : ataReuniaos) {
							%>
						<tr>							
							<td><%=ataReuniao.getCodigo()%></td>
							<td><%=ataReuniao.getProjetoinicio().getCodigoprojeto()%></td>
							<td><%=ataReuniao.getProjetoinicio().getProjeto()%></td>
							<td><%=ataReuniao.getAta()%></td>
							<td><%=ataReuniao.getData()%></td>
							<td><%=ataReuniao.getLocal()%></td>
							<td><%=ataReuniao.getVersao()%></td>	
							
							<td><a
								href='./RelatorioServletAtaReuniao?codigo=<%=ataReuniao.getCodigo()%>'><img
									alt="" title="Relatório" height="18" width="25"
									src="img/relatorio.png"></a></td>
									
							<td><a class="link_atualizar"
								href='TkcsapcdController?cmd=editarAtaReuniao&codigo=<%=ataReuniao.getCodigo()%>'><img
									alt="" title="Atualizar" height="20" width="27"
									src="img/alterar.gif"></a></td>
							<td><a class="link_delete"
								href='TkcsapcdController?cmd=excluirAtaReuniao&codigo=<%=ataReuniao.getCodigo()%>'><img
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