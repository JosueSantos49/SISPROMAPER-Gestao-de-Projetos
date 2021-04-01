<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
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

<title>Cadastrar Termo de Encerramento do Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroProjetoTermoEncerramento.js"></script>
<script type="text/javascript" src="js/validaCadastrarProjetoTermoEncerramento.js"></script>
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
		$("#datadocumento").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataanaliseresultado").datepicker({
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
		$("#datadocumento").mask("99/99/9999");  
		$("#dataanaliseresultado").mask("99/99/9999"); 
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
			location.href = "TkcsapcdController?cmd=consultarProjeto";

		}
	}
</script>

<script type="text/javascript">	function setFocus() {document.getElementById("nomeprojeto").focus();}</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">
	
		<form action="TkcsapcdController" id="formulario" name="formulario" onsubmit="validaCadastrarProjetoTermoEncerramento()">

			<fieldset>					
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">TERMO DE ENCERRAMENTO DO PROJETO</font><br></th></tr></table>
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> Formalização ou Aceite da Entrega do Projeto. Pode ser usada tanto para entregas parciais ou a entrega final do projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Termo de encerramento do projeto</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Formalização ou Aceite da Entrega do Projeto. Pode ser usada tanto para entregas parciais ou a entrega final do projeto. Este documento formaliza o aceite da entrega considerando-a em conformidade com os requisitos e os critérios de aceitação definidos.
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
				
				<center><h3><font color="green"> ${mensagem}</font></h3></center>
				<div id="dialog"><p><font color="red">Campo (*) obrigatório.<br></font></p><br></div>
				<br> 
				<input type="hidden" name="cmd" value="cadastrarProjetoTermoEncerramento"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">					
					<tr>
						<td><br>
						<p><font color="red">Campos de (*) obrigatório.</font></p>
						<br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Nome do Projeto <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="nomeprojeto" name="nomeprojeto"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${projetotermoencerramento.nomeprojeto}" 
									class="input"
									required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código Projeto <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 150px"
									Placeholder="Digitar o código"
									onkeypress="javascript: return numbers(event);"
									class="input"
									required="true"></input>
							<p class="hint">[Informar o Código Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data Documento<font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="datadocumento" name="datadocumento"
									style="height: 30px; width: 100px"
									value="${projetotermoencerramento.datadocumento}" class="input"
									required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a data do documento  do projeto.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Coordenador(a) <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="coordenador" name="coordenador" style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${projetotermoencerramento.coordenador}" class="input"
									required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o coordenaro(a) do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Tipo de Projeto <font color="red">*</font></b></td>
						<td><p align="justify">
								<input type="radio" value="Interno" id="tipoprojeto" name="tipoprojeto"> Interno <br> 
								<input type="radio" value="Extratégico" id="tipoprojeto" name="tipoprojeto"> Extratégico <br>
							<p class="hint">[Informar o tipo de projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Gestor(a) <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="gestor" name="gestor"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${projetotermoencerramento.gestor}" class="input"
									required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o gestor do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Programa <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="programa" name="programa"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${projetotermoencerramento.programa}" class="input"
									required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o programa do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Status Conclusão <font color="red">*</font></b></td>
						<td><p align="justify">
								<input type="radio" value="Concluído" id="statusconclusao" name="statusconclusao"> Concluído <br> 
								<input type="radio" value="Cancelado" id="statusconclusao" name="statusconclusao"> Cancelado <br>
								<input type="radio" value="Absorvido pelo projeto" id="statusconclusao" name="statusconclusao"> Absorvido pelo projeto <br> 
								<input type="radio" value="Parcialmente concluído" id="statusconclusao" name="statusconclusao"> Parcialmente concluído <br>
							<p class="hint">[Informar o status da conclusão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data Ánalise Resultados<font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="dataanaliseresultado" name="dataanaliseresultado"
									style="height: 30px; width: 100px"
									value="${projetotermoencerramento.dataanaliseresultado}" class="input"
									required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a data de ánalise dos resultados.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><font color="red">Análise Final</font></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivo <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivoprojeto" name="objetivoprojeto" required="true" onkeyup="mostrarResultadoDescricao(this.value,400,'spcontando0');contarCaracteresDescricao(this.value,400,'sprestante0')"></textarea>
							<p class="hint">[Descrever o que se destina o projeto. Responder a pergunta: Qual o objeto do projeto?]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Justificativa <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="justificativaprojeto" name="justificativaprojeto" required="true" onkeyup="mostrarResultadoJustificativa(this.value,400,'spcontando');contarCaracteresJustificativa(this.value,400,'sprestante')"></textarea>
							<p class="hint">[Descrever o que se destina o projeto. Responder a pergunta: Qual é a justificativa do projeto?]</p>
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
					<tr>
						<td><font color="red">Desempenho Financeiro</font><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>					
					<tr class="field">
						<td><p align="justify">
								<b>Orçamento Previsto <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="orcamentoprevisto"
									name="orcamentoprevisto" style="height: 30px; width: 379px"
									value="${projetotermoencerramento.orcamentoprevisto}"
									required="true"
									onkeypress="return numbers(event);" class="input"></input>
							<p class="hint">[Informar o orçamento previsto.]</p>
							</td>
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
								<b>Valor Empenhado <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="valorempenhado"
									name="valorempenhado" style="height: 30px; width: 379px;"
									value="${projetotermoencerramento.valorempenhado}" class="input"
									required="true"
									onkeypress="return numbers(event);"
									Placeholder=""></input>
							<p class="hint">[Informar o valor empenhado.]</p>
						</td>
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
								<b>Valor Pago <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="valorpago"
									name="valorpago" style="height: 30px; width: 379px;"
									value="${projetotermoencerramento.valorpago}" class="input"
									required="true"
									onkeypress="return numbers(event);"
									Placeholder=""></input>
							<p class="hint">[Informar o valor pago.]</p>
						</td>
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
								<b>Saldo <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="saldo"
									name="saldo" style="height: 30px; width: 379px;"
									value="${projetotermoencerramento.saldo}" class="input"
									required="true"
									onkeypress="return numbers(event);"
									Placeholder=""></input>
							<p class="hint">[Informar o saldo.]</p>
						</td>
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
								<b>Resultado Previsto <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="resultadoprevisto" name="resultadoprevisto" required="true" onkeyup="mostrarResultadoResultado(this.value,400,'spcontando1');contarCaracteresResultado(this.value,400,'sprestante1')"></textarea>
							<p class="hint">[Relacionar os resultados previstos pelo projeto para o ano.]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Peso <font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="peso" name="peso" style="height: 30px; width: 379px;"
									value="${projetotermoencerramento.peso}" class="input"
									required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o peso de cada item.]</p></td>
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
								<b>Progresso <font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="progresso" name="progresso" style="height: 30px; width: 379px;"
									value="${projetotermoencerramento.progresso}" class="input"
									required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o progresso. Não iniciado / em andamento / concluído / Conclusão em.]</p></td>
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
								<b>Detalhamento <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="detalhamento" name="detalhamento" required="true" onkeyup="mostrarResultadoDetalhamento(this.value,400,'spcontando2');contarCaracteresDetalhamento(this.value,400,'sprestante2')"></textarea>
							<p class="hint">[Informar data de conclusão ou situação do desenvolvimento do trabalho.]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Análise Efetividade <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="analiseefetividade" name="analiseefetividade" required="true" onkeyup="mostrarResultadoEfetividade(this.value,400,'spcontando3');contarCaracteresEfetividade(this.value,400,'sprestante3')"></textarea>
							<p class="hint">[Os produtos previstos no projeto foram concluídos? O objetivo final do projeto foi alcançado? O resultado alcançado está coerente com a justificativa apresentada?]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><font color="red">Documentação</font><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Documentação Física <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="documentacaofisica" name="documentacaofisica" required="true" onkeyup="mostrarResultadoDocumentacao(this.value,400,'spcontando4');contarCaracteresDocumentacao(this.value,400,'sprestante4')"></textarea>
							<p class="hint">[Informar o numero de processo e a localização da documentação física do projeto.]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Documentação Eletrônica <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="documentacaoeletronica" name="documentacaoeletronica" required="true" onkeyup="mostrarResultadoDocumentacaoeletronica(this.value,400,'spcontando5');contarCaracteresDocumentacaoeletronica(this.value,400,'sprestante5')"></textarea>
							<p class="hint">[Relacionar os principais arquivos gerados pelo projeto e enviados para arquivamento pela GPP]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><font color="red">Considerações Finais</font><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Considerações Coordenador <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="concideracaocoordenador" name="concideracaocoordenador" required="true" onkeyup="mostrarResultadoCoordenador(this.value,400,'spcontando6');contarCaracteresCoordenador(this.value,400,'sprestante6')"></textarea>
							<p class="hint">[Coordenador relacionar considerações relevantes sobre o projeto.]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Considerações Gestor <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="concideracaogestor" name="concideracaogestor" required="true" onkeyup="mostrarResultadoGestor(this.value,400,'spcontando7');contarCaracteresGestor(this.value,400,'sprestante7')"></textarea>
							<p class="hint">[Gestor relacionar considerações relevantes sobre o projeto.]</p>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Concordo <font color="red">*</font></b></td>
						<td><p align="justify">
								Desclaro que as informações citadas são verdadeiras e estou
								ciente de estar sujeito as penas pertinente caso tenha afirmado
								falsamente os dados preenchidos. 
								<input id="termo" name="termo" type="checkbox" value="C" required="true"/>
							<p class="hint">[Concordar com o termo é obrigatório.]</p></td>
						<td><p align="justify"></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar" onclick="show_confirm();" onchange="validaCadastrarProjetoTermoEncerramento();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>
