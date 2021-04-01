<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import = "java.text.SimpleDateFormat" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FornecedorQualificado"%>

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

<title>Registrar Fornecedor Qualificado</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.2-utf8.js"></script><!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->
<script language="javascript" src="js/TexteareCadastroFornecedorQualificado.js"></script>

<!-- IMPLMENTA A FUNÇÃO DE LISTA ESTADO E CIDADE -->
<script type="text/javascript">
	window.onDomReady(function() {
		new dgCidadesEstados({
			estado : document.getElementById('estado'),
			cidade : document.getElementById('cidade')
		});
	});
</script>

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
								 você pode registrar fornecedor qualificado de forma fácil e prática. <strong><a href="consulta_transacao.jsp" target="_parent">Clique aqui!</a></strong> <strong><a href="modal_informativo.jsp" target="_parent">Dica!</a></strong> 
							</div>
					
				        		<p class="muted"><font color="red">Clique para registrar fornecedor qualificado!</font></p>           
				            	<button type="button" class="demo btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Registrar Fornecedor</button>
				            	<a href="TkcsapcdController?cmd=consultarFornecedorQualificado" class="btn">Listar Registro</a>            
				            </div>
				          </div>
				          <br/>          
				        </div>
				      </div>
				    </div>
					<div id="ajax-modal" class="modal fade" tabindex="-1" style="display: none;"></div>
					</div>
									
							<!-- Modal Relatório -->
								<div class="container">							
								  <!-- Modal -->
								  <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog modal-lg">
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h5 class="modal-title"><font color="green"> ${mensagem}</font></h5>
								        </div>
								        <div class="modal-body">
								        
								       <div class="table-responsive">
								        
								  <form action="TkcsapcdController" id="formulario">
								       
								       <input type="hidden" name="cmd" value="cadastrarFornecedorQualificado"></input>
								        
								        			<fieldset>
														<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">FORNECEDOR QUALIFICADO</font></th></tr></table><br>				
														
														<!-- Modal explicando o objetivo da transação -->
														<div class="bs-example">
														    <div class="alert alert-info fade in">
														        <a href="#" class="close" data-dismiss="alert">&times;</a>
														        <strong>Nota!</strong> 
														    </div>
														    
														    <!-- Button HTML (to Trigger Modal) 
														    <input type="button" data-toggle="modal" data-target="#myModal2" class="btn btn-lg btn-primary" value="Clique aqui!">-->
														    
														    <!-- Modal HTML -->
														    <div id="myModal2" class="modal fade">
														        <div class="modal-dialog">
														            <div class="modal-content">
														                <div class="modal-header">
														                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														                    <h2 class="modal-title">Fornecedor Qualificado</h2>
														                </div>
														                <div class="modal-body">
														                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
														                    <div class="lots-of-text" align="left">
														                    
														                    	<!-- Descrição -->
														                    	
														                    </div>
														                </div>
														                <div class="modal-footer">
														                    <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
														                </div>
														            </div>
														        </div>
														    </div>
														</div>
														<!-- Fim Modal explicando o objetivo da transação -->
														
														<br>														
														<div id="dialog">
															<p>
																<font color="red"> Campo (*) obrigatório.<br></font>
															</p>
															<br>
														</div>
														<br> 
														<input type="hidden" name="cmd" value="cadastrarFornecedorQualificado"></input>
														<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
															<tr>
																<td>
																	<p>
																		<font color="red">Campos de (*) obrigatório.</font>
																	</p>
																	<br></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify"><b>Razão Social / Nome <font color="red">*</font></b></p>
																<p align="justify">
																		<input id="razaosocial" name="razaosocial" required="true"
																			style="height: 30px; width: 379px" maxlength="150"
																			class="input" ></input>
																	<p class="hint">[Informar Razão Social / Nome]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Telefone <font color="red">*</font></b></p>
																<p align="justify">
																		<input id="telefone" name="telefone"
																			style="height: 30px; width: 150px"
																			Placeholder=""
																			class="input" 
																			onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o telefone.]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Fax <font color="red">*</font></b></p>
																<p align="justify">
																		
																		<input id="fax" name="fax"
																			style="height: 30px; width: 150px"
																			Placeholder="" maxlength="10"
																			class="input" 
																			onkeypress="return numbers(event);"></input>
																	
																	<p class="hint">[Informar o fax]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Endereço <font color="red">*</font></b>
																<p align="justify">
																		<input id="endereco" name="endereco"
																			style="height: 30px; width: 379px"
																			class="input" ></input>
																	<p class="hint">[Informar o endereço.]</p>
															</tr>															
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Bairro <font color="red">*</font></b></p>
																<p align="justify">
																		<input id="bairro" name="bairro"
																			style="height: 30px; width: 379px"
																			Placeholder="" 
																			class="input" 
																			onkeypress="return Letras(event);"></input>
																	<p class="hint">[Informar o bairro]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Estado <font color="red">*</font></b></p>
																<p align="justify">
																		<select id="estado" name="estado"></select>
																	<p class="hint">[Informar estado]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Cidade <font color="red">*</font></b></p>
																<p align="justify">
																		<select id="cidade" name="cidade"></select>
																	<p class="hint">[Informar cidade]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Cep <font color="red">*</font></b>
																<p align="justify">
																		<input id="cep" name="cep"
																			style="height: 30px; width: 100px"
																			class="input" 
																			onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o cep.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>CNPJ <font color="red">*</font></b>
																<p align="justify">
																		<input id="cnpj" name="cnpj" required="true"
																			style="height: 30px; width: 150px"
																			class="input" 
																			onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o CNPJ.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Insc. Estadual<font color="red">*</font></b></p>
																<p align="justify">
																		<input id="inscricaoestadual" name="inscricaoestadual"
																			style="height: 30px; width: 379px"
																			Placeholder=""
																			class="input" ></input>
																	<p class="hint">[Informar Insc. Estadual]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Insc. Municipal <font color="red">*</font></b></p>
																<p align="justify">
																		<input id="inscricaomunicipal" name="inscricaomunicipal"
																			style="height: 30px; width: 379px"
																			Placeholder=""
																			class="input" ></input>
																	<p class="hint">[Informar Insc. Municipal]</p></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Contato <font color="red">*</font></b>
																<p align="justify">
																		<input id="contato" name="contato"
																			style="height: 30px; width: 379px"
																			class="input" ></input>
																	<p class="hint">[Informar o Contato]</p>
															</tr>	
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Nome Fantasia <font color="red">*</font></b>
																<p align="justify">
																		<input id="nomefantasia" name="nomefantasia"
																			style="height: 30px; width: 379px"
																			class="input" ></input>
																	<p class="hint">[Informar o Nome Fantasia]</p>
															</tr>	
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Celular <font color="red">*</font></b>
																<p align="justify">
																		<input id="celular" name="celular"
																			style="height: 30px; width: 150px"
																			class="input" onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o Celular.]</p>
															</tr>	
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>E-mail <font color="red">*</font></b>
																<p align="justify">
																		<input id="email" name="email"
																			style="height: 30px; width: 379px"
																			class="input" ></input>
																	<p class="hint">[Informar o E-mail.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Site <font color="red">*</font></b>
																<p align="justify">
																		<input id="homepage" name="homepage"
																			style="height: 30px; width: 379px"
																			class="input" ></input>
																	<p class="hint">[Informar o Site.]</p>
															</tr>															
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Principais Produtos e/ou Serviços <font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="produtos" name="produtos" 
																		onkeyup="mostrarResultadoEtapa1(this.value,600,'spcontando0');contarCaracteresEtapa1(this.value,600,'sprestante0')"></textarea>
																	<p class="hint">[Principais Produtos e/ou Serviços]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando0"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante0"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Marcas Representadas / Comercializadas  <font color="red">*</font></b>
																<p align="justify">
																	<font color="blue"></font>
																	</p> <textarea id="marcas" name="marcas" 
																		onkeyup="mostrarResultadoEtapa2(this.value,600,'spcontando');contarCaracteresEtapa2(this.value,600,'sprestante')"></textarea>
																	<p class="hint">[Marcas Representadas / Comercializadas]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Contrato Social e/ou Alteração Contratual <font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="contratosocial" name="contratosocial" 
																		onkeyup="mostrarResultadoEtapa3(this.value,600,'spcontando1');contarCaracteresEtapa3(this.value,600,'sprestante1')"></textarea>
																	<p class="hint">[Contrato Social e/ou Alteração Contratual]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando1"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante1"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Banco <font color="red">*</font></b>
																<p align="justify">
																		<input id="banco" name="banco"
																			style="height: 30px; width: 150px"
																			class="input" onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o Celular.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Agência  <font color="red">*</font></b>
																<p align="justify">
																		<input id="agencia" name="agencia"
																			style="height: 30px; width: 150px"
																			class="input" onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o Celular.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Nº Conta Corrente  <font color="red">*</font></b>
																<p align="justify">
																		<input id="conta" name="conta"
																			style="height: 30px; width: 150px"
																			class="input" onkeypress="return numbers(event);"></input>
																	<p class="hint">[Informar o Celular.]</p>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Cartão de CNPJ e Insc. Estadual  <font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="cartaocnpj" name="cartaocnpj" 
																		onkeyup="mostrarResultadoEtapa4(this.value,600,'spcontando2');contarCaracteresEtapa4(this.value,600,'sprestante2')"></textarea>
																	<p class="hint">[Cartão de CNPJ e Insc. Estadual ]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando2"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante2"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Regularidade com a Fazenda Federal (CCN) <font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="fazendafederal" name="fazendafederal" 
																		onkeyup="mostrarResultadoEtapa5(this.value,600,'spcontando3');contarCaracteresEtapa5(this.value,600,'sprestante3')"></textarea>
																	<p class="hint">[Regularidade com a Fazenda Federal (CCN)]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando3"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante3"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Regularidade com a Fazenda Estadual (CND)<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="fazendaestadual" name="fazendaestadual" 
																		onkeyup="mostrarResultadoEtapa6(this.value,600,'spcontando4');contarCaracteresEtapa6(this.value,600,'sprestante4')"></textarea>
																	<p class="hint">[Regularidade com a Fazenda Estadual (CND)]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando4"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante4"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Regularidade com a Fazenda Municipal (CND)<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="fazendamunicipal" name="fazendamunicipal" 
																		onkeyup="mostrarResultadoEtapa7(this.value,600,'spcontando5');contarCaracteresEtapa7(this.value,600,'sprestante5')"></textarea>
																	<p class="hint">[Regularidade com a Fazenda Municipal (CND)]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando5"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante5"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Regularidade com INSS ( CND )<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="inss" name="inss" 
																		onkeyup="mostrarResultadoEtapa8(this.value,600,'spcontando6');contarCaracteresEtapa8(this.value,600,'sprestante6')"></textarea>
																	<p class="hint">[Regularidade com INSS ( CND )]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando6"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante6"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Regularidade com FGTS ( CRS )<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="fgts" name="fgts" 
																		onkeyup="mostrarResultadoEtapa9(this.value,600,'spcontando7');contarCaracteresEtapa9(this.value,600,'sprestante7')"></textarea>
																	<p class="hint">[Regularidade com FGTS ( CRS )]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando7"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante7"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Atestado de Capacidade Técnica<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="capacidadetecnica" name="capacidadetecnica" 
																		onkeyup="mostrarResultadoEtapa10(this.value,600,'spcontando8');contarCaracteresEtapa10(this.value,600,'sprestante8')"></textarea>
																	<p class="hint">[Atestado de Capacidade Técnica]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando8"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante8"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Relação de Clientes<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="relacaocliente" name="relacaocliente" 
																		onkeyup="mostrarResultadoEtapa11(this.value,600,'spcontando9');contarCaracteresEtapa11(this.value,600,'sprestante9')"></textarea>
																	<p class="hint">[Relação de Clientes]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando9"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante9"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Referências Comerciais<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="referenciacomenrcail" name="referenciacomenrcail" 
																		onkeyup="mostrarResultadoEtapa12(this.value,600,'spcontando10');contarCaracteresEtapa12(this.value,600,'sprestante10')"></textarea>
																	<p class="hint">[Referências Comerciais]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando10"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante10"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Registro na entidade profissional competente<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="registro" name="registro" 
																		onkeyup="mostrarResultadoEtapa16(this.value,600,'spcontando14');contarCaracteresEtapa16(this.value,600,'sprestante14')"></textarea>
																	<p class="hint">[Registro na entidade profissional competente]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando14"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante14"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Certidão Negativa de Falência ou Recuperação Judicial<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="certidaonegativa" name="certidaonegativa" 
																		onkeyup="mostrarResultadoEtapa17(this.value,600,'spcontando15');contarCaracteresEtapa17(this.value,600,'sprestante15')"></textarea>
																	<p class="hint">[Certidão Negativa de Falência ou Recuperação Judicial]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando15"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante15"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<!-- 
															<tr class="field">
																<td><p align="justify">
																		<b>4.2	Procedimentos de Monitoramento<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="procedimentomonitoramento" name="procedimentomonitoramento" 
																		onkeyup="mostrarResultadoEtapa18(this.value,600,'spcontando16');contarCaracteresEtapa18(this.value,600,'sprestante16')"></textarea>
																	<p class="hint">[Use as Métricas da Qualidade para indicar quais indicadores serão monitorados, como, em qual frequência. Para atingir os requisitos de qualidade será feito o monitoramento dos indicadores conforme as Métricas da Qualidade.]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando16"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante16"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr>
															<tr>
																<td><br></td>
																<td><br></td>
															</tr>
															<tr class="field">
																<td><p align="justify">
																		<b>Aprovação<font color="red">*</font></b>
																<p align="justify">
																		<font color="blue"></font>
																	</p> <textarea id="aprovacao" name="aprovacao" 
																		onkeyup="mostrarResultadoEtapa19(this.value,600,'spcontando17');contarCaracteresEtapa19(this.value,600,'sprestante17')"></textarea>
																	<p class="hint">[Participantes, datas, etc.]</p>
																	<br>
																<br>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="spcontando17"
																			style="font-family: Arial;"></span></font>
																	</h5>
																	<h5 align="left">
																		<font size="1" color="#6C7B8B"><span id="sprestante17"
																			style="font-family: Arial;"></span></font>
																	</h5></td>
															</tr> -->
														</table>
														<br>
														<br> 
														<input class="prev acao" type="submit" value="Cadastrar" onclick="show_confirm();" onchange="validaCadastrarRiscos();"/>
														<input class="prev acao" type="reset" value="Limpar"></input>
														<button type="button" class="prev acao" data-dismiss="modal">Cancelar</button>
													</fieldset>
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