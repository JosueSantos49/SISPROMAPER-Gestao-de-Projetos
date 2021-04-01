<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PortfolioProjeto"%>
<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Consultar Portfólio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <style type="text/css">
    /* make sidebar nav vertical */
    
textarea { 
	height:8em; width: 60em; float: left; text-align: left;
	font: 14px "Trebuchet MS", tahoma, arial;
	padding: 5px; 
	border: 1px solid rgba(38,128,101,0.9);
	border-radius:4px;
	width: 650px; 
	color: #797979;	
	
	}
textarea:focus { 
	background-color:#E7E8E7; text-align: left;
}

.hint{display:none;}
	
.field:hover .hint {  
	position: absolute;
	display: block;  
	margin: -30px 0 0 455px;
	color: #FFFFFF;
	padding: 7px 10px;
	background: rgba(0, 0, 0, 0.6);
	
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 7px;	
	}
	
.field{margin-bottom:7px;}

.input{
	font: 14px "Trebuchet MS", tahoma, arial;
	padding: 5px; 
	border: 1px solid rgba(38,128,101,0.9);
	border-radius:4px;
	width: 300px; 
	color: #797979;	
	}
	
	.input:focus{background-color:#E7E8E7;}
	 
        
@media (min-width: 468px){
  .affix-content .container {
    width: 700px;
  }   

  html,body{
    background-color: #f8f8f8;
    height: 100%;
    overflow: hidden;
  }
    .affix-content .container .page-header{
    margin-top: 0;
  }
  .sidebar-nav{
        position:fixed; 
        width:100%;
  }
  .affix-sidebar{
    padding-right:0; 
    font-size:small;
    padding-left: 0;
  }  
  .affix-row, .affix-container, .affix-content{
    height: 100%;
    margin-left: 0;
    margin-right: 0;    
  } 
  .affix-content{
    background-color:white; 
  } 
  .sidebar-nav .navbar .navbar-collapse {
    padding: 0;
    max-height: none;
  }
  .sidebar-nav .navbar{
    border-radius:0; 
    margin-bottom:0; 
    border:0;
  }
  .sidebar-nav .navbar ul {
    float: none;
    display: block;
  }
  .sidebar-nav .navbar li {
    float: none;
    display: block;
  }
  .sidebar-nav .navbar li a {
    padding-top: 12px;
    padding-bottom: 12px;
  }  
}

@media (min-width: 769px){
  .affix-content .container {
    width: 600px;
  }
    .affix-content .container .page-header{
    margin-top: 0;
  }  
}

@media (min-width: 992px){
  .affix-content .container {
  width: 900px;
  }
    .affix-content .container .page-header{
    margin-top: 0;
  }
}

@media (min-width: 1220px){
  .affix-row{
    overflow: hidden;
  }

  .affix-content{
    overflow: auto;
  }

  .affix-content .container {
    width: 1000px;
  }

  .affix-content .container .page-header{
    margin-top: 0;
  }
  .affix-content{
    padding-right: 30px;
    padding-left: 30px;
  }  
  .affix-title{
    border-bottom: 1px solid #ecf0f1; 
    padding-bottom:10px;
  }
  .navbar-nav {
    margin: 0;
  }
  .navbar-collapse{
    padding: 0;
  }
  .sidebar-nav .navbar li a:hover {
    background-color: #428bca;
    color: white;
  }
  .sidebar-nav .navbar li a > .caret {
    margin-top: 8px;
  }  
}

    </style>
    
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereQualidade.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>



<!-- Calendário -->
<script>
	$(function() {
		$("#datainicio").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#datatermino").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataatual").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<!-- Dialogo -->
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			height : 150,
			modal : true,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#datainicio").mask("99/99/9999");
		$("#datatermino").mask("99/99/9999");
		$("#dataatual").mask("99/99/9999");
	});
</script>

<script>
	$(function() {
		$("#").datepicker({//dataProjeto
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<script>
	function show_confirm() {

		var r = confirm("Click em OK, para continuar!");
		if (r == true) {
			alert("Continuando...");
			return true;
		} else {
			alert("Click em OK, para cancelar!");
			location.href = "TkcsapcdController?cmd=consultarPortfolioProjeto";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("codigoprojeto").focus();
	}
</script>


<script src="bootstrap/js/bootstrap.min.js"></script>
    
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
<body>

<div class="row affix-row">

	<%@include file="menuprotfolioprojeto.jsp" %>
	
	<div class="col-sm-9 col-md-10 affix-content">
			
	<div class="page-header">
		<h3><span class="glyphicon glyphicon-th-list"></span> Portfólio de Projetos - <img src="img/prancheta.jpg" height="20px" width="30px"><font color="grenn"> ${mensagem}</font></h3>	
	</div>

	<div class="alert alert-info">
	  	Olá, 
		<%=session.getAttribute("theName")%>
			<%  
			//verifica se a sessao do usuario é válida  
			if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
		%>, seja bem vindo a etapa de consultar portfólio de projeto.
	</div>
				
	
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
								          <h4 class="modal-title">Portfólio de Projeto</h4>
								        </div>
								        <div class="modal-body">
								        
								        	<form 
								        		id="formConsProjeto" 
								        		name="formConsProjeto" 
								        		method="post"
												action="pesquisar_portfolio_projeto.jsp"
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
											
											<a href="imprimir_portfolio_projeto.jsp" class="btn" target="_parent">Geral</a> 
										
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
												
					<table id="tabela" cellspacing="5" cellspacing="5" class="display">
							    <thead>
							        <tr>
							            <th>Código Projeto</th>
							            <th>Prioridade</th>
							            <th>Tipo Projeto</th>
							            <th>Unidade Negócio</th>
							            <th>Analista</th>
							            <th>Gerente</th>
							            <th>Parte Interessada</th>
							            <th>Plano Projeto</th>
							            <th>Declaração Escopo</th>
							            <th>Editar</th>
							            <th>Excluir</th>
							        </tr>
							    </thead>
								<tbody>
									<%
										List<PortfolioProjeto> portfolioProjetos = (List<PortfolioProjeto>) request.getAttribute("portfolioProjetos");
										for (PortfolioProjeto portfolioProjeto : portfolioProjetos) {
									%>
								<tr>
										
									<td><%=portfolioProjeto.getCodigoprojeto()%></td>
									<td><%=portfolioProjeto.getPrioridade()%></td>
									<td><%=portfolioProjeto.getTipoprojeto()%></td>
									<td><%=portfolioProjeto.getUnidadenegocio()%></td>
									<td><%=portfolioProjeto.getAnalista()%></td>
									<td><%=portfolioProjeto.getGerente()%></td>
									<td><%=portfolioProjeto.getParteinteressada()%></td>
									<td><%=portfolioProjeto.getPlanoprojeto()%></td>
									<td><%=portfolioProjeto.getDeclaracaoescopo()%></td>
									<td><a class="link_atualizar" href='TkcsapcdController?cmd=editarPortfolioProjeto&codigo=<%=portfolioProjeto.getCodigo()%>'><img alt="" title="Atualizar" height="20" width="27" src="img/alterar.gif"></a></td>
									<td><a class="link_delete" href='TkcsapcdController?cmd=excluirPortfolioProjeto&codigo=<%=portfolioProjeto.getCodigo()%>'><img alt="" title="Excluir" height="20" width="27" src="img/delete.gif"></a></td>
								</tr>
								<%
									}
								%>
							</tbody>
					</table>					
				</div>		
				    
	<%@ include file="rodape.jsp" %>	
	
	</div>
</div>
</body>
</html>
