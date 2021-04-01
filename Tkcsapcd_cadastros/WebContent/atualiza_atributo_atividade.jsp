<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.Organograma"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.AtributoAtividade"%>
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

<title>Atualizar Atributo das Atividades</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareAtributoAtividade.js"></script>
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
		$("#").datepicker({
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
		$("#").mask("99/99/9999"); //dataProjeto  
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
			location.href = "TkcsapcdController?cmd=consultarAtributoAtividade";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("atributoAtividade").focus();
	}
</script>

</head>

<body onload="tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">ATRIBUTO DAS ATIVIDADES</font></th></tr></table><br>				
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
				<input type="hidden" name="cmd" value="atualizarAtributoAtividade"></input>
				<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação, codigo usado para modificar o registro -->
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
								<b>ID <font color="red">*</font></b></p>
						<p align="justify">
								<input id="id" name="id"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${atributoAtividade.id}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar ID.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
								<td><p align="justify"><b>EAP <font color="red">*</font></b>
								<p align="justify">
									<select id="organograma" name="organograma">
										<%
											List<Organograma> organogramas = (List<Organograma>) request.getAttribute("organogramas");
											for(Organograma organograma: organogramas){
												out.println("<option value='" + organograma.getCodigo() + "'>"
														                      + organograma.getDescricao());
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
								<b>Descrição da atividade  <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="descricao" name="descricao" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,980,'spcontando0');contarCaracteresEtapa1(this.value,980,'sprestante0')">${atributoAtividade.descricao}</textarea>
							<p class="hint">[Descrição da atividade ]</p>
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
								<b>Atividades predecessoras  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="predecessora" name="predecessora" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,980,'spcontando');contarCaracteresEtapa2(this.value,980,'sprestante')">${atributoAtividade.predecessora}</textarea>
							<p class="hint">[Atividades predecessoras]</p>
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
								<b>Atividades sucessoras <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="sucessora" name="sucessora" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,980,'spcontando1');contarCaracteresEtapa3(this.value,980,'sprestante1')">${atributoAtividade.sucessora}</textarea>
							<p class="hint">[Atividades sucessoras]</p>
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
								<b>Relacionamentos lógicos <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="relacionamento" name="relacionamento" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,980,'spcontando2');contarCaracteresEtapa4(this.value,980,'sprestante2')">${atributoAtividade.relacionamento}</textarea>
							<p class="hint">[Relacionamentos lógicos]</p>
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
								<b>Antecipações e atrasos <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="antecipacao" name="antecipacao" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,980,'spcontando3');contarCaracteresEtapa5(this.value,980,'sprestante3')">${atributoAtividade.antecipacao}</textarea>
							<p class="hint">[Antecipações e atrasos]</p>
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
								<b>Recursos necessários<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="recurso" name="recurso" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,980,'spcontando4');contarCaracteresEtapa6(this.value,980,'sprestante4')">${atributoAtividade.recurso}</textarea>
							<p class="hint">[Recursos necessários]</p>
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
								<b>Datas impostas, restrições e premissas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="data" name="data" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,980,'spcontando5');contarCaracteresEtapa7(this.value,980,'sprestante5')">${atributoAtividade.data}</textarea>
							<p class="hint">[Datas impostas, restrições e premissas]</p>
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
								<b>Responsável pela execução do trabalho <font color="red">*</font></b></p>
						<p align="justify">
								<input id="responsavel" name="responsavel"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${atributoAtividade.responsavel}" class="input" required="true"></input>
							<p class="hint">[Responsável pela execução do trabalho.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>					
					<tr class="field">
						<td><p align="justify">
								<b>Área geográfica ou o local onde o trabalho será executado<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="areageografica" name="areageografica" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,980,'spcontando6');contarCaracteresEtapa8(this.value,980,'sprestante6')">${atributoAtividade.areageografica}</textarea>
							<p class="hint">[Área geográfica ou o local onde o trabalho será executado. ]</p>
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
