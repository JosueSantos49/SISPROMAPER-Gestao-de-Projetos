<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.ListaOcorrencia"%>
<%@page import="br.com.tkcsapcd.model.bean.ListaOcorrencia"%>
<jsp:include page="sessao.jsp" />
<html>
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Consultar Lista Ocorrência</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->	
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> 
<script src="js/jquery.maskedinput.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/funcoes.js"></script>
<script type="text/javascript" src="js/validaPesquisarRelatorio.js"></script>

<!-- Configuração para exibir modal automaticamente -->
 <script type="text/javascript">
	  $(document).ready(function () {
		  $('#myModal2').modal('show');
	  });
</script>

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela1').dataTable();
	$('#tabela2').dataTable();
});
</script>

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
					<font color="red">Consultar Lista Ocorrência</font>
				</p>
			</div>
			<br>

			<div align="left">

				<form id="formConsProjeto" name="formConsProjeto" method="post"
					action="pesquisar_lista_ocorrencia.jsp"
					onSubmit="return validaPesquisarRelatorio(this)">
					<!-- onSubmit="return validaPesquisarRelatorioProjeto(this);" -->

					<strong>Relatório..:</strong> <input name="consProjeto" type="text"
						id="consProjeto"
						title="Digite o Código do Projeto para exibir o relatório."
						required="true" Placeholder="Código do Projeto!"> <input
						class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
						value="Exibir"
						title="Digite o Código do Projeto para exibir o relatório."
						onclick="validaPesquisarRelatorio();">
				</form>
			</div>
			<br> 
			<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a> 
			<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>					
								<!-- Trigger the modal with a button -->
								<button type="button" class="btn btn-info btn-mini" data-toggle="modal" data-target="#myModal">Relatório</button>
								  
								<!-- Modal Relatório -->
								<div class="container">
								
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Projeto</h4>
								        </div>
								        <div class="modal-body">
								        
								        	<form id="formConsProjeto" name="formConsProjeto" method="post"
												action="pesquisar_lista_ocorrencia.jsp"
												onSubmit="return validaPesquisarRelatorio(this)">
												<!-- onSubmit="return validaPesquisarRelatorioProjeto(this);" -->
							
												<strong>Relatório..:</strong> <input name="consProjeto" type="text"
													id="consProjeto"
													title="Digite o Código do Projeto para exibir o relatório."
													required="true" Placeholder="Código do Projeto!"> <input
													class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
													value="Exibir"
													title="Digite o Código do Projeto para exibir o relatório."
													onclick="validaPesquisarRelatorio();">
											</form> 
											
											<a href="imprimir_lista_ocorrencia.jsp" class="btn" target="_parent">Geral</a> 
										
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Relatório -->
								
								<div class="table-responsive">
									<table id="tabela1" cellspacing="5" cellspacing="5" class="display">
										<thead>
											<tr>
												<th>Código Projeto</th>
												<th>Autor Projeto</th>
												<th>Data Cadastro</th>
												<th>Titulo</th>
												<th>Responsavel</th>
												<th>Área</th>
												<th>Tipo de Projeto</th>
												<th>Status</th>
												<th>Data Implantação Prevista</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
												<%
													List<ListaOcorrencia> listaOcorrencias = (List<ListaOcorrencia>) request.getAttribute("listaOcorrencias");
													for (ListaOcorrencia listaOcorrencia : listaOcorrencias) {
												%>
											<tr>							
												<td><%=listaOcorrencia.getCodigoprojeto()%></td>
												<td><%=listaOcorrencia.getCliente()%></td>
												<td><%=listaOcorrencia.getGerente()%></td>
												<td><%=listaOcorrencia.getPreparado()%></td>
												<td><%=listaOcorrencia.getIssue()%></td>
												<td><%=listaOcorrencia.getSeveridade()%></td>
												<td><%=listaOcorrencia.getUrgencia()%></td>
												<td><%=listaOcorrencia.getResponsavel()%></td>
												<td><%=listaOcorrencia.getDataocorrencia()%></td>
												<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarListaOcorrencia&codigo=<%=listaOcorrencia.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
												<td><a class="link_delete" href='TkcsapcdController?cmd=excluirListaOcorrencia&codigo=<%=listaOcorrencia.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								
			</div>
		</div>
	<%@include file="rodape.jsp" %>
</body>
</html>