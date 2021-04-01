<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.RfpProjeto"%>

<html>

<jsp:include page="sessao.jsp" />
<% 

	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>

<title>Consultar RFP-Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
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

<script type="text/javascript" src="js/validaPesquisarRelatorioRfpProjeto.js"></script>
<script language="javascript" src="js/funcoes.js"></script>
<script type="text/javascript">$(document).ready(function(){	$('#tabela').dataTable();});</script>

<script type="text/javascript">
		$(document).ready(function() {
			$('#formConsRfpProjeto').validate({
				//Definindo validação pelo nome de cada campo do form
				rules : {
					consRfpprojeto : {
						required : true,
						minlength : 5
					}
				},
				messages : {
					consRfpprojeto : {
						required : "Obrigatório.",
						minlength : "Nome completo."
					},								
				}
			});
		});
</script>
<script>
	$(document).ready(function(){			
			$('#conteudo').hide();
			
			$('$mostrar').click(function(event){
				event.preventDefault();
				$("#conteudo").show("slow");			
			});
			
			$('$ocultar').click(function(event){
				event.preventDefault();
				$("#conteudo").hide("slow");
			});	
			
		});	
</script>
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<div id="preloader"><h1><img src="img/ajax-loaderazul.gif" height="30px"></h1></div>

<%@include file="menuperantecssadm.jsp" %>

	<div align="center"></div>
		<br>
			<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center> 		
			<br>
			<center><p><font color="red">Consultar RFP-Projeto</font></p></center>
			<br>
			<!-- FORM BUSCA DE PROJETO -->
			<div align="left">
			<form id="formConsRfpProjeto" name="formConsRfpProjeto" method="post" action="pesquisar_rfpprojeto.jsp" onSubmit="return validaPesquisarRelatorioRfpProjeto(this)">
			
				<strong>Relatório..:</strong>
				<input name="consRfpprojeto" type="text" id="consRfpprojeto" title="Digite o Código do Projeto para pesquisar" required="true" Placeholder="Código do Projeto!">				
				<input class="button" name="pesqRfpprojeto" type="submit" id="pesqRfpprojeto" value="Exibir" title="Digite o Código do Projeto para pesquisar" onclick="validaPesquisarRelatorioRfpProjeto();">				
			</form>
			</div> 
		<br>
		<br>
		<div class="table-responsive">
		<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Click aqui para exportar para Excel." height="20" width="27" src="img/xls.jpg"></a> 
		
		<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
			<table id="tabela" cellspacing="5" cellspacing="5" class="display">
				<thead>
					<tr>
						<th>Cód Projeto</th>
						<th>Cód Item</th>
						<th>Nome RFP</th>
						<th>Nome Empresa</th>
						<th>Telefone</th>
						<th>E-mail</th>	
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<%
					List<RfpProjeto> rfpProjetos = (List<RfpProjeto>) request.getAttribute("rfpProjetos");
					for (RfpProjeto rfpProjeto : rfpProjetos) {
				%>
				<tr>	
					<td><%=rfpProjeto.getCodigoProjeto()%></td>
					<td><%=rfpProjeto.getItensProjeto()%></td>
					<td><%=rfpProjeto.getNomeRfpProjeto()%></td>	
					<td><%=rfpProjeto.getNomeempresa()%></td>
					<td><%=rfpProjeto.getTelefone()%></td>
					<td><%=rfpProjeto.getEmailrepresentante()%></td>			
					<td><a	class="link_atualizar"	href='TkcsapcdController?cmd=editarRfpProjeto&codigo=<%=rfpProjeto.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td><a	class="link_delete"		href='TkcsapcdController?cmd=excluirRfpProjeto&codigo=<%=rfpProjeto.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
				</tr>
				<%
					}
				%>
			</table>	
		</div>	
		<%@include file="rodape.jsp" %>
</body>
</html>