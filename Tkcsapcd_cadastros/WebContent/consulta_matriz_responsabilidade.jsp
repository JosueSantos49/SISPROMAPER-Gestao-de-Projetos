<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.MatrizResponsabilidade"%>
<%@page import="br.com.tkcsapcd.model.bean.MatrizResponsabilidade"%>
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

<title>Listar Matriz de Responsabilidade</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="bootstrap/teste/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script><!-- Modal Relatório -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script><!-- Modal Relatório -->

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

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index_principal.jsp">SISPROMAPER</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li> -->
                <!-- 
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li> -->
                <li class="dropdown">
                    <a href="index_principal.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><b class="caret"></b></a>
                    <!-- <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                    </ul> -->
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Termo de Abertura do Projeto <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarProjeto">Novo Termo</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=consultarProjeto">Listar Termo</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo1"><i class="fa fa-fw fa-arrows-v"></i> Lista de Partes Interessadas <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo1" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarRegistroParteInteressada">Novo Partes Interessadas</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=consultarRegistroParteInteressada">Listar Partes Interessadas</a>
                            </li>
                        </ul>
                    </li>
                    <li class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2"><i class="fa fa-fw fa-arrows-v"></i> Projeto <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                            <li>
                                <a href="menu_sugerido_principal.jsp">Novo Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=consultarProjetoInicio">Listar Projeto</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=editarEnvolvimentoPessoaProjetoInicio">Envolver Pessoa</a>
                            </li>
                             <li>
                                <a href="TkcsapcdController?cmd=consultarEnvolvimentoPessoaProjetoInicio">Listar Pessoa Envolvida</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo3"><i class="fa fa-fw fa-arrows-v"></i> Listar os Requisitos <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo3" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarBusinessPlanDetalhe">Novo Lista</a>
                            </li>
                            <li>
                                <a href="TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito">Listar Requisitos</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo4"><i class="fa fa-fw fa-arrows-v"></i> Plano de Projeto <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo4" class="collapse">
                            <li>
                                <a href="TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto">Novo Plano de Projeto</a>
                            </li>
                            <li>
                                <a href="#">Listar Plano de Projeto</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo5"><i class="fa fa-fw fa-arrows-v"></i> Estrutura Analítica do Projeto <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo5" class="collapse">
                            <li>
                                <a href="cadastro_organograma.jsp">Novo EAP</a>
                            </li>
                            <li>
                                <a href="consulta_organograma.jsp">Listar EAP</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h4 class="page-header">${mensagem}</h4>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="sair.jsp">logout</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i><font color="red">lista Matriz</font>
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
												action="pesquisar_matriz_responsabilidade.jsp"
												onSubmit="return validaPesquisarRelatorio(this)">
							
												<strong>Relatório..:</strong> <input name="consProjeto" type="text"
													id="consProjeto"
													title="Digite o Código do Projeto para exibir o relatório."
													required="true" Placeholder="Código do EAP!"> <input
													class="button" name="pesqProjeto" type="submit" id="pesqProjeto"
													value="Exibir"
													title="Digite o Código da EAP para exibir o relatório."
													onclick="validaPesquisarRelatorio();">
											</form> 
											
											<a href="imprimir_projeto_inicio.jsp" class="btn" target="_parent">Geral</a> 
										
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
								
								<div class="table-responsive">
									<table id="tabela" cellspacing="5" cellspacing="5" class="display" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Código da EAP</th>
												<th>Responsável (Responsible)</th>
												<th>Aprovar (Accountable)</th>
												<th>Consultado (Consulted)</th>
												<th>Informado (Informed)</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
												<%
													List<MatrizResponsabilidade> matrizResponsabilidades = (List<MatrizResponsabilidade>) request.getAttribute("matrizResponsabilidades");
													for (MatrizResponsabilidade matrizResponsabilidade : matrizResponsabilidades) {
												%>
											<tr>
																		
												<td><%=matrizResponsabilidade.getCodigoeap()%></td>
												<td><%=matrizResponsabilidade.getResponsavel()%></td>
												<td><%=matrizResponsabilidade.getAprovar()%></td>
												<td><%=matrizResponsabilidade.getConsultado()%></td>
												<td><%=matrizResponsabilidade.getInformado()%></td>
												<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarMatrizResponsabilidade&codigo=<%=matrizResponsabilidade.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
												<td><a class="link_delete"    href='TkcsapcdController?cmd=excluirMatrizResponsabilidade&codigo=<%=matrizResponsabilidade.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
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