<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PortfolioProjeto"%>
<%@page import="br.com.tkcsapcd.model.bean.StatusReport"%>
<%@page import="br.com.tkcsapcd.model.bean.RegistroRisco"%>
<%@page import="br.com.tkcsapcd.model.bean.DeclaracaoEscopo"%>
<%@page import="br.com.tkcsapcd.model.bean.DicionarioEAP"%>
<%@page import="br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto"%>
<%@page import="br.com.tkcsapcd.model.bean.RegistroParteInteressada"%>
<%@page import="br.com.tkcsapcd.model.dao.RegistroParteInteressadaDAO"%>
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
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
    <title>Atualizar Portfólio</title>
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

<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPortfolioProjeto.js"></script>
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

<!-- 
<script type="text/javascript">
	$(document).ready(function() {
		$("#datainicio").mask("99/99/9999");
		$("#datatermino").mask("99/99/9999");
		$("#dataatual").mask("99/99/9999");
	});
</script> -->

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
</head>

<body>

<div class="row affix-row">

	<%@include file="menuprotfolioprojeto.jsp" %>

	<div class="col-sm-9 col-md-10 affix-content">
		
	<div class="container">	
			
	<div class="page-header">
		<h3><span class="glyphicon glyphicon-th-list"></span> Portfólio de Projetos</h3>	
	</div>
	
	
		<form action="TkcsapcdController" onsubmit="validaCadastrarRiscos()">

			<fieldset>
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				
				
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> Um portfólio refere-se a um conjunto de projetos ou programas e outros trabalhos, agrupados para facilitar o gerenciamento eficaz desse trabalho a fim de atingir os objetivos de negócios estratégicos.
				    </div>
				
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" value="Clique aqui!">
				
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Portfolio de Projetos</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O gerenciamento de portfólios se refere ao gerenciamento centralizado de um ou mais
										portfólios, que inclui identificação, priorização, autorização, gerenciamento e controle de
										projetos, programas e outros trabalhos relacionados, para atingir objetivos de negócios
										estratégicos específicos. se concentra em garantir que os
										projetos e programas sejam analisados a fim de priorizar a alocação de recursos, e que o
										gerenciamento do portfólio seja consistente e esteja alinhado às estratégias organizacionais.
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
				
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog"><p><font color="red"> Campo (*) obrigatório.<br></font></p><br></div>
				
				<br> 
				<input type="hidden" name="cmd" value="atualizaPortfolioProjeto"></input>
				<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
				
				<div class="table-responsive">
				
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					
					<tr class="field">
						<td><p align="justify"><b>Código Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 200px" maxlength="150" class="form-control"
									value="${portfolioProjeto.codigoprojeto}" class="input" required="true"></input>
							<p class="hint">[Código do projeto]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Prioridade <font color="red">*</font></b></p>
						<p align="justify">
								<input id="prioridade" name="prioridade"
									style="height: 30px; width: 200px" maxlength="150" class="form-control"
									value="${portfolioProjeto.prioridade}" class="input" required="true"></input>
							<p class="hint">[Informar prioridade.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Tipo de Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="tipoprojeto" name="tipoprojeto"
									style="height: 30px; width: 379px" maxlength="150" class="form-control"
									value="${portfolioProjeto.tipoprojeto}" class="input" required="true"></input>
							<p class="hint">[Tipo de projeto varia em cada empresa.]</p></td>
					</tr>				
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Unidade de negócio <font color="red">*</font></b>
						<p align="justify">
								<input id="unidadenegocio" name="unidadenegocio"
									style="height: 30px; width: 379px" class="form-control"
									value="${portfolioProjeto.unidadenegocio}" class="input" required="true"></input>
							<p class="hint">[Informar a unidade de negócio.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Analista de Projeto<font color="red">*</font></b></p>
						<p align="justify">
								<input id="analista" name="analista"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder="" 
									value="${portfolioProjeto.analista}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Analista de Projeto]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Gerente de Projeto<font color="red">*</font></b></p>
						<p align="justify">
								<input id="gerente" name="gerente"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder="" 
									value="${portfolioProjeto.gerente}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Gerente de Projeto]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Fase <font color="red">*</font></b></p>
						<p align="justify">	
							<input id="fase" name="fase"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder="" 
									value="${portfolioProjeto.fase}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar fase.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Fase Atual<font color="red">*</font></b></p>
						<p align="justify">	
							<input id="faseatual" name="faseatual"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder="" 
									value="${portfolioProjeto.faseatual}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar fase atual.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previsão início do Projeto<font color="red">*</font></b>
						<p align="justify">
								<input id="datainicio" name="datainicio"
									style="height: 30px; width: 100px" 
									value="${portfolioProjeto.datainicio}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Previsão início do Projeto.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previsão Término do Projeto<font color="red">*</font></b>
						<p align="justify">
								<input id="datatermino" name="datatermino"
									style="height: 30px; width: 100px" 
									value="${portfolioProjeto.datatermino}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Previsão Término do Projeto.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previsão Fase Atual<font color="red">*</font></b>
						<p align="justify">
								<input id="dataatual" name="dataatual"
									style="height: 30px; width: 100px" 
									value="${portfolioProjeto.dataatual}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Previsão Fase Atual.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Parte Interessada <font color="red">*</font></b></p>
						<p align="justify">																	
								<select id="parteinteressada" name="parteinteressada" style="width: 379px" class="form-control">
										<option id="parteinteressada">${portfolioProjeto.parteinteressada}</option>
										<%
											List<RegistroParteInteressada> registroParteInteressadas = (List<RegistroParteInteressada>) request.getAttribute("registroParteInteressadas");
											for(RegistroParteInteressada registroParteInteressada: registroParteInteressadas){
												out.println("<option value='" + registroParteInteressada.getRegistroparteinteressada() + "'>"
														                      + registroParteInteressada.getRegistroparteinteressada());
											}
										%>	
								</select>
							<p class="hint">[Informar a parte Interessada.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Plano de Projeto <font color="red">*</font></b></p>
						<p align="justify">
																	
								<select id="planoprojeto" name="planoprojeto" style="width: 379px" class="form-control">
										<option id="planoprojeto">${portfolioProjeto.planoprojeto}</option>
										<%
											List<PlanoGerenciamentoProjeto> planoGerenciamentoProjetos = (List<PlanoGerenciamentoProjeto>) request.getAttribute("planoGerenciamentoProjetos");
											for(PlanoGerenciamentoProjeto planoGerenciamentoProjeto: planoGerenciamentoProjetos){
												out.println("<option value='" + planoGerenciamentoProjeto.getPlanogerenciamentoprojeto() + "'>"
														                      + planoGerenciamentoProjeto.getPlanogerenciamentoprojeto());
											}
										%>	
								</select>
							<p class="hint">[Informar o Plano de Projeto .]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Declaração do Escopo <font color="red">*</font></b></p>
						<p align="justify">
																	
								<select id="declaracaoescopo" name="declaracaoescopo" style="width: 379px" class="form-control">
										<option id="declaracaoescopo">${portfolioProjeto.declaracaoescopo} </option>
										<%
											List<DeclaracaoEscopo> declaracaoEscopos = (List<DeclaracaoEscopo>) request.getAttribute("declaracaoEscopos");
											for(DeclaracaoEscopo declaracaoEscopo: declaracaoEscopos){
												out.println("<option value='" + declaracaoEscopo.getCodigoprojeto() + "'>"
														                      + declaracaoEscopo.getCodigoprojeto());
											}
										%>	
								</select>
							<p class="hint">[Informar Declaração do Escopo.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Dicionário da EAP <font color="red">*</font></b></p>
						<p align="justify">
																	
								<select id="dicionarioeap" name="dicionarioeap" style="width: 379px" class="form-control">
										<option id="dicionarioeap">${portfolioProjeto.dicionarioeap}</option>
										<%
											List<DicionarioEAP> dicionarioEAPs = (List<DicionarioEAP>) request.getAttribute("dicionarioEAPs");
											for(DicionarioEAP dicionarioEAP: dicionarioEAPs){
												out.println("<option value='" + dicionarioEAP.getDicionarioeap() + "'>"
														                      + dicionarioEAP.getDicionarioeap());
											}
										%>	
								</select>
							<p class="hint">[Informar Dicionário da EAP.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Cronograma <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="cronograma" name="cronograma" required="true" 
								onkeyup="mostrarResultadoEtapa1(this.value,800,'spcontando0');contarCaracteresEtapa1(this.value,800,'sprestante0')">${portfolioProjeto.cronograma }</textarea>
							<p class="hint">[Cronograma]</p>
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
								<b>Registro dos Riscos e Problemas <font color="red">*</font></b></p>
						<p align="justify">
																	
								<select id="registrorisco" name="registrorisco" style="width: 379px" class="form-control">
										<option id="registrorisco">${portfolioProjeto.registrorisco}</option>
										<%
											List<RegistroRisco> registroRiscos = (List<RegistroRisco>) request.getAttribute("registroRiscos");
											for(RegistroRisco registroRisco: registroRiscos){
												out.println("<option value='" + registroRisco.getRegistrorisco() + "'>"
														                      + registroRisco.getRegistrorisco());
											}
										%>	
								</select>
							<p class="hint">[Informar Registro dos Riscos e Problemas.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Status Report <font color="red">*</font></b></p>
						<p align="justify">
																	
								<select id="statusreport" name="statusreport" style="width: 379px" class="form-control">
										<option id="statusreport">${portfolioProjeto.statusreport}</option>
										<%
											List<StatusReport> statusReports = (List<StatusReport>) request.getAttribute("statusReports");
											for(StatusReport statusReport: statusReports){
												out.println("<option value='" + statusReport.getStatusreport() + "'>"
														                      + statusReport.getStatusreport());
											}
										%>	
								</select>
							<p class="hint">[Informar Status Report.]</p>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Escopo  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="escopo" name="escopo" required="true" 
								onkeyup="mostrarResultadoEtapa2(this.value,800,'spcontando');contarCaracteresEtapa2(this.value,800,'sprestante')">${portfolioProjeto.escopo }</textarea>
							<p class="hint">[escopo]</p>
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
								<b>Custo <font color="red">*</font></b></p>
						<p align="justify">
								<input id="custo" name="custo"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder="" onkeypress="return numbers(event);"
									value="${portfolioProjeto.custo}" class="input" required="true"></input>
							<p class="hint">[Informar custo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentário <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentario" name="comentario" required="true" 
								onkeyup="mostrarResultadoEtapa3(this.value,800,'spcontando1');contarCaracteresEtapa3(this.value,800,'sprestante1')">${portfolioProjeto.comentario }</textarea>
							<p class="hint">[Comentário]</p>
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
								<b>Nível <font color="red">*</font></b></p>
						<p align="justify">
								<input id="nivel" name="nivel"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder=""
									value="${portfolioProjeto.nivel}" class="input" required="true"></input>
							<p class="hint">[Informar nível.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Entrega <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="entrega" name="entrega" required="true" 
								onkeyup="mostrarResultadoEtapa4(this.value,800,'spcontando2');contarCaracteresEtapa4(this.value,800,'sprestante2')">${portfolioProjeto.entrega }</textarea>
							<p class="hint">[Entrega]</p>
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
								<b>Status<font color="red">*</font></b></p>
						<p align="justify">	
							<select id="status"	name="status" style="width: 379px" class="form-control">
								<option value="">${portfolioProjeto.status}</option>
								<option value="Concluída">Concluída</option>
								<option value="No Prazo">No Prazo</option>	
								<option value="Atrazada">Atrazada</option>	
								<option value="Tarefa Futura">Tarefa Futura</option>								
							</select>
							<p class="hint">[Informar status.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Recursos <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="recursos" name="recursos" required="true" 
								onkeyup="mostrarResultadoEtapa5(this.value,800,'spcontando3');contarCaracteresEtapa5(this.value,800,'sprestante3')">${portfolioProjeto.recursos }</textarea>
							<p class="hint">[Recursos]</p>
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
								<b>Replanejamento<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="replanejamento" name="replanejamento" required="true" 
								onkeyup="mostrarResultadoEtapa6(this.value,800,'spcontando4');contarCaracteresEtapa6(this.value,800,'sprestante4')">${portfolioProjeto.replanejamento }</textarea>
							<p class="hint">[Replanejamento]</p>
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
								<b>Estimativa<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="estimativa" name="estimativa" required="true" 
								onkeyup="mostrarResultadoEtapa7(this.value,800,'spcontando5');contarCaracteresEtapa7(this.value,800,'sprestante5')">${portfolioProjeto.estimativa }</textarea>
							<p class="hint">[Estimativa]</p>
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
								<b>Linha de Base <font color="red">*</font></b></p>
						<p align="justify">
								<input id="linhabase" name="linhabase"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder=""
									value="${portfolioProjeto.linhabase}" class="input" required="true"></input>
							<p class="hint">[Informar linha de base.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Esforço <font color="red">*</font></b></p>
						<p align="justify">
								<input id="esforco" name="esforco"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder=""
									value="${portfolioProjeto.esforco}" class="input" required="true"></input>
							<p class="hint">[Informar esforço.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Conclusão <font color="red">*</font></b></p>
						<p align="justify">
								<input id="conclusao" name="conclusao"
									style="height: 30px; width: 379px" class="form-control"
									Placeholder=""
									value="${portfolioProjeto.conclusao}" class="input" required="true"></input>
							<p class="hint">[Informar Conclusão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Etapa<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="etapa" name="etapa" required="true" 
								onkeyup="mostrarResultadoEtapa8(this.value,800,'spcontando6');contarCaracteresEtapa8(this.value,800,'sprestante6')">${portfolioProjeto.etapa }</textarea>
							<p class="hint">[Etapa]</p>
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
								<b>EAP<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="eap" name="eap" required="true" 
								onkeyup="mostrarResultadoEtapa9(this.value,800,'spcontando7');contarCaracteresEtapa9(this.value,800,'sprestante7')">${portfolioProjeto.eap }</textarea>
							<p class="hint">[EAP]</p>
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
								<b>Responsável<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsavel" name="responsavel" required="true" 
								onkeyup="mostrarResultadoEtapa10(this.value,800,'spcontando8');contarCaracteresEtapa10(this.value,800,'sprestante8')">${portfolioProjeto.responsavel }</textarea>
							<p class="hint">[Responsável.]</p>
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
					<!-- <tr class="field">
						<td><p align="justify">
								<b>3.3	Responsabilidades de Qualidade da Equipe do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsabilidadequalidade" name="responsabilidadequalidade" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,800,'spcontando9');contarCaracteresEtapa11(this.value,800,'sprestante9')"></textarea>
							<p class="hint">[Descreva as responsabilidades referentes aos processos de qualidade de cada membro do projeto, mesmo que já citados em outros tópicos do documento. Exemplo: Menbro da equipe e responsabilidades.]</p>
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
								<b>3.4	Log de Auditoria da Qualidade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="logauditoria" name="logauditoria" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,800,'spcontando10');contarCaracteresEtapa12(this.value,800,'sprestante10')"></textarea>
							<p class="hint">[Data de revisão, atividade revisada, pontos de atenção e resolução.]</p>
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
								<b>4	CONTROLE DE QUALIDADE DO PROJETO<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="controlequalidade" name="controlequalidade" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,800,'spcontando14');contarCaracteresEtapa16(this.value,800,'sprestante14')"></textarea>
							<p class="hint">[Descreva os procedimentos do processo Controlar a qualidade, como as inspeções, que serão feitas, etc. Segue abaixo um exemplo. ]</p>
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
								<b>4.1	Procedimentos de Inspeção<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="procedimentoinspecao" name="procedimentoinspecao" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,800,'spcontando15');contarCaracteresEtapa17(this.value,800,'sprestante15')"></textarea>
							<p class="hint">[A inspeção será realizada na conclusão de cada entrega utilizando-se CheckList apresentado em anexo e respectivamente, os seus indicadores, a fim de manter a qualidade do projeto e alimentar o processo de melhoria contínua.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>4.2	Procedimentos de Monitoramento<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="procedimentomonitoramento" name="procedimentomonitoramento" required="true"
								onkeyup="mostrarResultadoEtapa18(this.value,800,'spcontando16');contarCaracteresEtapa18(this.value,800,'sprestante16')"></textarea>
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
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa19(this.value,800,'spcontando17');contarCaracteresEtapa19(this.value,800,'sprestante17')"></textarea>
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
					</tr>-->
				</table>
				</div>
				<br>
				<br> 
					<input class="btn btn-success" type="submit" value="Atualizar" onclick="show_confirm();" onchange="validaCadastrarRiscos();"/>
			</fieldset>
		</form>
	
		</div>

	<%@ include file="rodape.jsp" %>	
	
	</div>
</div>

</body>
</html>
