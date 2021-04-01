<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List, br.com.tkcsapcd.model.bean.SolicitacaoServicoTI"%>
<%@page import="br.com.tkcsapcd.model.bean.SolicitacaoServicoTI"%>

<html>
<jsp:include page="sessao.jsp" />
<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>		

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Consultar SSTI</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/loaderPage.css"> <!-- / LOADER PAGE -->
<script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="js/ajax.js"></script><!-- / LOADER PAGE -->
<script language="javascript" src="js/funcoes.js"></script>

<!-- datatable 1.10.0 -->
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/validaPesquisarRelatorioSolicitacaoServicoTI.js"></script>

<script>
$(document).ready(function() {
    $('#tabela').dataTable();
} );
</script>

<script type="text/javascript">
	$(document).ready(function(){			
		$("#consProjeto1").mask("99/99/9999");  
	});
</script>

<script src="excellentexport-master/excellentexport.js"></script>
<style>  table, tr, td {   border: 0px black solid;  } </style>
	
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();"> 

	<%@include file="menuperantecssadm.jsp" %>
		
			<center><h5><img src="img/prancheta.jpg" height="40px" width="50px"><font color="grenn"> ${mensagem}</font></h5></center> 		
				
				<center><font color="red">Consultar Solicitação de Serviço de Tecnologia da Informação</font></center>
				
					<div align="left">
				
						<form id="formConsSSTI" name="formConsSSTI" method="post" action="pesquisar_solicitacaoservicoti.jsp" onSubmit="validaPesquisarRelatorioSolicitacaoServicoTI()">
							
							<strong>Relatório..:</strong>
						
							<input name="consSSTI" type="text" id="consSSTI" title="Digite o Código da SSTI para exibir" required="true" Placeholder="Código da SSTI!">
						
							<input class="button" name="pesqSSTI" type="submit" id="pesqSSTI" value="Exibir"  title="Digite o código para exibir" onclick="validaPesquisarRelatorioSolicitacaoServicoTI();">
												
						</form>

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
								        
								        	<form id="formConsSSTI" name="formConsSSTI" method="post" action="pesquisar_solicitacaoservicoti.jsp" onSubmit="validaPesquisarRelatorioSolicitacaoServicoTI()">
							
												<strong>Relatório..:</strong>
											
												<input name="consSSTI" type="text" id="consSSTI" title="Digite o Código da SSTI para exibir" required="true" Placeholder="Código da SSTI!">
											
												<input class="button" name="pesqSSTI" type="submit" id="pesqSSTI" value="Exibir"  title="Digite o código para exibir" onclick="validaPesquisarRelatorioSolicitacaoServicoTI();">
																	
											</form>
											
											<a href="imprimir_solicitacaoservicoti.jsp" class="btn" target="_parent">Geral</a> 
										
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
					  	<th>Cód. Projeto</th>
					    <th>Cód. SSTI</th>
						<th>Área</th>
						<th>Responsável</th>					
						<th>Telefone</th>
						<th>E-mail</th>
						<th>ID</th>
						<th>Data Solicitação</th>
						<th>Status</th>						
						<th>Editar</th>
						<th>Excluir</th>																			
					  </tr>
					</thead>			
				<tbody>  
				  	<%							
						List<SolicitacaoServicoTI> solicitacaoServicoTIs = (List<SolicitacaoServicoTI>) request.getAttribute("solicitacaoServicoTIs");
						for(SolicitacaoServicoTI solicitacaoServicoTI: solicitacaoServicoTIs){
					%>
				  <tr>				  	
					<td><%=solicitacaoServicoTI.getCodigoprojeto() %></td>
				    <td><%=solicitacaoServicoTI.getCodigosolicitaoservico() %></td>
					<td><%=solicitacaoServicoTI.getArea() %></td>
					<td><%=solicitacaoServicoTI.getResponsaveldemanda() %></td>				
					<td><%=solicitacaoServicoTI.getTelefonecontato() %></td>
					<td><%=solicitacaoServicoTI.getEmail() %></td>
					<td><%=solicitacaoServicoTI.getId() %></td>
					<td><%=solicitacaoServicoTI.getDatasolicitacao() %></td>
					<td><%=solicitacaoServicoTI.getStatus() %></td>				
					<td><a 	class="link_atualizar" href='TkcsapcdController?cmd=editarSolicitacaoServicoTI&codigo=<%=solicitacaoServicoTI.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
					<td ><a class="link_delete" href='TkcsapcdController?cmd=excluirSolicitacaoServicoTI&codigo=<%=solicitacaoServicoTI.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
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