<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.DicionarioEAP"%>
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

<title>Cadastrar Dicion�rio da EAP</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroDicionarioEAP.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<%@include file="autocompletar.jsp" %>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
-->
</style>

<!-- Calend�rio -->
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
			location.href = "TkcsapcdController?cmd=consultarDicionarioEAP";

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

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">DICION�RIO DA EAP</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O dicion�rio da EAP traz todo detalhe necess�rio para cada elemento da EAP de modo a orientar a equipe do projeto. Cont�m informa��es sobre como o trabalho ser� realizado, quest�es t�cnicas, etc.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Dicion�rio da EAP</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Parte de um sistema de autoriza��o de trabalho descrevendo para os integrantes da equipe cada componente da estrutura anal�tica do projeto (EAP) e pode ser usado para controlar quando um trabalho espec�fico � realizado de modo a evitar aumento do escopo e aumento da compreens�o das partes interessadas sobre o esfor�o necess�rio para cada pacote de trabalho.<br><br>
										O dicion�rio da EAP define limites do que � inclu�do no Pacote de trabalho. <br><br>
										Sa�da de: Criar a EAP
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
				<!-- Fim Modal explicando o objetivo da transa��o -->
				
				
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigat�rio.<br></font>
					</p>
					<br>
				</div>
				<br> <input type="hidden" name="cmd" value="cadastrarDicionarioEAP"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					<tr>
						<td>
							<p>
								<font color="red">Campos de (*) obrigat�rio.</font>
							</p>
							<br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Dicion�rio EAP <font color="red">*</font></b></p>
						<p align="justify">
								<input id="dicionarioeap" name="dicionarioeap"
									style="height: 30px; width: 379px" maxlength="150"
									value="${dicionarioEAP.dicionarioeap}" class="input" required="true"></input>
							<p class="hint">[Informar o Dicion�rio EAP.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>C�digo Dicion�rio da EAP <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoeap" name="codigoeap"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${dicionarioEAP.codigoeap}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[C�digo usado na EAP (Estrutura anal�tica do projeto / WBS: Work Breakdown Structure)]</p></td>
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
								<b>Vers�o <font color="red">*</font></b>
						<p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${dicionarioEAP.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a vers�o.]</p>
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
									value="${dicionarioEAP.data}" class="input" required="true"
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
									value="${dicionarioEAP.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Notas de revis�o <font color="red">*</font></b></p>
						<p align="justify">
								<input id="notarevisao" name="notarevisao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${dicionarioEAP.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar a nota de revis�o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Entrega/Pacote de Trabalho <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="entregapacote" name="entregapacote" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,450,'spcontando0');contarCaracteresEtapa1(this.value,450,'sprestante0')"></textarea>
							<p class="hint">[Nome da entrega ou pacote de trabalho usado na EAP]</p>
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
								<b>Descri��o  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="descricao" name="descricao" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,450,'spcontando');contarCaracteresEtapa2(this.value,450,'sprestante')"></textarea>
							<p class="hint">[Descri��o do pacote de trabalho, incluindo atividades envolvidas para servir de base para elabora��o do cronograma.]</p>
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
								<b>Crit�rios de aceita��o <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="criterioaceitacao" name="criterioaceitacao" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,450,'spcontando1');contarCaracteresEtapa3(this.value,450,'sprestante1')"></textarea>
							<p class="hint">[Crit�rios de aceita��o do pacote de trabalho, preferencialmente, mensur�veis.]</p>
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
								<b>(R)espons�vel <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsavel" name="responsavel" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,450,'spcontando2');contarCaracteresEtapa4(this.value,450,'sprestante2')"></textarea>
							<p class="hint">[Somente um respons�vel pela execu��o da atividade]</p>
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
								<b>(A)provador<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovado" name="aprovado" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,450,'spcontando3');contarCaracteresEtapa5(this.value,450,'sprestante3')"></textarea>
							<p class="hint">[Respons�vel pela aprova��o]</p>
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
								<b>(C)onsultado<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="consultado" name="consultado" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,450,'spcontando4');contarCaracteresEtapa6(this.value,450,'sprestante4')"></textarea>
							<p class="hint">[Pessoa a ser consultada antes que a decis�o seja tomada]</p>
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
								<b>(I)nformado<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="informado" name="informado" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,450,'spcontando5');contarCaracteresEtapa7(this.value,450,'sprestante5')"></textarea>
							<p class="hint">[Pessoa a ser informada sobre a decis�o tomada]</p>
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
								<b>Trabalho envolvido<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="trabalhoenvolvido" name="trabalhoenvolvido" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,450,'spcontando6');contarCaracteresEtapa8(this.value,450,'sprestante6')"></textarea>
							<p class="hint">[Trabalho envolvido]</p>
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
								<b>Riscos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="riscos" name="riscos" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,450,'spcontando7');contarCaracteresEtapa9(this.value,450,'sprestante7')"></textarea>
							<p class="hint">[Riscos]</p>
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
								<b>Recursos necess�rios<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="recusos" name="recusos" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,450,'spcontando8');contarCaracteresEtapa10(this.value,450,'sprestante8')"></textarea>
							<p class="hint">[Recursos necess�rios]</p>
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
								<b>Marcos relacionados<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="macros" name="macros" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,450,'spcontando9');contarCaracteresEtapa11(this.value,450,'sprestante9')"></textarea>
							<p class="hint">[Marcos relacionados]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Custo <font color="red">*</font></b></p>
						<p align="justify">
								<input id="custos" name="custos"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${dicionarioEAP.custos}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o custo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previs�o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="previsao" name="previsao" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,450,'spcontando10');contarCaracteresEtapa12(this.value,450,'sprestante10')"></textarea>
							<p class="hint">[Previs�o]</p>
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
								<b>Informa��es relevantes<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="informacoes" name="informacoes" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,450,'spcontando14');contarCaracteresEtapa16(this.value,450,'sprestante14')"></textarea>
							<p class="hint">[Qualquer informa��o que seja relevante para a execu��o do pacote de trabalho]</p>
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
								<b>Status <font color="red">*</font></b></p>
						<p align="justify">
								<input id="status" name="status"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${dicionarioEAP.status}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o status. Exemplo: Ok, Pendente, em andamento.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Coment�rios<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentarios" name="comentarios" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,450,'spcontando15');contarCaracteresEtapa17(this.value,450,'sprestante15')"></textarea>
							<p class="hint">[Coment�rios.]</p>
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
					<!-- <tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>4.2	Procedimentos de Monitoramento<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="procedimentomonitoramento" name="procedimentomonitoramento" required="true"
								onkeyup="mostrarResultadoEtapa18(this.value,450,'spcontando16');contarCaracteresEtapa18(this.value,450,'sprestante16')"></textarea>
							<p class="hint">[Use as M�tricas da Qualidade para indicar quais indicadores ser�o monitorados, como, em qual frequ�ncia. Para atingir os requisitos de qualidade ser� feito o monitoramento dos indicadores conforme as M�tricas da Qualidade.]</p>
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
					</tr>-->
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprova��o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa19(this.value,450,'spcontando17');contarCaracteresEtapa19(this.value,450,'sprestante17')"></textarea>
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
	<%@include file="rodape.jsp" %>
</body>
</html>
