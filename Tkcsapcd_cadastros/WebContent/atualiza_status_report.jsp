<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.StatusReport"%>
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

<title>Atualizar Status Report</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroStatusReport.js"></script>
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
		$("#periodoinicio").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#periodofim").datepicker({
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
		$("#periodoinicio").mask("99/99/9999"); 
		$("#periodofim").mask("99/99/9999"); 
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
			location.href = "TkcsapcdController?cmd=consultarStatusReport";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("statusReport").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">STATUS REPORT</font></th></tr></table><br>				
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
				<input type="hidden" name="cmd" value="atualizarStatusReport"></input>
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
						<td><p align="justify"><b>Status Report <font color="red">*</font></b></p>
						<p align="justify">
								<input id="statusreport" name="statusreport"
									style="height: 30px; width: 379px" maxlength="150"
									value="${statusReport.statusreport}" class="input" required="true"></input>
							<p class="hint">[Informar o Status Report.]</p></td>
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
									value="${statusReport.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Nome do projeto.]</p></td>
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
									value="${statusReport.codigoprojeto}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o código do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Período Início <font color="red">*</font></b>
						<p align="justify">
								<input id="periodoinicio" name="periodoinicio"
									style="height: 30px; width: 100px"
									value="${statusReport.periodoinicio}" class="input"></input>
							<p class="hint">[Informar Período Início.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Período Fim <font color="red">*</font></b>
						<p align="justify">
								<input id="periodofim" name="periodofim"
									style="height: 30px; width: 100px"
									value="${statusReport.periodofim}" class="input"></input>
							<p class="hint">[Informar o Período Fim.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Iniciado por Área<font color="red">*</font></b>
						<p align="justify">
								<input id="indicador" name="indicador"
									style="height: 30px; width: 379px"
									value="${statusReport.indicador}" class="input" required="true"></input>
							<p class="hint">[Informar o Iniciado por Área.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Status <font color="red">*</font></b></p>
						<p align="justify">
								<input id="status" name="status"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${statusReport.status}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o status.]</p></td>
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
								onkeyup="mostrarResultadoEtapa1(this.value,500,'spcontando0');contarCaracteresEtapa1(this.value,500,'sprestante0')">${statusReport.comentario}</textarea>
							<p class="hint">[Comentário / Ação Requerida]</p>
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
								<b>Estrutura Analítica do Projeto (EAP)  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="eap" name="eap" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,500,'spcontando');contarCaracteresEtapa2(this.value,500,'sprestante')">${statusReport.eap}</textarea>
							<p class="hint">[Mais conhecida pelo termo Inglês Work Breakdown Structure (WBS). Informar o código da EAP]</p>
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
								<b>Atividades Concluídas no período <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="periodo" name="periodo" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,500,'spcontando1');contarCaracteresEtapa3(this.value,500,'sprestante1')">${statusReport.periodo}</textarea>
							<p class="hint">[Atividades Concluídas no período]</p>
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
								<b>Atividades em andamento <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="atividadeandamento" name="atividadeandamento" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,500,'spcontando2');contarCaracteresEtapa4(this.value,500,'sprestante2')">${statusReport.atividadeandamento}</textarea>
							<p class="hint">[Atividades em andamento]</p>
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
								<b>Atividades para o próximo período <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="proximoperiodo" name="proximoperiodo" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,500,'spcontando3');contarCaracteresEtapa5(this.value,500,'sprestante3')">${statusReport.proximoperiodo}</textarea>
							<p class="hint">[Atividades para o próximo período]</p>
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
								<b>Pontos de Atenção<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pontoatencao" name="pontoatencao" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,500,'spcontando4');contarCaracteresEtapa6(this.value,500,'sprestante4')">${statusReport.pontoatencao}</textarea>
							<p class="hint">[Pontos de Atenção]</p>
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
								<b>Informações adicionais<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="adicionais" name="adicionais" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,500,'spcontando5');contarCaracteresEtapa7(this.value,500,'sprestante5')">${statusReport.adicionais}</textarea>
							<p class="hint">[Informações adicionais]</p>
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
