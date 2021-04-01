<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->

<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<title>Atualizar Termo de Abertura do Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarProjeto.js"></script>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
-->
</style>

<!-- Calendário -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'yyyy-MM-dd',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataimplantacaoprevista").datepicker({
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
		$("#data").mask("9999-99-99"); //99/99/9999  
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
			location.href = "TkcsapcdController?cmd=consultarTermoAberturaProjeto";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("termoAberturaProjeto").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">TERMO DE ABERTURA DO PROJETO</font></th></tr></table><br>				
				
								<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O termo de abertura do projeto, também muito conhecido como Project Charter (inglês), é o documento que autoriza formalmente um projeto. Ele concede ao gerente de projetos a autoridade para aplicar os recursos organizacionais nas atividades do projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Termo de abertura do projeto</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O Gerente de Projetos sempre deve ser designado antes do início do planejamento e, de preferência, no desenvolvimento do termo de abertura.<br>
										O patrocinador do projeto deve aprovar o termo de abertura do projeto.<br>
										O termo de abertura do projeto normalmente inclui as seguintes informações:<br><br>

				                       	Gerente de projetos designado e nível de autoridade atribuída;<br>
										Requisitos que satisfazem as necessidades do cliente, do patrocinador e de outras partes interessadas;<br>
										Necessidades de negócios, descrição de alto nível do projeto ou requisitos do produto para o qual o projeto é realizado;<br>
										Objetivo ou justificativa do projeto;<br>
										Cronograma de marcos sumarizado;<br>
										Influência das partes interessadas;<br>
										Organizações funcionais e sua participação;<br>
										Premissas organizacionais, ambientais e externas;<br>
										Restrições organizacionais, ambientais e externas;<br>
										Caso de negócios justificando o projeto, incluindo o retorno sobre o investimento;<br>
										Orçamento sumarizado.<br><br>
										Processos relacionados:<br>
										Saída de: Desenvolver o termo de abertura do projeto.<br>
										Entrada para: Desenvolver o plano de gerenciamento do projeto;
										Coletar os requisitos;
										Definir o escopo e
										Identificar as partes interessadas.
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
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="atualizarTermoAberturaProjeto"></input>
				<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
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
						<td><p align="justify"><b>Termo de Abertura do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="termoaberturaprojeto" name="termoaberturaprojeto"
									style="height: 30px; width: 379px" maxlength="150"
									value="${termoAberturaProjeto.termoaberturaprojeto}" class="input" required="true"></input>
							<p class="hint">[Informar Termo de Abertura do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
								<td><p align="justify"><b>Projeto <font color="red">*</font></b>
									<p align="justify">
									<select id="projetoinicio" name="projetoinicio">
										<%
											List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
											for(ProjetoInicio ProjetoInicio: projetoInicios){
												out.println("<option value='" + ProjetoInicio.getCodigo() + "'>"
														                      + ProjetoInicio.getProjeto());
											}
										%>
																				
									</select><p class="hint">[Informar o projeto.]</p>
								</td>
					</tr>	
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Versão <font color="red">*</font></b>
						<p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${termoAberturaProjeto.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data <font color="red">*</font></b>
						<p align="justify">
								<input id="data" name="data"
									style="height: 30px; width: 100px"
									value="${termoAberturaProjeto.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Autor <font color="red">*</font></b></p>
						<p align="justify">
								<input id="autor" name="autor"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${termoAberturaProjeto.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Notas de revisão <font color="red">*</font></b></p>
						<p align="justify">
								<input id="notarevisao" name="notarevisao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${termoAberturaProjeto.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>1 Objetivo deste documento <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,600,'spcontando0');contarCaracteresEtapa1(this.value,600,'sprestante0')">${termoAberturaProjeto.objetivo}</textarea>
							<p class="hint">[Descreva o motivo pelo qual esse documento será usado. Autorizar o início do projeto, atribuir principais responsáveis e documentar requisitos iniciais, principais entregas, premissas e restrições.]</p>
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
								<b>2	Situação atual e justificativa do projeto  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="justificativa" name="justificativa" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,600,'spcontando');contarCaracteresEtapa2(this.value,600,'sprestante')">${termoAberturaProjeto.justificativa}</textarea>
							<p class="hint">[Passado, onde está. Descreva a situação atual e o que motivou a realização do projeto. ]</p>
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
								<b>3	Objetivos SMART e critérios de sucesso do projeto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="smart" name="smart" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,600,'spcontando1');contarCaracteresEtapa3(this.value,600,'sprestante1')">${termoAberturaProjeto.smart}</textarea>
							<p class="hint">[Futuro, onde quer chegar. Descreva os benefícios esperados detalhando de forma clara objetivos SMART e critérios de sucesso relacionados. SMART Specific Específico, Measurable Indicador e meta, Assignable Quem, Realistic realístico, Time-related Quando]</p>
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
								<b>4	Estrutura Analítica do Projeto Fases e principais entregas <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="eap" name="eap" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,600,'spcontando2');contarCaracteresEtapa4(this.value,600,'sprestante2')">${termoAberturaProjeto.eap}</textarea>
							<p class="hint">[Inclua uma versão inicial da Estrutura Analítica do Projeto EAP com as fases do projeto e suas principais entregas. ]</p>
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
								<b>5	Principais requisitos das principais entregas / produtos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="requisito" name="requisito" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,600,'spcontando3');contarCaracteresEtapa5(this.value,600,'sprestante3')">${termoAberturaProjeto.requisito}</textarea>
							<p class="hint">[Documente os principais requisitos dos produtos / entregas a serem atendidos identificados na EAP acima.]</p>
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
								<b>6	Marcos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="marco" name="marco" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,600,'spcontando4');contarCaracteresEtapa6(this.value,600,'sprestante4')">${termoAberturaProjeto.marco}</textarea>
							<p class="hint">[Relacione os principais marcos do projeto. Marcos são os momentos mais importantes do projeto, quando se conclui as fases ou entregas principais.]]</p>
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
					<!-- <tr class="field">
						<td><p align="justify">
								<b>2.5	Entregas do Projeto e Critérios de Aceitação<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="entregaprojetoaceitacao" name="entregaprojetoaceitacao" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,600,'spcontando5');contarCaracteresEtapa7(this.value,600,'sprestante5')"></textarea>
							<p class="hint">[Baseado nos requisitos de qualidade da seção métricas de qualidade, descreva as entregas necessárias para cumpri-los, seus critérios de aceitação e como e quando (checkpoint) serão validados. Exemplo: Código EAP, entrega, Critérioas de aceitação e quando será verificado.]</p>
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
					</tr> -->
					<tr class="field">
						<td><p align="justify">
								<b>7	Partes interessadas do projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="parteinteressada" name="parteinteressada" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,600,'spcontando6');contarCaracteresEtapa8(this.value,600,'sprestante6')">${termoAberturaProjeto.parteinteressada}</textarea>
							<p class="hint">[Defina nomes, responsabilidades e nível de autoridade das principais partes interessadas do projeto]</p>
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
								<b>8	Restrições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="restricao" name="restricao" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,600,'spcontando7');contarCaracteresEtapa9(this.value,600,'sprestante7')">${termoAberturaProjeto.restricao}</textarea>
							<p class="hint">[Relacione as restrições do projeto, ou seja, limitação aplicável ao projeto, a qual afetará seu desempenho. Limitações reais: orçamento, recursos, tempo de alocação, ... Ex.: Orçamento de R$1.500.000,00]</p>
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
								<b>9	Premissas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="permissao" name="permissao" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,600,'spcontando8');contarCaracteresEtapa10(this.value,600,'sprestante8')">${termoAberturaProjeto.permissao}</textarea>
							<p class="hint">[]</p>
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
								<b>10	Riscos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="risco" name="risco" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,600,'spcontando9');contarCaracteresEtapa11(this.value,600,'sprestante9')">${termoAberturaProjeto.risco}</textarea>
							<p class="hint">[Descreva os principais riscos do projeto. ]</p>
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
								<b>11	Orçamento do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="orcamento" name="orcamento" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,600,'spcontando10');contarCaracteresEtapa12(this.value,600,'sprestante10')">${termoAberturaProjeto.orcamento}</textarea>
							<p class="hint">[Estimativa preliminar dos custos do projeto representada pelo orçamento ou pelo fluxo de caixa com suas principais entradas e saídas financeiras. Base para a aprovação financeira do projeto e da formação da linha de base dos custos]</p>
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
					<!-- 
					<tr class="field">
						<td><p align="justify">
								<b>4	CONTROLE DE QUALIDADE DO PROJETO<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="controlequalidade" name="controlequalidade" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,600,'spcontando14');contarCaracteresEtapa16(this.value,600,'sprestante14')"></textarea>
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
								onkeyup="mostrarResultadoEtapa17(this.value,600,'spcontando15');contarCaracteresEtapa17(this.value,600,'sprestante15')"></textarea>
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
					</tr> -->
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
								onkeyup="mostrarResultadoEtapa19(this.value,300,'spcontando17');contarCaracteresEtapa19(this.value,600,'sprestante17')">${termoAberturaProjeto.aprovacao}</textarea>
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
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>E-mail Confirmação <font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="para"
									style="height: 30px; width: 379px" 
									maxlength="150" 
									placeholder="Destinatário"
									class="input" 
									required="true"></input>
							<p class="hint">[Inserir e-mail para receber confirmação de registro, por e-mail.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Concordo <font color="red">*</font></b>
						<p align="justify">
								Desclaro que as informações citadas são verdadeiras e estou
								ciente de estar sujeito as penas pertinente caso tenha afirmado
								falsamente os dados preenchidos. <input id="concordo" name="concordo" type="checkbox" value="C" />
							<p class="hint">[Concordar com o termo é obrigatório.]</p></td>
						<td><p align="justify"></td>
					</tr>
					<tr>
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Atualizar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
