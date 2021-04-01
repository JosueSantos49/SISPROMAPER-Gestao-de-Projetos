<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.AcompanhamentoProjeto"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@include file="include.jsp" %>

<html>

<jsp:include page="sessao.jsp" />

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Cadastrar Acompanhamento do Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareAcompanhamentoProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<%@include file="autocompletar.jsp" %>
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
<script>
	$(function() {
		$("#dataplanejada").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataefetiva").datepicker({
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
		$("#data").mask("99/99/9999"); 
		$("#dataplanejada").mask("99/99/9999"); 
		$("#dataefetiva").mask("99/99/9999"); 
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
			location.href = "TkcsapcdController?cmd=consultarAcompanhamentoProjeto";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planogerenciamentoqualidade").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp" %>
	
	<div align="center"> 
	
		<form action="TkcsapcdController" id="formulario" name="formulario" onSubmit="validaCadastrarAnalise()" onclick="validaCadastrarAnalise()">
						
			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">ACOMPANHAMENTO DO PROJETO</font></th></tr></table><br>				
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
				<input type="hidden" name="cmd" value="cadastrarAcompanhamentoProjeto"></input>
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
						<td><p align="justify"><b>Acompanhamento do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="acompanhamentoprojeto" name="acompanhamentoprojeto"
									style="height: 30px; width: 379px" maxlength="150"
									value="${acompanhamentoProjeto.acompanhamentoprojeto}" class="input" required="true"></input>
							<p class="hint">[Informar o Acompanhamento do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
								<td><p align="justify"><b>Projeto <font color="red">*</font></b>
								<p align="justify">
									<select id="projetoinicio" name="projetoinicio">
										<option id="projetoinicio">Selecione</option>
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
									value="${acompanhamentoProjeto.versao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
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
									value="${acompanhamentoProjeto.data}" class="input" required="true"
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
									value="${acompanhamentoProjeto.autor}" class="input" required="true"
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
									value="${acompanhamentoProjeto.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Produtos e serviços (entregas) <font color="red">*</font></b></p>
						<p align="justify">
								<input id="produtoservico" name="produtoservico"
									style="height: 30px; width: 379px" maxlength="150"
									value="${acompanhamentoProjeto.produtoservico}" class="input" required="true"></input>
							<p class="hint">[Informar Produtos e serviços (entregas).]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Situação ou % concluída <font color="red">*</font></b></p>
						<p align="justify">
								<input id="situacaoconcluida" name="situacaoconcluida"
									style="height: 30px; width: 379px" maxlength="150"
									value="${acompanhamentoProjeto.situacaoconcluida}" class="input" required="true"></input>
							<p class="hint">[Informar Situação ou % concluída.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data de entrega planejada <font color="red">*</font></b>
						<p align="justify">
								<input id="dataplanejada" name="dataplanejada"
									style="height: 30px; width: 100px"
									value="${acompanhamentoProjeto.dataplanejada}" class="input"></input>
							<p class="hint">[Informar Data de entrega planejada.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data de entrega efetiva (ou nova data) <font color="red">*</font></b>
						<p align="justify">
								<input id="dataefetiva" name="dataefetiva"
									style="height: 30px; width: 100px"
									value="${acompanhamentoProjeto.dataefetiva}" class="input"></input>
							<p class="hint">[Informar Data de entrega efetiva (ou nova data).]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Atraso previsto (dias) <font color="red">*</font></b></p>
						<p align="justify">
								<input id="atrasoprevisto" name="atrasoprevisto"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${acompanhamentoProjeto.atrasoprevisto}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar Atraso previsto (dias).]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Valor orçado (VO) <font color="red">*</font></b></p>
						<p align="justify">
								<input id="valororcado" name="valororcado"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${acompanhamentoProjeto.valororcado}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar Valor orçado (VO).]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Custo real (CR) <font color="red">*</font></b></p>
						<p align="justify">
								<input id="custoreal" name="custoreal"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${acompanhamentoProjeto.custoreal}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar Custo real (CR).]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Especificação de qualidade <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="especificacao" name="especificacao" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,1750,'spcontando0');contarCaracteresEtapa1(this.value,1750,'sprestante0')"></textarea>
							<p class="hint">[Especificação de qualidade]</p>
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
								<b>Nível atingido  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="nivel" name="nivel" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,1750,'spcontando');contarCaracteresEtapa2(this.value,1750,'sprestante')"></textarea>
							<p class="hint">[Nível atingido]</p>
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
								<b>Ações a empreender <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="acao" name="acao" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1750,'spcontando1');contarCaracteresEtapa3(this.value,1750,'sprestante1')"></textarea>
							<p class="hint">[Ações a empreender]</p>
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
								<b>Responsável: <pessoa ou setor> <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsavel" name="responsavel" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1750,'spcontando2');contarCaracteresEtapa4(this.value,1750,'sprestante2')"></textarea>
							<p class="hint">[Responsável: <pessoa ou setor>]</p>
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
								<b>Aprovação<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa19(this.value,300,'spcontando17');contarCaracteresEtapa19(this.value,300,'sprestante17')"></textarea>
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
				<br> <input class="prev acao" type="submit" value="Cadastrar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
<%@ include file="rodape.jsp" %>		
</body>
</html>