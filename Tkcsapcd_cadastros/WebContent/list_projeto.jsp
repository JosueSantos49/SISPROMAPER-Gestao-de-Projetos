<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBeanProjeto"%>
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

<title>Consultar Lista de Arquivos Projeto</title>

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
					<font color="red">Consultar Lista de Arquivo Projeto</font>
				</p>
			</div>
			
			<br>

			<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');">
			<img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
			
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
								        
								        	<form id="formConsProjeto" name="formConsProjeto" method="post"	action="pesquisar_file_upload_projeto.jsp" onSubmit="return validaPesquisarRelatorio(this)">					
												<strong>Relatório..:</strong> 												
												<input 	name="consProjeto" type="text" id="consProjeto" title="Digite o Código do Projeto para exibir o relatório." required="true" Placeholder="Código do Projeto!" style="height: 30px; width: 150px"> 
												<input 	class="button" name="pesqProjeto" type="submit" id="pesqProjeto" value="Exibir" title="Digite o Código do Projeto para exibir o relatório." onclick="validaPesquisarRelatorio();">
											</form> 
											
											<!-- <a href="imprimir_projeto.jsp" class="btn" target="_parent">Geral</a>  -->
										
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
				<table id="tabela" cellspacing="5" cellspacing="5" class="display">
					<thead>
						<tr>
							<th>ID</th>
							<th>Código Projeto</th>
							<th>Data Registro</th>
							<th>Nome do Arquivo (Extensão)</th>
							<th>Descrição</th>
							<th>E-mail</th>	
							<!-- <th>Editar</th>	 -->					
							<th>Excluir</th>
							<th>Download</th>
						</tr>
					</thead>
					<%
						List<FileBeanProjeto> fileBeanProjetos = (List<FileBeanProjeto>) request.getAttribute("fileBeanProjetos");
						for (FileBeanProjeto fileBeanProjeto : fileBeanProjetos) {
					%>
					<tr>
						<td><%=fileBeanProjeto.getId()%></td>
						<td><%=fileBeanProjeto.getCodigoprojeto()%></td>
						<td><%=fileBeanProjeto.getDataregistro()%></td>
						<td><%=fileBeanProjeto.getName()%></td>
						<td><%=fileBeanProjeto.getDescription()%></td>
						<td><%=fileBeanProjeto.getEmail()%></td>
						<!-- <td><a	class="link_atualizar"	href='TkcsapcdController?cmd=editarFileBeanProjeto&id= '><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td> -->
						<td><a class="link_delete" href='TkcsapcdController?cmd=excluirFileBeanProjeto&codigo=<%=fileBeanProjeto.getId()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
						<td><a href="downloadProjeto.do?id=<%=fileBeanProjeto.getId()%>">Baixar</a></td>
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
