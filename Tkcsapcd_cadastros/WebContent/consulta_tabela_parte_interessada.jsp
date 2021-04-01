<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.TabelaParteInteressada"%>
<%@page import="br.com.tkcsapcd.model.bean.TabelaParteInteressada"%>

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

<title>Listar Tabela Parte Interessada</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="bootstrap/teste/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<script src="bootstrap/modal/jquery.min.js"></script><!-- Modal Relatório -->
<script src="bootstrap/modal/bootstrap.modal.js"></script><!-- Modal Relatório -->

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
		  $('#myModal00').modal('show');
	  });
</script>

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
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
		
		<div id="wrapper">

       		<%@include file="menuprojetoiniciouniversal.jsp" %>

		        <div id="page-wrapper">
		
		            <div class="container-fluid">
		            
		                <!-- Page Heading -->
		                <div class="row">
		                    <div class="col-lg-12">
		                    
		                     <div class="alert alert-success">
							Olá, 
								<%=session.getAttribute("theName")%>
									<%  
									//verifica se a sessao do usuario é válida  
									if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
								%>
								esta etapa permite listar projeto ou proposta de projeto. Através do menu superior a esquerda, você pode executar outras transações. Fique atento você pode envolver pessoa, altera e excluir dado do registro. Outra transação <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong> 
							</div>
					
		                        <h5 class="page-header">${mensagem}<br>
		                        <%
									String msg = (String) request.getAttribute("msg");
										if(msg != null)
									out.println(msg);
								%>
		                        
		                        </h5>
		                        <ol class="breadcrumb">
		                            <li>
		                                <i class="fa fa-dashboard"></i>  <a href="sair.jsp">logout</a>
		                            </li>
		                            <li class="active">
		                                <i class="fa fa-table"></i><font color="red">lista Partes Interessadas</font>
		                            </li>
		                        </ol>
		                    </div>
		                </div>
		                <!-- /.row -->     
					  
                <div class="row">
                    <div class="col-lg-15">
                        <h2></h2>
                        <div class="table-responsive"> 
								<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
								<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
								<!-- Trigger the modal with a button -->
								<button type="button" class="glyphicon glyphicon-folder-open" data-toggle="modal" data-target="#myModal"></button>
								<button type="button" class="glyphicon glyphicon-fullscreen" data-toggle="modal" data-target="#myModal1"></button>
								<button type="button" class="glyphicon glyphicon-calendar" data-toggle="modal" data-target="#myModal2"></button>
								  
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
								        
								        	<form 
								        		id="formConsProjeto" 
								        		name="formConsProjeto" 
								        		method="post"
												action="pesquisar_tabela_parte_interessada.jsp"
												onSubmit="return validaPesquisarRelatorio(this)">
							
												<strong>Relatório..:</strong> <input name="consProjeto" type="text"
													id="consProjeto"
													title="Digite o Código do Projeto para exibir o relatório."
													required="true" Placeholder="Código do Projeto!"> <input
													class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
													value="Exibir"
													title="Digite o Código do Projeto para exibir o relatório."
													onclick="validaPesquisarRelatorio();">
											</form> 
											
											<a href="imprimir_projeto_inicio.jsp" class="btn" target="_parent">Geral</a> 
											<a href="imprimir_relatorio_colunas.jsp" class="btn" target="_parent">Relatório Específico</a> 
										
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Relatório -->
								
								<!-- Modal ramificação Projeto-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal1" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Ramificação Projeto</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="TkcsapcdController?cmd=consultarProjetoInicioRamificacao" class="btn" target="_parent">Verificar</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal ramificação projeto-->
								
								<!-- Modal calendário evento-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal2" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Calendário Evento</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="calendario.jsp" class="btn" target="_parent">Verificar</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal calendário evento-->
								
								<div class="table-responsive">
									<table id="tabela" cellspacing="5" cellspacing="5" class="display" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Cód. Projeto</th>
												<th>Ger. Portfólio</th>
												<th>Ger. Programas</th>
												<th>Ger. Projeto</th>
												<th>Equipe Ger.</th>
												<th>Ger. Funcional</th>
												<th>Patrocinador</th>
												<th>Fornec/Parc</th>
												<th>Equipe Projeto</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
												<%
													List<TabelaParteInteressada> tabelaParteInteressadas = (List<TabelaParteInteressada>) request.getAttribute("tabelaParteInteressadas");
													for (TabelaParteInteressada tabelaParteInteressada : tabelaParteInteressadas) {
												%>
											<tr>
																		
												<td><%=tabelaParteInteressada.getRegistroParteInteressada().getCodigo()%></td>
												<td><%=tabelaParteInteressada.getNomegrport()%></td>
												<td><%=tabelaParteInteressada.getNomegrprograma()%></td>
												<td><%=tabelaParteInteressada.getNomegrprojeto()%></td>
												<td><%=tabelaParteInteressada.getNomeegprojeto()%></td>
												<td><%=tabelaParteInteressada.getNomegrfuncional()%></td>
												<td><%=tabelaParteInteressada.getNomepatrocinador()%></td>
												<td><%=tabelaParteInteressada.getNomefornecedor()%></td>
												<td><%=tabelaParteInteressada.getNomeequipeproj()%></td>
												<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarTabelaParteInteressada&codigo=<%=tabelaParteInteressada.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
												<td><a class="link_delete"    href='TkcsapcdController?cmd=excluirTabelaParteInteressada&codigo=<%=tabelaParteInteressada.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
                        </div>
                    </div>                   
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

	<%@include file="rodape.jsp" %>
</body>
</html>