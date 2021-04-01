<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.Cliente"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Cliente</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">	
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> 
<script src="js/jquery.maskedinput.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script language="javascript" src="js/funcoes.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorioCliente.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

<!-- MASCARA PARA TRATAMENTO DE ERRO -->
<script>
	$(document).ready(function() {
		$("#consCliente").mask("999.999.999-99"); 	
	});
</script>
<script type="text/javascript">
		$(document).ready(function() {
			$('#formConsCliente').validate({
				//Definindo validação pelo nome de cada campo do form
				rules : {
					consCliente : {
						required : true,
						minlength : 5
					}
				},
				messages : {
					consCliente : {
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

	<%@include file="menuperantecssadm.jsp"%>
		
			<center><h4><img src="img/clientes.png" height="40px" width="50px"><font color="grenn">${mensagem}</font></h4></center>
		
			<br>
			
			<!-- FORM BUSCA DE CLIENTE -->		
			<form id="formConsCliente" name="formConsultaCliente" method="post" action="pesquisar_cliente.jsp">
				<strong>Relatório..:</strong>
				<input name="consCliente" type="text" id="consCliente" required="true" Placeholder="Informe o CPF!">
				<input class="button" name="pesqCliente" type="submit" id="pesqCliente" value="Exibir" title="Digite o CPF para exibir" onclick="validaPesquisarRelatorioCliente();">
				<br>
				<br>
				<br>
			</form>
			
			<div id="main">
 				<div class="wow fadeInDown top__element" data-wow-delay="2s">
 			<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a> 			
 			<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
			<div class="table-responsive">				
					<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>	
						<tr>			
							<th>Nome</th>
							<th>Profissão</th>
							<th>RG</th>
							<th>Telefone</th>
							<th>Cidade</th>
							<th>CEP</th>
							<th>CPF</th>
							<th>CNPJ</th>
							<th>Desde</th>
							<th>E-mail</th>
							<th>Empresa</th>
							<th>Auditoria</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<%
						List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
						for(Cliente cliente: clientes){
					 %>
					<tr>	
						<td><%=cliente.getNome() %></td>		
						<td><%=cliente.getProfissao()%></td>
						<td><%=cliente.getRg() %></td>
						<td><%=cliente.getFone() %></td>
						<td><%=cliente.getCidade() %></td>
						<td><%=cliente.getCep() %></td>
						<td><%=cliente.getCpf() %></td>
						<td><%=cliente.getCnpj() %></td>					
						<td><%=cliente.getDesde() %></td>					
						<td><%=cliente.getEmail() %></td>
						<td><%=cliente.getEmpresa() %></td>
						<td><%=cliente.getAuditoria() %></td>
						<td><a 	class="link_atualizar"	href='TkcsapcdController?cmd=editarCliente&codigo=<%=cliente.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
						<td><a 	class="link_delete"		href='TkcsapcdController?cmd=excluirCliente&codigo=<%=cliente.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>				
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