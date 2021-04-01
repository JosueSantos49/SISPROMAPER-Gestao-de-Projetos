<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html>

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.Rfq"%>


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

<title>Pedido de Cotação</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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

<!-- datatable 1.10.0 
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" media="screen" href="plugindatatable/css/dataTables.jqueryui.css">		
<script type="text/javascript" src="plugindatatable/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="plugindatatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="plugindatatable/js/dataTables.jqueryui.js"></script>
<!-- / datatable 1.10.0 -->

<script type="text/javascript" src="js/funcoes.js"></script>
<script type="text/javascript" src="js/cidades-estados-1.2-utf8.js"></script><!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->
<script type="text/javascript" src="js/validaPesquisarRelatorio.js"></script>

<!-- Configuração para exibir modal automaticamente 
 <script type="text/javascript">
	  $(document).ready(function () {
		  $('#myModal').modal('show');
	  });
</script>-->

<!-- IMPLMENTA A FUNÇÃO DE LISTA ESTADO E CIDADE -->
<script type="text/javascript">
	window.onDomReady(function() {
		new dgCidadesEstados({
			estado : document.getElementById('estado'),
			cidade : document.getElementById('cidade')
		});
	});
</script>

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
 
<%@include  file="data_hora_formatada.jsp" %>

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
								 você pode executar pedido de cotação de forma fácil e prática. É permitido adicionar até dez (20) itens em cada registro. Outra transação <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong> <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong> 
							</div>
					
				        		<p class="muted"><font color="red">Clique para registrar o pedido!</font></p>           
				            	<button type="button" class="demo btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Registrar Pedido</button>
				            	<a href="TkcsapcdController?cmd=consultarRfq" class="btn">Listar Pedido</a>            
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
								          <h4 class="modal-title">${mensagem}</h4>
								          <h5>Pedido de Cotação</h5>
								        </div>
								        <div class="modal-body">
								        
								       	<div class="table-responsive">
								       
							       		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">
								       	 								       
								       	<input type="hidden" name="cmd" value="cadastrarRfq"></input>								       
									
												<div class="tab-content">
		
													<div class="tab-pane active" id="tab1"><p></p>
														 
														 <div class="container">
															<div class="panel panel-primary">
															  <div class="panel-heading">
															    <h3 class="panel-title">Novo Registro</h3>
															  </div>
															  <div class="panel-body">
															  
															    <table class="table"> <!-- class="table" -->
															    	<tr>
															    		<th>Numero RFQ</th>
															    		<th>Prazo Entrega</th>
															    		<th>Data de emissão</th>
															    	</tr>
															    		<tr>
																			<td><input type="text" value="${rfq.numerorfq}" id="numerorfq" name="numerorfq" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2" required="true" onkeypress="return numbers(event);"/></td>
																			<td><input type="text" value="${rfq.prazoentrega}" id="prazoentrega" name="prazoentrega" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
																			<td><input type="text" value="00/00/0000" id="data" name="data" class="form-control" style="height: 30px; width: 150px" placeholder="xx/xx/xxxx" aria-describedby="basic-addon2" required="true" required="true"/></td>
																		</tr>
																	<tr>
															    		<th>Contato Comercial:</th>
															    		<th>Contato Técnico</th>
															    		<th>Data limite</th>
															    	</tr>
																		<tr>
																			<td><input type="text" value="${rfq.contatocomercial}" id="contatocomercial" name="contatocomercial" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"  /></td>
																			<td><input type="text" value="${rfq.contatotecnico}" id="contatotecnico" name="contatotecnico" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
																			<td><input type="text" value="00/00/0000" id= "datalimite" name="datalimite" class="form-control" style="height: 30px; width: 150px" placeholder="xx/xx/xxxx" aria-describedby="basic-addon2" required="true"/></td>							
																		</tr>
																	<tr>
															    		<th>Termo de pagamento:</th>
															    		<th>Tempo de garantia</th>
															    		<th></th>
															    	</tr>
																		<tr>
																			<td><input type="text" value="${rfq.termopagamento}" id="termopagamento" name="termopagamento" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
																			<td><input type="text" value="${rfq.tempogarantia}" id="tempogarantia" name="tempogarantia" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2" /></td>
																			<td></td>								
																		</tr>
																	<tr>
															    		<th>Outras Condições:</th>
															    		<th></th>
															    		<th></th>
															    	</tr>
															    		<tr>
																			<td>
																				<div class="form-group">
																				  <label for="comment">Descrever:</label>
																				   <textarea id="outracondicao" name="outracondicao" rows="5" cols="50" onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')"></textarea>
																				
																					<h5 align="left">
																						<font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family: Arial;"></span></font>
																					</h5>
																					<h5 align="left">
																						<font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family: Arial;"></span></font>
																					</h5>
																				</div>
																			</td>
																			<td></td>
																			<td></td>
																		</tr>					
																	<tr>
															    		<th>Empresa:</th>
															    		<th>Endereço</th>
															    		<th></th>
															    	</tr>
																		<tr>
																			<td><input type="text" value="${rfq.empresa}" id="empresa" name="empresa" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
																			<td><input type="text" value="${rfq.endereco}" id="endereco" name="endereco" class="form-control" style="height: 30px; width: 379px" placeholder="" aria-describedby="basic-addon2"/></td>
																			<td></td>
																		</tr>
																	<tr>
															    		<th>Estado:</th>
															    		<th>Cidade</th>
															    		<th></th>
															    	</tr>
																		<tr>
																			<td><select id="estado" name="estado" value="${rfq.estado}"></select></td>
																			<td><select id="cidade" name="cidade" value="${rfq.cidade}"></select></td>
																			<td></td>
																		</tr>
																	<tr>
																		<th>E-mail:</th>
															    		<th>Telefone:</th>
															    		<th></th>					    		
															    	</tr>
																		<tr>
																			<td><input type="text" class="form-control" style="height: 30px; width: 379px" name="para" autocomplete="off" placeholder="E-mail" /></td>
																			<td><input type="text" value="${rfq.telefone}" id="telefone" name="telefone" class="form-control" style="height: 30px; width: 150px" placeholder="" aria-describedby="basic-addon2"/></td>
																			<td></td>									
																		</tr>
																		
																	</table>
																</div>
															</div>				      
													    </div><!-- /.container -->
													</div>
												</div>
											
												<div class="container">
								        		<!-- 20 linhas com codigoitem, decricao, qtd, puitem.  -->
												<table id="tabela" cellspacing="5" cellspacing="5" class="table">
													<thead>
														<tr class="success">
															<th>Item</th>
															<th>Descrição</th>
															<th>Quantidade</th>
															<th>Preço Unitário</th>
														</tr>
													</thead>
													<tbody>
														<!-- 1 linha -->
														<tr class="">		
															<td>
																<input type="text" value="0" id="codigoitem1" name="codigoitem1" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>		
															<td>
																<input type="text" value="Sem valor!" id="descricao1" name="descricao1" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd1" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem1" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>
														</tr>	
														<!-- fim 1 linha -->	
														
														<!-- 2 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem2" name="codigoitem2" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>
															</td>	
																
															<td>
																<input type="text" value="Sem valor!" id="descricao2" name="descricao2" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd2" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem2" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>
														</tr>
														<!-- fim 2 linha -->	
														
														<!-- 3 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem3" name="codigoitem3" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao3" name="descricao3" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd3" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem3" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 3 linha -->
														
														<!-- 4 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem4" name="codigoitem4" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao4" name="descricao4" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd4" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem4" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 4 linha -->
														
														<!-- 5 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem5" name="codigoitem5" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao5" name="descricao5" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd5" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem5" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 5 linha -->
														
														<!-- 6 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem6" name="codigoitem6" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao6" name="descricao6" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd6" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem6" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 6 linha -->
														
														<!-- 7 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem7" name="codigoitem7" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao7" name="descricao7" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd7" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem7" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 7 linha -->
														
														<!-- 8 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem8" name="codigoitem8" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao8" name="descricao8" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd8" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem8" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 8 linha -->
														
														<!-- 9 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem9" name="codigoitem9" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao9" name="descricao9" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd9" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem9" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 9 linha -->
														
														<!-- 10 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem10" name="codigoitem10" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao10" name="descricao10" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd10" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem10" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 10 linha -->
														
														<!-- 11 linha -->
														<tr>		
															<td>
																<input type="text" id="codigoitem11" name="codigoitem11" size="1" class="form-control"  value="0" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text"  id="descricao11" name="descricao11" size="1" class="form-control" value="Sem valor!" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text"  name="qtd11" size="1" class="form-control" value="0" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text"  name="puitem11" size="1" class="form-control" value="0" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 11 linha -->
														
														<!-- 12 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem12" name="codigoitem12" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao12" name="descricao12" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd12" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem12" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 12 linha -->
														
														<!-- 13 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem13" name="codigoitem13" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao13" name="descricao13" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd13" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem13" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 13 linha -->
														
														<!-- 14 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem14" name="codigoitem14" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao14" name="descricao14" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd14" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem14" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 14 linha -->
														
														<!-- 15 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem15" name="codigoitem15" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao15" name="descricao15" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd15" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem15" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 15 linha -->
														
														<!-- 16 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem16" name="codigoitem16" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao16" name="descricao16" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd16" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem16" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 16 linha -->
														
														<!-- 17 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem17" name="codigoitem17" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao17" name="descricao17" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd17" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem17" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 17 linha -->
														
														<!-- 18 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem18" name="codigoitem18" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao18" name="descricao18" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd18" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem18" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 18 linha -->
														
														<!-- 19 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem19" name="codigoitem19" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao19" name="descricao19" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd19" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem19" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 19 linha -->
														
														<!-- 20 linha -->
														<tr>		
															<td>
																<input type="text" value="0" id="codigoitem20" name="codigoitem20" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
																	
															<td>
																<input type="text" value="Sem valor!" id="descricao20" name="descricao20" size="1" class="form-control" style="height: 30px; width: 200px"/>
															</td>
															
															<td>																
																<input type="text" value="0" name="qtd20" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 200px"/>	
															</td>
															
															<td>
																<input type="text" value="0" name="puitem20" size="1" class="form-control" onkeypress="return numbers(event);" style="height: 30px; width: 150px"/>
															</td>															
														</tr>
														<!-- fim 20 linha -->
														
													</tbody>
												</table>
												</div>
												<br>
													<div class="container">
													Frete: <input type="text" value="0" id="frete" name="frete" size="1" class="form-control" style="height: 30px; width: 150px" onkeypress="return numbers(event);"/>
													</div>
												<div class="modal-footer">		
													<input type="submit" value="Enviar" class="btn btn-default">						        	
										          	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
										        </div>
												</form>												
											</div>
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