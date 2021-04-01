<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao"%>
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

<title>Atualizar Plano de Gerenciamento das Aquisições</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereAquisicao.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
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
			dateFormat : 'dd/mm/yy',
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
		$("#data").mask("99/99/9999"); //dataProjeto  
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
			location.href = "TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planoGerenciamentoAquisicao").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DAS AQUISIÇÕES</font></th></tr></table><br>				
				<center>
					<h3>
						<font color="red"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="atualizarPlanoGerenciamentoAquisicao"></input>
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
						<td><p align="justify"><b>Plano de Gerenciamento da Aquisições <font color="red">*</font></b></p>
						<p align="justify">
								<input id="planogerenciamentoaquisicao" name="planogerenciamentoaquisicao"
									style="height: 30px; width: 379px" maxlength="150"
									value="${planoGerenciamentoAquisicao.planogerenciamentoaquisicao}" class="input" required="true"></input>
							<p class="hint">[Plano de Gerenciamento da Aquisições]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Nome do projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="projeto" name="projeto"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${planoGerenciamentoAquisicao.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${planoGerenciamentoAquisicao.codigoprojeto}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o código do Projeto.]</p></td>
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
									value="${planoGerenciamentoAquisicao.versao}" class="input" required="true"></input>
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
									value="${planoGerenciamentoAquisicao.data}" class="input" required="true"
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
									value="${planoGerenciamentoAquisicao.autor}" class="input" required="true"
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
									value="${planoGerenciamentoAquisicao.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>1	Objetivo do Plano de gerenciamento das aquisições <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,350,'spcontando0');contarCaracteresEtapa1(this.value,350,'sprestante0')">${planoGerenciamentoAquisicao.objetivo}</textarea>
							<p class="hint">[Descreva o objetivo do Plano de gerenciamento das aquisições. O Plano de gerenciamento das aquisições descreve como os processos de aquisição serão gerenciados desde o desenvolvimento dos documentos de aquisições até o encerramento do contrato.]</p>
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
								<b>2	Método de gerenciamento das aquisições <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="metodo" name="metodo" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,350,'spcontando');contarCaracteresEtapa2(this.value,350,'sprestante')">${planoGerenciamentoAquisicao.metodo}</textarea>
							<p class="hint">[Use as seções para identificar os componentes do plano de gerenciamento das aquisições ou modifique-as para encontrar suas necessidades. ]</p>
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
								<b>2.1	Processos de Aquisições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="processo" name="processo" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,350,'spcontando1');contarCaracteresEtapa3(this.value,350,'sprestante1')">${planoGerenciamentoAquisicao.processo}</textarea>
							<p class="hint">[Descreva os processos de Gerenciamento das aquisições do projeto a serem adotados no projeto. Exemplo: Conduzir as aquisições, Controlar as aquisições e Encerrar as aquisições.]</p>
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
								<b>2.2	Decisões de comprar <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="decisoes" name="decisoes" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,350,'spcontando2');contarCaracteresEtapa4(this.value,350,'sprestante2')">${planoGerenciamentoAquisicao.decisoes}</textarea>
							<p class="hint">[Relacione todos os itens a serem adquiridos relacionados com a EAP do projeto. Usar mesmo código usado na EAP. ]</p>
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
								<b>2.3	Documentos padronizados de aquisição <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="documento" name="documento" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,350,'spcontando3');contarCaracteresEtapa5(this.value,350,'sprestante3')">${planoGerenciamentoAquisicao.documento}</textarea>
							<p class="hint">[Descreva os documentos padronizados a serem usadas nos processos das aquisições. Indique onde estão armazenados, como serão usados, e os responsáveis envolvidos.]</p>
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
								<b>2.4	Responsabilidades das aquisições da Equipe do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsabilidade" name="responsabilidade" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,350,'spcontando4');contarCaracteresEtapa6(this.value,350,'sprestante4')">${planoGerenciamentoAquisicao.responsabilidade}</textarea>
							<p class="hint">[Descreva as responsabilidades referentes aos processos das aquisições de cada membro do projeto, mesmo que já citados em outros tópicos do documento. Ressaltar as divisões de responsabilidade entre compras, projetos e jurídico. ]</p>
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
								<b>2.5	Métricas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="metrica" name="metrica" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,350,'spcontando4');contarCaracteresEtapa7(this.value,350,'sprestante4')">${planoGerenciamentoAquisicao.metrica}</textarea>
							<p class="hint">[Os padrões de mercado ou da organização e os requisitos a serem atingidos estão descritos na Declaração de Trabalho de cada Aquisição. ]</p>
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
								<b>2.6	Premissas e Restrições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="premissarestricao" name="premissarestricao" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,350,'spcontando5');contarCaracteresEtapa8(this.value,350,'sprestante5')">${planoGerenciamentoAquisicao.premissarestricao}</textarea>
							<p class="hint">[Premissas e restrições relacionados aos processos de aquisições e como serão tratados. Os pré-requisitos e características do ambiente para as aquisições fazem parte deste tópico. Usar mesma referência da Declaração do escopo. Use sempre a referência do código de aquisição quando for uma premissa específica.]</p>
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
								<b>2.7	Riscos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="riscos" name="riscos" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,350,'spcontando6');contarCaracteresEtapa9(this.value,350,'sprestante6')">${planoGerenciamentoAquisicao.riscos}</textarea>
							<p class="hint">[Riscos relacionados aos processos de aquisições e como serão tratados (Tipos de Contrato, Cláusulas, Requisitos de bônus de desempenho, seguros, ...). Usar mesma referência do plano de gerenciamento de riscos.]</p>
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
								<b>2.8	Fornecedores pré-qualificados<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="fornecedor" name="fornecedor" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,350,'spcontando7');contarCaracteresEtapa10(this.value,350,'sprestante7')">${planoGerenciamentoAquisicao.fornecedor}</textarea>
							<p class="hint">[Use essa seção caso queira detalhar os motivos pela pré-seleção dos fornecedores em potencial. Esses fornecedores serão os que participaram do processo de seleção. ]</p>
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
								<b>3	Conduzir as aquisições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="conduziraquisicao" name="conduziraquisicao" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,350,'spcontando8');contarCaracteresEtapa11(this.value,350,'sprestante8')">${planoGerenciamentoAquisicao.conduziraquisicao}</textarea>
							<p class="hint">[Descreva como serão conduzidas as aquisições. Saiba mais em Conduzir as aquisições]</p>
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
								<b>3.1	Tipos de contratos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="tipocontrato" name="tipocontrato" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,350,'spcontando9');contarCaracteresEtapa12(this.value,350,'sprestante9')">${planoGerenciamentoAquisicao.tipocontrato}</textarea>
							<p class="hint">[Descreva os tipos de contratos utilizados pelo projeto e porque foram selecionados]</p>
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
								<b>3.2	Critérios de avaliação das cotações e das propostas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="criterioavaliacao" name="criterioavaliacao" required="true"
								onkeyup="mostrarResultadoEtapa13(this.value,350,'spcontando10');contarCaracteresEtapa13(this.value,350,'sprestante10')">${planoGerenciamentoAquisicao.criterioavaliacao}</textarea>
							<p class="hint">[Descreva de forma clara e objetiva os critérios de avaliação usados]</p>
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
								<b>4	Controlar as aquisições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="controlaaquisicao" name="controlaaquisicao" required="true"
								onkeyup="mostrarResultadoEtapa14(this.value,350,'spcontando14');contarCaracteresEtapa14(this.value,350,'sprestante14')">${planoGerenciamentoAquisicao.controlaaquisicao}</textarea>
							<p class="hint">[Descreva como serão avaliados os fornecedores. Saiba mais em Controlar as aquisições.]</p>
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
								<b>4.1	Avaliação de fornecedores<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="avalicacaofornecedor" name="avalicacaofornecedor" required="true"
								onkeyup="mostrarResultadoEtapa15(this.value,350,'spcontando15');contarCaracteresEtapa15(this.value,350,'sprestante15')">${planoGerenciamentoAquisicao.avalicacaofornecedor}</textarea>
							<p class="hint">[Descreva os critérios utilizados para avaliar os fornecedores e quando serão avaliados.]</p>
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
								<b>5	Encerrar as aquisições<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="encerraraquisicao" name="encerraraquisicao" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,350,'spcontando16');contarCaracteresEtapa16(this.value,350,'sprestante16')">${planoGerenciamentoAquisicao.encerraraquisicao}</textarea>
							<p class="hint">[Descreva como será encerrado as aquisições. Saiba mais em Encerrar as aquisições.]</p>
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
								onkeyup="mostrarResultadoEtapa17(this.value,350,'spcontando17');contarCaracteresEtapa17(this.value,350,'sprestante17')">${planoGerenciamentoAquisicao.aprovacao}</textarea>
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
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Atualizar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
