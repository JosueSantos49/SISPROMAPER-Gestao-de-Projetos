<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.Organograma"%>
<%@page import="java.io.PrintWriter" import="java.util.*, javax.rmi.*, javax.naming.*, java.io.*, java.lang.*" import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<html>

<jsp:include page="sessao.jsp" />
<jsp:include page="conexao.jsp" />
<jsp:include page="httpservletrequest.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Organograma</title>	

<!-- Bootstrap -->  
<link href="bootstrap/css/bootstrapPagination.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<script type="text/javascript" src="js/confirmaExclusaoAtualizacao.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorioUsuario.js"></script>
<script src="excellentexport-master/excellentexport.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script language="javascript" src="js/funcoes.js"></script>	

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

</head>	

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %><br>

			<div align="center">
				<h5>
					<img src="img/prancheta.jpg" height="20px" width="30px"><font color="grenn"> ${mensagem}</font>
				</h5>
			</div>

<div class="container">
	
		<div align="left">

				<form id="formConsProjeto" name="formConsProjeto" method="post"
					action="pesquisar_organograma.jsp"
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
		
		<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Click aqui para exportar para Excel." height="20" width="27" src="img/xls.jpg"></a> 
		<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
		<div class="table-responsive">
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
						<tr>
							<th>Cód. Registro</th>
							<th>Cód. Projeto</th>
							<th>Projeto</th>
							<th>Data</th>
							<th>Descrição</th>
							<th>Status</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
							<%
								List<Organograma> organogramas = (List<Organograma>) request.getAttribute("organogramas");
								for (Organograma organograma : organogramas) {
							%>
						<tr>							
							<td><%=organograma.getProjetoinicio().getCodigo()%></td>
							<td><%=organograma.getProjetoinicio().getCodigoprojeto()%></td>
							<td><%=organograma.getProjetoinicio().getProjeto()%></td>
							<td><%=organograma.getData()%></td>
							<td><%=organograma.getDescricao()%></td>
							<td><a 	href='TkcsapcdController?cmd=editarOrganogramaStatus&codigo=<%=organograma.getCodigo()%>'><img
									alt="" title="Consultar Status" height="20" width="27"
									src="img/ok.jpg"></a></td>
							
							<td><a class="link_atualizar"
								href='TkcsapcdController?cmd=editarOrganograma&codigo=<%=organograma.getCodigo()%>'><img
									alt="" title="Atualizar" height="20" width="27"
									src="img/alterar.gif"></a></td>
							<td><a class="link_delete"
								href='TkcsapcdController?cmd=excluirOrganograma&codigo=<%=organograma.getCodigo()%>'><img
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
<br><br>
<%@include file="rodape.jsp" %>
</body>	
</html>