<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Statuss"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<title>Consultar Status</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/ajax.js"></script><!-- / LOADER PAGE -->
<!-- <link rel="stylesheet" href="css/menuperante.css" type="text/css"> -->

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaPesquisarRelatorioStatuss.js"></script>
<script language="javascript" src="js/funcoes.js"></script>
<script type="text/javascript">	$(document).ready(function(){$('#tabela').dataTable();	});</script>

<script>
	function show_confirm()
	{
		var r=confirm("Click em OK, para continuar!");
		if(r==true)
			{
			alert("Continuando...");
			return true;			
			}
		else
			{
				alert("Click em OK, para cancelar!");
				location.href="TkcsapcdController?cmd=consultarStatuss";
			}		
	} 
</script>
<script>
	$(document).ready(function() {
		$('#formConsStatus').validate({
			//Definindo validação pelo nome de cada campo do form
			rules : {
				consStatuss : {
					required : true,
					minlength : 5
				}
			},
			messages : {
				consStatuss : {
					required : "Obrigatório.",
					minlength : "Nome completo."
				},								
			}
		});
	});
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<div id="preloader"><h1><img src="img/loader.gif" height="70px"></h1></div>

<div id="conteudo">

<%@include file="menuperantecssadm.jsp" %>

	<div align="center"></div>
		<br><br>
		<center><h4><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h4></center>
		<br> 		
		<center><p><font color="red">Consultar Status</font></p></center>
	   	<br><br>	   	
	   		<!-- FORM BUSCA DE STATUS -->
 			<div align="left">
			<form id="formConsultaStatus" name="formConsultaStatus" method="post" action="pesquisar_statuss.jsp" onSubmit="validaPesquisarRelatorioStatuss()">
				<strong>Cód. Staus (relatório)..:</strong>
				<input name="consStatuss" type="text" id="consStatuss" title="Digite o código para exibir." required="true" Placeholder="Código Status">
				<input class="button" name="pesqStatuss" type="submit" id="pesqStatuss" value="Exibir" title="Digite a fase para pesquisa" onclick="validaPesquisarRelatorioStatuss();">				
			</form>
			</div>
			<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
						<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>	
		<div class="table-responsive">	
			<table id="tabela" cellpadding="5" cellpadding="5" class="display">
				<thead>
					<tr>	
						<th>Projeto</th>
						<th>Código Porjeto</th>
						<th>Cód. Status</th>				
						<th>Fase</th>
						<th>Percentual Evolução</th>
						<th>Percentual Planejamento</th>
						<th>Data Status</th>
						<th>Tendência</th>
						<th>Data Inicio</th>
						<th>Data Fim</th>																				
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
					<%								
						List<Statuss> statusss = (List<Statuss>) request.getAttribute("statusss");
						for(Statuss statuss: statusss ){
				 	%>
				<tr>	
				 	<td><%=statuss.getProjeto()%></td>			
					<td><%=statuss.getCodigodoprojeto() %></td>
				 	<td><%=statuss.getCodigo() %></td>			
					<td><%=statuss.getFase() %></td>
					<td><%=statuss.getPercentualevolucao() %></td>
					<td><%=statuss.getPercentualplanejado() %></td>
					<td><%=statuss.getDatastatus() %></td>
					<td><%=statuss.getTendencia() %></td>
					<td><%=statuss.getDatainicio() %></td>
					<td><%=statuss.getDatafim() %></td>		
					<td ><a class="link_atualizar" 	href='TkcsapcdController?cmd=editarStatuss&codigo=<%=statuss.getCodigo()%>' ><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td><a 	class="link_delete" 	href='TkcsapcdController?cmd=excluirStatuss&codigo=<%=statuss.getCodigo()%>' ><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>				
				</tr>
				<%
				 	}
				 %>
		</table>
	</div>
	<br><br>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>