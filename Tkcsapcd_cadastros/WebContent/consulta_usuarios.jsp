<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.Usuario"%>
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar Usuário</title>	

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

<%@include file="menuperantecssadm.jsp" %>

<center><img src="img/prancheta.jpg" height="40px" width="50px"></center> 

<center><h4><font color="green">${mensagem}</font></h4></center>
		
		<div align="left">
		
			<form id="formConsUsuario" name="formConsUsuario" method="post" action="pesquisar_usuarios.jsp" onSubmit="validaPesquisarRelatorioUsuario()">		
				<strong>CPF (relatório)..:</strong> 
				<input name="consUsuario" type="text" id="consUsuario" title="Digite o CPF para exibir" maxlength="14" required="true" Placeholder="Entre com o CPF!">
				<input class="button" name="pesqUsuario" type="submit" id="pesqUsuario" value="Exibir"	title="Digite o CPF para exibir" onclick="validaPesquisarRelatorioUsuario();">
			</form>
		</div>
		
		<a download="somedata.xls" href="#"	onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Click aqui para exportar para Excel." height="20" width="27" src="img/xls.jpg"></a> 
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
												action="pesquisar_usuarios.jsp"
												onSubmit="return validaPesquisarRelatorio(this)">
							
												<strong>Relatório..:</strong> 
												<input name="consProjeto" type="text"
													id="consProjeto"
													title="CPF"
													required="true" Placeholder="CPF"> 
												<input
													class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
													value="Exibir"
													title="Digite o Código do Projeto para exibir o relatório."
													onclick="validaPesquisarRelatorio();">
											</form> 
											
											<a href="imprimir_usuarios.jsp" class="btn" target="_parent">Geral</a> 
										
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
							<th>Usuário</th>
							<th>Nível</th>
							<th>CPF</th>
							<th>Data Registro</th>
							<th>Nome</th>
							<th>Id</th>
							<th>Gestor Imediato</th>
							<th>Departamento</th>
							<th>E-mail</th>
							<th>Telefone</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
							<%
								List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
								for (Usuario usuario : usuarios) {
							%>
						<tr>
								
							<td><%=usuario.getLog_usuario()%></td>
							<td><%=usuario.getLog_nivelacesso()%></td>
							<td><%=usuario.getLog_cpf()%></td>
							<td><%=usuario.getLog_datacadastro()%></td>
							<td><%=usuario.getNome()%></td>
							<td><%=usuario.getId()%></td>
							<td><%=usuario.getGestorimediato()%></td>
							<td><%=usuario.getDepartamento()%></td>
							<td><%=usuario.getEmail()%></td>
							<td><%=usuario.getTelefone()%></td>
							<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarUsuario&log_codigo=<%=usuario.getLog_codigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
							<td><a class="link_delete" href='TkcsapcdController?cmd=excluirUsuario&log_codigo=<%=usuario.getLog_codigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>     
		</div>
<br><br>
<%@include file="rodape.jsp" %>
</body>	
</html>