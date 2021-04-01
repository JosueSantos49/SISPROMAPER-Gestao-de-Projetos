<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.AtaReuniao"%>
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

<title>Cadastrar Ata Reuni�o</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareaAtaReuniao.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarAtaReuniao";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("empresa").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">ATA DE REUNI�O</font></th></tr></table><br>				
				
								<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> Ata � um documento em que se registram resumidamente e com clareza as ocorr�ncias, delibera��es, resolu��es e decis�es de reuni�es ou assembleias.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Ata de reuni�o</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Uma ata de reuni�o � um documento que serve para documentar todo uma reuni�o, com os assuntos e resolu��es tratadas durante a mesma.<br>
										Ela � muito �til, pois permite que os assuntos de reuni�es passadas sejam lembrados com agilidade, evitando a perda de tempo em pr�ximas reuni�es, e agilizando muitas vezes o processo de melhorias, modifica��es, etc.<br> </div>
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
				<br> <input type="hidden" name="cmd" value="cadastrarAtaReuniao"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="90%"	bgcolor="#FFFFFF">
					<tr>
						<td><p><font color="red">Campos de (*) obrigat�rio.</font></p><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Ata de Reuni�o <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="ata" name="ata"
									style="height: 30px; width: 379px" maxlength="150"
									value="${ataReuniao.ata}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o nome do cliente.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Local <font color="red">*</font></b>
							</p><p align="justify">
								<input id="local" name="local"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${ataReuniao.local}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o �rg�o.]</p></td>
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
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprovado por: <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="aprovado" name="aprovado"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${ataReuniao.aprovado}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar nome e fun��o.]</p></td>
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
									value="${ataReuniao.versao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a vers�o.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data: <font color="red">*</font></b>
						<p align="justify">
								<input id="data" name="data"
									style="height: 30px; width: 100px"
									value="${ataReuniao.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data da Aprova��o.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Participantes <font color="red">*</font></b><br>
						<p align="justify">	<font color="blue"></font></p>
							<textarea id="participante" name="participante" required="true" onkeyup="mostrarResultadoEtapa1(this.value,1210,'spcontando0');contarCaracteresEtapa1(this.value,1210,'sprestante0')"></textarea>
							<p class="hint">[Os produtos entregues correspondem aos descritos na proposta executiva?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivos  <font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true" onkeyup="mostrarResultadoEtapa2(this.value,1210,'spcontando');contarCaracteresEtapa2(this.value,1210,'sprestante')"></textarea>
							<p class="hint">[Foi elaborado um relat�rio de auditoria final dos resultados?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>T�picos discutidos <font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="topico" name="topico" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1210,'spcontando1');contarCaracteresEtapa3(this.value,1210,'sprestante1')"></textarea>
							<p class="hint">[Houve desvios entre os prazos realizados e programados (baseline)?]</p>
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
								<b>A��es a serem tomadas<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="acoestomadas" name="acoestomadas" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1210,'spcontando2');contarCaracteresEtapa4(this.value,1210,'sprestante2')"></textarea>
							<p class="hint">[Houve desvios entre os custos efetivos e os or�ados (baseline)?]</p>
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
								<b>Pr�xima reuni�o do projeto<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="proximareuniao" name="proximareuniao" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,1210,'spcontando3');contarCaracteresEtapa5(this.value,1210,'sprestante3')">N�o se aplica (N/A).</textarea>
							<p class="hint">[Os desvios poderiam ter sido evitados?]</p>
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
								<b>Informa��es adicionais<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="adicionais" name="adicionais" required="true" 
								onkeyup="mostrarResultadoEtapa6(this.value,1210,'spcontando4');contarCaracteresEtapa6(this.value,1210,'sprestante4')">N�o se aplica (N/A).</textarea>
							<p class="hint">[Ocorreram riscos n�o previstos?]</p>
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
								<b>Aprova��o <font color="red">*</font></b><br>
							<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,200,'spcontando5');contarCaracteresEtapa7(this.value,200,'sprestante5')"></textarea>
							<p class="hint">[Os clientes/usu�rios est�o satisfeitos?]</p>
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
					<!-- <tr class="field">
						<td><p align="justify">
								<b>8.  A equipe ficou satisfeita com o apoio dos patrocinadores?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta8" name="pergunta8" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,1210,'spcontando6');contarCaracteresEtapa8(this.value,1210,'sprestante6')"></textarea>
							<p class="hint">[A equipe ficou satisfeita com o apoio dos patrocinadores?]</p>
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
								<b>9.  Houve coopera��o e comprometimento das pessoas?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta9" name="pergunta9" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,1210,'spcontando7');contarCaracteresEtapa9(this.value,1210,'sprestante7')"></textarea>
							<p class="hint">[Houve coopera��o e comprometimento das pessoas?]</p>
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
								<b>10. O projeto foi bem administrado?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta10" name="pergunta10" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,1210,'spcontando8');contarCaracteresEtapa10(this.value,1210,'sprestante8')"></textarea>
							<p class="hint">[O projeto foi bem administrado?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando8"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante8"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>11. Houve problemas de comunica��o?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta11" name="pergunta11" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,1210,'spcontando9');contarCaracteresEtapa11(this.value,1210,'sprestante9')"></textarea>
							<p class="hint">[Houve problemas de comunica��o?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando9"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante9"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>12. O projeto foi bem documentado?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta12" name="pergunta12" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,1210,'spcontando10');contarCaracteresEtapa12(this.value,1210,'sprestante10')"></textarea>
							<p class="hint">[O projeto foi bem documentado?]</p>
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
								<b>13. Os fornecedores entregaram seus produtos/servi�os em conformidade com as especifica��es combinadas?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta13" name="pergunta13" required="true"
								onkeyup="mostrarResultadoEtapa13(this.value,1210,'spcontando11');contarCaracteresEtapa13(this.value,1210,'sprestante11')"></textarea>
							<p class="hint">[Os fornecedores entregaram seus produtos/servi�os em conformidade com as especifica��es combinadas?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando11"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante11"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>14. O que far�amos da mesma forma? <font color="red">*</font></b><br>
							<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta14" name="pergunta14" required="true"
								onkeyup="mostrarResultadoEtapa14(this.value,1210,'spcontando12');contarCaracteresEtapa14(this.value,1210,'sprestante12')"></textarea>
							<p class="hint">[O que far�amos da mesma forma?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando12"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante12"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>15. O que far�amos de maneira diferente?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta15" name="pergunta15" required="true" onkeyup="mostrarResultadoEtapa15(this.value,1210,'spcontando13');contarCaracteresEtapa15(this.value,1210,'sprestant13')"></textarea>
							<p class="hint">[O que far�amos de maneira diferente?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando13" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestant13" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>16. O que sabemos hoje, e que n�o sab�amos antes do projeto?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta16" name="pergunta16" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,1210,'spcontando14');contarCaracteresEtapa16(this.value,1210,'sprestante14')"></textarea>
							<p class="hint">[O que sabemos hoje, e que n�o sab�amos antes do projeto?]</p>
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
								<b>17. Que recomenda��es devemos incluir para melhorar os pr�ximos projetos?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta17" name="pergunta17" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,1210,'spcontando15');contarCaracteresEtapa17(this.value,1210,'sprestante15')"></textarea>
							<p class="hint">[Que recomenda��es devemos incluir para melhorar os pr�ximos projetos?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando15"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante15"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
					</tr> -->
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
