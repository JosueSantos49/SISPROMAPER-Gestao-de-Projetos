<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito"%>
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

<title>Cadastrar Matriz de Restarbilidade dos Requisitos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareMatrizRastreabilidadeRequisito.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarMatrizRastreabilidadeRequisito";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("matrizRastreabilidadeRequisito").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">MATRIZ DE RASTREABILIDADE DOS REQUISITOS</font></th></tr></table><br>				
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
				<input type="hidden" name="cmd" value="cadastrarMatrizRastreabilidadeRequisito"></input>
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
						<td><p align="justify">
								<b>Código da Matriz <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigomatriz" name="codigomatriz"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${matrizRastreabilidadeRequisito.codigomatriz}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o código da Matriz.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Prioridade <font color="red">*</font></b>
							<p align="justify">
								<select id="prioridade" name="prioridade" required="true">
									<option value="">......</option>
									<option value="0-Altíssima">0-Altíssima</option>
									<option value="1-Alta">1-Alta</option>
									<option value="2-Média">2-Média</option>
									<option value="3-Baixa">3-Baixa</option>
									<option value="4-Muito baixa">4-Muito baixa</option>
								</select>
							<p class="hint">[Informar Prioridade.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Tipo <font color="red">*</font></b>
							<p align="justify">
								<select id="tipo" name="tipo" required="true">
									<option value="">......</option>
									<option value="Funcional">Funcional</option>
									<option value="Técnico">Técnico</option>
									<option value="Qualidade">Qualidade</option>
									<option value="Financeiro">Financeiro</option>
								</select>
							<p class="hint">[Informar Tipo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Nome <font color="red">*</font></b></p>
						<p align="justify">
								<input id="nome" name="nome"
									style="height: 30px; width: 379px" maxlength="150"
									value="${matrizRastreabilidadeRequisito.nome}" class="input" required="true"></input>
							<p class="hint">[Nome.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Descrição <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="descricao" name="descricao" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,1400,'spcontando0');contarCaracteresEtapa1(this.value,1400,'sprestante0')"></textarea>
							<p class="hint">[Informar a Descrição]</p>
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
								<b>Justificativa  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="justificativa" name="justificativa" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,1400,'spcontando');contarCaracteresEtapa2(this.value,1400,'sprestante')"></textarea>
							<p class="hint">[Informar a Justificativa.]</p>
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
								<b>Critérios de Aceitação <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="criterio" name="criterio" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1400,'spcontando1');contarCaracteresEtapa3(this.value,1400,'sprestante1')"></textarea>
							<p class="hint">[Critérios de Aceitação]</p>
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
						<td><p align="justify"><b>Solicitante <font color="red">*</font></b></p>
						<p align="justify">
								<input id="solicitante" name="solicitante"
									style="height: 30px; width: 379px" maxlength="150"
									value="${matrizRastreabilidadeRequisito.solicitante}" class="input" required="true"></input>
							<p class="hint">[Informar quem solicitou.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Status <font color="red">*</font></b>
							<p align="justify">
								<select id="status" name="status" required="true">
									<option value="">......</option>
									<option value="Ativo">Ativo</option>
									<option value="Cancelado">Cancelado</option>
									<option value="Adiado">Adiado</option>
									<option value="Adicionado">Adicionado</option>
									<option value="Aprovado">Aprovado</option>
									<option value="Concluído">Concluído</option>
									<option value="Pendente">Pendente</option>
									<option value="Em andamento">Em andamento</option>
								</select>
							<p class="hint">[Informar o status.]</p></td>
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
									value="${matrizRastreabilidadeRequisito.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>EAP <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="eap" name="eap" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1400,'spcontando2');contarCaracteresEtapa4(this.value,1400,'sprestante2')"></textarea>
							<p class="hint">[EAP]</p>
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
								<b>ID requisitos relacionados <font color="red">*</font></b></p>
						<p align="justify">
								<input id="id" name="id"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${matrizRastreabilidadeRequisito.codigomatriz}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[ID requisitos relacionados]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentários <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentario" name="comentario" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,1400,'spcontando3');contarCaracteresEtapa5(this.value,1400,'sprestante3')"></textarea>
							<p class="hint">[Comentários]</p>
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
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
