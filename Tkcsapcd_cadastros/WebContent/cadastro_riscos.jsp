<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Riscos"%>
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

<title>Cadastrar Riscos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroRiscos.js"></script>
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
		$("#dataaprovacao").datepicker({
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
		$("#dataaprovacao").mask("99/99/9999"); //dataProjeto  
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
			location.href = "TkcsapcdController?cmd=consultarRiscos";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("autorProjeto").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"
			onsubmit="validaCadastrarRiscos()">

			<fieldset>
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">GERENCIAMENTO DOS RISCOS</font></th></tr></table><br>	
			
				<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O registro dos riscos � feito principalmente, no processo 11.2 Identificar os riscos, mas, � sempre revisado de acordo com a cria��o de novos planos.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Registro dos Riscos</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Atualizado conforme os outros processos de gerenciamento dos riscos (an�lise qualitativa, quantitativa, planejar as respostas aos riscos e monitorar e controlar os riscos) s�o conduzidos, resultando em um aumento no n�vel e no tipo de informa��es contidas no registro dos riscos ao longo do tempo.

										Sa�da de: 11.2 Identificar os riscos<br><br>

										Entrada para:<br><br> 										
										7.1 Estimar os custos<br>
										8.1 Planejar o gerenciamento da qualidade<br>
										11.3 Realizar a an�lise qualitativa dos riscos<br>
										11.4 Realizar a an�lise quantitativa dos riscos<br>
										11.5 Planejar as respostas aos riscos<br>
										11.6 Monitorar e controlar os riscos<br>
										12.1 Planejar as aquisi��es
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
						<font color="green">${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigat�rio.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="cadastrarRiscos"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="100%"	bgcolor="#FFFFFF">					
					<tr>
						<td><br>
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
						<td><p align="justify">
								<b>Empresa <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="empresa" name="empresa"
									style="height: 30px; width: 379px" maxlength="150"
									value="${riscos.empresa}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o nome do cliente.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Org�o <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="orgao" name="orgao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${riscos.orgao}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o �rg�o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Setor <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="setor" name="setor"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${riscos.setor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o setor da empresa respons�vel pelo projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Programa <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="programa" name="programa"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${riscos.programa}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o programa da empresa que o projeto est� inserido.]</p></td>
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
								<b>Gerente do projeto <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="gerente" name="gerente"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${riscos.gerente}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Gerente do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Elaborado por <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="funcao" name="funcao"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${riscos.funcao}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar nome e fun��o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprovado por <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="aprovado" name="aprovado"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${riscos.aprovado}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o respons�vel pela aprova��o.]</p></td>
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
									value="${riscos.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a vers�o.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data de Aprova��o <font color="red">*</font></b>
						<p align="justify">
								<input id="dataaprovacao" name="dataaprovacao"
									style="height: 30px; width: 100px"
									value="${riscos.dataaprovacao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data de Aprova��o.]</p>
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
								<b>1- Etapa: Identifica��o do Risco <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="etapa1" name="etapa1" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,1700,'spcontando0');contarCaracteresEtapa1(this.value,1700,'sprestante0')"></textarea>
							<p class="hint">[Denomina��o do risco, numero de Identifica��o e descri��o do risco.]</p>
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
								<b>2- Etapa: Avalia��o do Risco <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="etapa2" name="etapa2" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,1700,'spcontando');contarCaracteresEtapa2(this.value,1700,'sprestante')"></textarea>
							<p class="hint">[Impacto: 5 (alto), 4 (m�dio/alto), 3 (m�dio), 2 (m�dio/baixo), 1 (baixo); Probabilidade: 5 (alto), 4 (m�dio/alto), 3 (m�dio), 2 (m�dio/baixo), 1 (baixo)]</p>
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
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>3- Etapa: Desenvolvimento da Resposta<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="etapa3" name="etapa3" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1700,'spcontando1');contarCaracteresEtapa3(this.value,1700,'sprestante1')"></textarea>
							<p class="hint">[Estrat�gias para eliminar ou reduzir este risco (minimizar impacto e/ou probabilidade), respons�vel, data de conclus�o, impacto reavaliado, probabilidade reavaliada, etc.]</p>
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
								<b>4- Etapa: Acompanhamento do Risco<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="etapa4" name="etapa4" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1700,'spcontando2');contarCaracteresEtapa4(this.value,1700,'sprestante2')"></textarea>
							<p class="hint">[Ocorr�ncias e altera��es, Respostas inclu�das na WBS/Cronograma, etc.]</p>
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
