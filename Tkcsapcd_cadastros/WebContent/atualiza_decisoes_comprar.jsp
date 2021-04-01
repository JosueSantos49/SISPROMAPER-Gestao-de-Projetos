<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.DecisoesComprar"%>
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

<title>Atualizar Decisões de Comprar</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareDecisoesComprar.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarDecisoesComprar";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("decisoesComprar").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">DECISÕES DE COMPRAR</font></th></tr></table><br>				
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
				<input type="hidden" name="cmd" value="atualizarDecisoesComprar"></input>
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
						<td><p align="justify">
								<b>Importância <font color="red">*</font></b></p>
						<p align="justify">
								<input id="importancia" name="importancia"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.importancia}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar Importância]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código EAP <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoeap" name="codigoeap"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.codigoeap}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Código usado na EAP (Estrutura analítica do projeto / WBS: Work Breakdown Structure)]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Item a ser adquirido <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="itens" name="itens" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')">${decisoesComprar.itens}</textarea>
							<p class="hint">[Nome do item a ser adquirido. Um pacote de trabalho da EAP pode ter vários itens de aquisição.]</p>
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
								<b>Urgência <font color="red">*</font></b></p>
						<p align="justify">
								<input id="urgencia" name="urgencia"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${decisoesComprar.urgencia}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Urgência da disponibilização da informação.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Impacto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="impacto" name="impacto"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${decisoesComprar.impacto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Impacto da não entrega da informação.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Motivo da Decisão de Compra  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="motivodecisao" name="motivodecisao" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,700,'spcontando');contarCaracteresEtapa2(this.value,700,'sprestante')">${decisoesComprar.motivodecisao}</textarea>
							<p class="hint">[Motivo da Decisão de Compra.]</p>
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
								<b>Fornecedores potenciais <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="fornecedores" name="fornecedores" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,700,'spcontando1');contarCaracteresEtapa3(this.value,700,'sprestante1')">${decisoesComprar.fornecedores}</textarea>
							<p class="hint">[Fornecedores potenciais.]</p>
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
								<b>Quantidade <font color="red">*</font></b></p>
						<p align="justify">
								<input id="quantidade" name="quantidade"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.quantidade}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a quantidade.]</p></td>
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
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.custo}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o custo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previsão <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="previsao" name="previsao" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,700,'spcontando2');contarCaracteresEtapa4(this.value,700,'sprestante2')">${decisoesComprar.previsao}</textarea>
							<p class="hint">[Previsão.]</p>
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
								<b>Doc Aquisição <font color="red">*</font></b>
						<p align="justify">
								<input id="docaquisicao" name="docaquisicao"
									style="height: 30px; width: 300px"
									value="${decisoesComprar.docaquisicao}" class="input" required="true"></input>
							<p class="hint">[Informar o Doc Aquisição.]</p>
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
								onkeyup="mostrarResultadoEtapa5(this.value,700,'spcontando3');contarCaracteresEtapa5(this.value,700,'sprestante3')">${decisoesComprar.descricao}</textarea>
							<p class="hint">[Descrição do item. A coluna pode ser excluída ou referenciada quando o item estiver detalhado no doc. de aquisição]</p>
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
								<b>Tipo Contrato<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="tipocontrato" name="tipocontrato" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,700,'spcontando4');contarCaracteresEtapa6(this.value,700,'sprestante4')">${decisoesComprar.tipocontrato}</textarea>
							<p class="hint">[Tipo Contrato.]</p>
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
								<b>Status <font color="red">*</font></b></p>
						<p align="justify">
								<input id="status" name="status"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${decisoesComprar.status}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Impacto o Status.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentários<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentarios" name="comentarios" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,700,'spcontando5');contarCaracteresEtapa7(this.value,700,'sprestante5')">${decisoesComprar.comentarios}</textarea>
							<p class="hint">[Comentários.]</p>
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
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Atualizar" onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
