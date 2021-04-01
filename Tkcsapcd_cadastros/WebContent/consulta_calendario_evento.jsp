<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.CalendarioEvento"%>

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

<title>Consultar Calendário Evento</title>

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

<!-- Configuração para exibir modal automaticamente 
 <script type="text/javascript">
	  $(document).ready(function () {
		  $('#myModal').modal('show');
	  });
</script>-->

<script type="text/javascript">
$(document).ready(function(){
	$('#tabela').dataTable();
});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#periodo1").mask("99/99/9999");
	});
</script >

<!-- Calendário -->
<script>
	$(function() {
		$("#periodo1").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<script src="excellentexport-master/excellentexport.js"></script>

<style>
table,tr,td {
	border: 0px black solid;
}
</style>
<style>      
  .text-center { 
    text-align: center; 
  }

  .marketing h1 {
    font-size: 50px;
    font-weight: lighter;
    line-height: 1;
  }

  .marketing p {
    font-size: 18px;
  }  
 </style>
 
 <%
//Implementando Data e Hora
Date data = new Date();//criando objeto tipo Date e inicializando 
SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");//Mascara para a data yyyy/MM/dd
String mostra_data = data_formatada.format(data); //Variável para armazenar a data

SimpleDateFormat hora_formatada = new SimpleDateFormat("HH:mm");//Mascara para a hora
String mostra_hora = hora_formatada.format(data); //Variável para armazenar a hora(aproveitando o mesmo objeto data)
 %>
</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<div id="preloader">
		<h1>
			<img src="img/ajax-loaderazul.gif" height="30px">
		</h1>
	</div>
<%@include file="menuperantecssadm.jsp"%>
 
<br><br>
		<div align="justify">			
			  <div class="page-container">
				    <div class="container" style="position: relative">      
				      <div class="row">
				        <div class="col-md-10">                             
				          <div class="ajax" style="position: relative; overflow: hidden">            
				            <div class="marketing">
				            
				             <div class="alert alert-success">
				             <strong>Data:</strong> <%=mostra_data %> - <strong> Hora:</strong> <%=mostra_hora %><br><br>
							Olá, 
								<%=session.getAttribute("theName")%>
									<%  
									//verifica se a sessao do usuario é válida  
									if(session.getAttribute("theName")==null) {request.getRequestDispatcher("testelogin.jsp").forward(request, response); 	}  
								%>
								 você pode envolver pessoas em eventos de forma fácil e prática. É permitido adicionar participantes no ato do registro.<br>Para executar outra transação <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong> <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong> 
							</div>
					
				        		<p class="muted"><font color="red">Clique para listar evento!</font></p>           
				            	<button type="button" class="demo btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Listar Evento</button>
				            	<a href="calendario.jsp" class="btn">Registrar Evento</a>            
				            </div>
				          </div>
				          <br/>          
				        </div>
				      </div>
				    </div>
					<div id="ajax-modal" class="modal fade" tabindex="-1" style="display: none;"></div>
					</div>
					
					<br>				
							<!-- Modal Relatório -->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-lg">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h5 class="modal-title">${mensagem}<br>
								          </h5>
								          <br>						          
								          <h5>Consultar Evento</h5>
								        </div>
								        <div class="modal-body">
								        								        
								        <div class="table-responsive">
								        <a download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');"><img alt="" title="Export to Excel" height="20" width="27" src="img/xls.jpg"></a>								        
								        <a download="somedata.csv" href="#" onclick="return ExcellentExport.csv(this, 'tabela');"><img alt="" title="Export to Excel" height="20" width="27" src="img/csv.jpg"></a>
											<table id="tabela" cellspacing="5" cellspacing="5" class="display">
												<thead>
													<tr>
														<th>Código Projeto</th>
														<th>Data</th>
														<th>Iniciar</th>
														<th>Duração</th>
														<th>Local</th>
														<th>Assunto</th>
														<th>Responsável</th>
														<th>Frquência</th>
														<th>Editar</th>
														<th>Excluir</th>
													</tr>
												</thead>
												<tbody>
														<%
															List<CalendarioEvento> calendarioEventos = (List<CalendarioEvento>) request.getAttribute("calendarioEventos");
															for (CalendarioEvento calendarioEvento : calendarioEventos) {
														%>
													<tr>							
														<td><%=calendarioEvento.getCodigoprojeto()%></td>
														<td><%=calendarioEvento.getData()%></td>
														<td><%=calendarioEvento.getIniciar()%></td>
														<td><%=calendarioEvento.getDuracao()%></td>
														<td><%=calendarioEvento.getLocal()%></td>
														<td><%=calendarioEvento.getAssunto()%></td>
														<td><%=calendarioEvento.getResponsavel()%></td>
														<td><%=calendarioEvento.getFrequencia()%></td>
														<td><a class="link_atualizar"
															href='TkcsapcdController?cmd=editarCalendarioEvento&codigo=<%=calendarioEvento.getCodigo()%>'><img
																alt="" title="Atualizar" height="20" width="27"
																src="img/alterar.gif"></a></td>
														<td><a class="link_delete"
															href='TkcsapcdController?cmd=excluirCalendarioEvento&codigo=<%=calendarioEvento.getCodigo()%>'><img
																alt="" title="Excluir" height="20" width="27"
																src="img/delete.gif"></a></td>
													</tr>
													<%
														}
													%>
												</tbody>
											</table>
										</div>								       
												
												<div class="modal-footer">							        	
										          	<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
										        </div>
								      </div>
								    </div>
								  </div>
								</div>
								<!-- Fim Modal Relatório -->	
				</div>
	<%@include file="rodape.jsp" %>
</body>
</html>