<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio"%>
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

<title>Listar Pessoas Envolvidas no Projeto</title>

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
	$('#tabela2').dataTable();
	$('#tabela3').dataTable();
	$('#tabela4').dataTable();
	$('#tabela5').dataTable();
	$('#tabela6').dataTable();
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
								esta etapa permite listar pessoas envolvidas no projeto. Através do menu superior a esquerda, você pode executar outras transações. Fique atento você pode criar EAP. Outra transação <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong> 
							</div>
							
		                        <h4 class="page-header">${mensagem}</h4>
		                        <ol class="breadcrumb">
		                            <li>
		                                <i class="fa fa-dashboard"></i>  <a href="sair.jsp">logout</a>
		                            </li>
		                            <li class="active">
		                                <i class="fa fa-table"></i><font color="red">lista Pessoas Envolvidas no Projetos</font>
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
								
								<!-- Table 1 -->
								<div class="table-responsive">
									<table id="tabela" cellspacing="5" cellspacing="5" class="display" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Código Projeto 1</th>
												<th>Organização 1</th>
												<th>RH 1</th>
												<th>Tipo RH 1</th>
												<th>Período 1</th>
												<th>Esforço 1</th>
												
												<th>Código Projeto 2</th>
												<th>Organização 2</th>
												<th>RH 2</th>
												<th>Tipo RH 2</th>
												<th>Período 2</th>
												<th>Esforço 2</th>
												
												<th>Código Projeto 3</th>
												<th>Organização 3</th>
												<th>RH 3</th>
												<th>Tipo RH 3</th>
												<th>Período 3</th>
												<th>Esforço 3</th>
												
												<th>Código Projeto 4</th>
												<th>Organização 4</th>
												<th>RH 4</th>
												<th>Tipo RH 4</th>
												<th>Período 4</th>
												<th>Esforço 4</th>
												
												<th>Código Projeto 5</th>
												<th>Organização 5</th>
												<th>RH 5</th>
												<th>Tipo RH 5</th>
												<th>Período 5</th>
												<th>Esforço 5</th>
												
												<th>Código Projeto 6</th>
												<th>Organização 6</th>
												<th>RH 6</th>
												<th>Tipo RH 6</th>
												<th>Período 6</th>
												<th>Esforço 6</th>
												
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
												<%
													List<EnvolvimentoPessoaProjetoInicio> envolvimentoPessoaProjetoInicios = (List<EnvolvimentoPessoaProjetoInicio>) request.getAttribute("envolvimentoPessoaProjetoInicios");
													for (EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio : envolvimentoPessoaProjetoInicios) {
												%>
											<tr>
																		
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto1()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao1()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh1()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh1()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo1()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco1()%></td>
												
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto2()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao2()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh2()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh2()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo2()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco2()%></td>
												
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto3()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao3()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh3()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh3()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo3()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco3()%></td>
												
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto4()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao4()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh4()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh4()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo4()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco4()%></td>
																		
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto5()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao5()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh5()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh5()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo5()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco5()%></td>
																		
												<td><%=envolvimentoPessoaProjetoInicio.getCodigoprojeto6()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getOrganizacao6()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getRh6()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getTiporh6()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getPeriodo6()%></td>
												<td><%=envolvimentoPessoaProjetoInicio.getEsforco6()%></td>
												<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarEnvolvimentoPessoaProjetoInicio&codigo=<%=envolvimentoPessoaProjetoInicio.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
												<td><a class="link_delete"    href='TkcsapcdController?cmd=excluirEnvolvimentoPessoaProjetoInicio&codigo=<%=envolvimentoPessoaProjetoInicio.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>								
								<!-- fim Table 1 -->
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