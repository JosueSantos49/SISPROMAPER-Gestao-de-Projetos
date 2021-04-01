<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoInicio"%>

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

<title>Listar Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="bootstrap/teste/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="bootstrap/css/filter.css">

<script>
function myFunction() {
    // Declare variables
    var input, filter, ul, li, a, i;
    
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("demo");
    li = ul.getElementsByTagName('li');
    
    // Percorrer todos os itens da lista e ocultar os que não correspondem à consulta de pesquisa
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
</script>

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
		                                <i class="fa fa-table"></i><font color="red">lista Projetos</font>
		                            </li>
		                        </ol>
		                    </div>
		                </div>
		                <!-- /.row -->     
					  
                <div class="row">
                    <div class="col-lg-15">
                        <h2></h2>
                        <div class="table-responsive"> 
                        		
                        		<!-- Trigger the modal with a button -->                        		                        					
								<button type="button" class="glyphicon glyphicon-folder-open" data-toggle="modal" title="Relatório" data-target="#myModal"></button>
								<button type="button" class="glyphicon glyphicon-fullscreen" data-toggle="modal" title="Ramificação Projeto" data-target="#myModal1"></button>
								<button type="button" class="glyphicon glyphicon-calendar" data-toggle="modal" title="Calendário Evento" data-target="#myModal2"></button>
								<button type="button" class="glyphicon glyphicon-list-alt" data-toggle="modal" title="Transação" data-target="#myModal3"></button>  
								<button type="button" class="glyphicon glyphicon-paperclip" data-toggle="modal" title="Upload e Download de Arquivos (Projeto)" data-target="#myModal4"></button> 
								<button type="button" class="glyphicon glyphicon-sound-dolby" data-toggle="modal" title="Organograma" data-target="#myModal5"></button>
								<button type="button" class="glyphicon glyphicon-menu-hamburger" data-toggle="modal" title="Organograma Propriedade" data-target="#myModal6"></button> 
								<button type="button" class="glyphicon glyphicon-envelope" data-toggle="modal" title="E-mail" data-target="#myModal7"></button> 
                        		<button type="button" class="glyphicon glyphicon-question-sign" data-toggle="modal" title="Ajuda" data-target="#myModal8"></button>
                        		<button type="button" class="glyphicon glyphicon-zoom-in" data-toggle="modal" title="Buscar transação" data-target="#myModal9"></button>
                        		
                        		<a href="pages/eventoCalendario.xhtml"><img alt="" title="Evento Calendário" height="20" width="27" src="img/calendar.gif"></a>
                        		<a href="pages/eventoCalendario2.xhtml"><img alt="" title="Excluir Evento do Calendário" height="20" width="27" src="img/excluir.png"></a>
								<a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>
								<a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
															 
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
												action="pesquisar_projeto_inicio.jsp"
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
								
								<!-- Modal menu-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal3" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Transação</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="menu_icon_geral.jsp" class="btn" target="_parent">Verificar</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal menu-->
								
								<!-- Modal Upload de Arquivos-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal4" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Upload e Download de Arquivos (Projeto)</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="upload_projeto.jsp" class="btn" target="_parent">Upload Arquivo (Projeto)</a>
								        </div>
								        <div class="modal-body">								        
								        	<a href="TkcsapcdController?cmd=consultarFilebeanProjeto">Consultar Upload (Projeto)</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Upload de Arquivos-->
								
								<!-- Modal Organograma-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal5" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Organograma</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="cadastro_organograma.jsp">Cadastrar Organograma</a>
								        </div>
								        <div class="modal-body">								        
								        	<a href="TkcsapcdController?cmd=consultarOrganograma">Consultar Organograma</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Organograma-->
								
								<!-- Modal Organograma Propriedade-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal6" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Organograma Propriedade</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="cadastro_organograma_propriedade.jsp">Cadastrar Organograma Propriedade</a>
								        </div>
								        <div class="modal-body">								        
								        	<a href="TkcsapcdController?cmd=consultarOrganogramaPropriedade">Consultar Organograma Propriedade</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Organograma Propriedade-->
								
								<!-- Modal E-mail-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal7" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Enviar E-mail</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="envia.jsp">E-mail</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal E-mail-->
								
								<!-- Modal Ajuda-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal8" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Ajuda!</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="menu_sugerido_ajuda.jsp">Verificar</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Ajuda-->
								
								<!-- Modal Ajuda-->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal9" role="dialog">
								    <div class="modal-dialog modal-sm">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Buscar Transação!</h4>
								        </div>
								        <div class="modal-body">								        
								        	<a href="consulta_transacao.jsp">Verificar</a>
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Ajuda-->
																
								<div class="table-responsive">
									<table id="tabela" cellspacing="5" cellspacing="5" class="display" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Registro</th>
												<th>Código Projeto</th>
												<th>Projeto</th>
												<th>Data</th>
												<th>Atribui Projeto</th>
												<th>Tipo Projeto</th>
												<th>Cliente</th>
												<th>Programa</th>
												<th>Área</th>
												<th>Roi</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
												<%
													List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
													for (ProjetoInicio projetoInicio : projetoInicios) {
												%>
											<tr>
												<td><%=projetoInicio.getCodigo() %></td>						
												<td><%=projetoInicio.getCodigoprojeto()%></td>
												<td><%=projetoInicio.getProjeto()%></td>
												<td><%=projetoInicio.getData()%></td>
												<td><%=projetoInicio.getAtribuiprojeto()%></td>
												<td><%=projetoInicio.getTipoprojeto()%></td>
												<td><%=projetoInicio.getCliente()%></td>
												<td><%=projetoInicio.getPrograma()%></td>
												<td><%=projetoInicio.getArea()%></td>
												<td><%=projetoInicio.getRoi()%></td>
												<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarProjetoInicio&codigo=<%=projetoInicio.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
												<td><a class="link_delete"    href='TkcsapcdController?cmd=excluirProjetoInicio&codigo=<%=projetoInicio.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
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