<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade"%>
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

<title>Cadastrar Plano de Gerenciamento da Qualidade</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereQualidade.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade";

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
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DA QUALIDADE</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O Plano de Gerenciamento da Qualidade (PGQ) identifica indicadores relevantes ao projeto e determina como satisfaz�-los garantindo ader�ncia com as pol�ticas da empresa e conformidade das entregas com seus requisitos.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Plano de Gerenciamento da Qualidade</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O PGQ descreve como implementar os processos de controle e garantia da qualidade e a melhoria cont�nua dos processos tendo como base a pol�tica da qualidade da empresa e as ferramentas e padr�es da qualidade relevantes ao projeto.<br>
										O PGQ tamb�m orienta como e quando as ferramentas e padr�es da qualidade s�o usados.<br><br>
										O PGQ deve conter:
										
										Ferramentas e padr�es da qualidade relevantes ao projeto;
										Procedimentos para garantir entregas em conformidade com seus requisitos;
										Crit�rios necess�rios para atender os padr�es da qualidade definidos e como e quando ser�o verificados (checkpoint);
										Processos e procedimentos de Controle e Garantia da Qualidade e de Melhoria Cont�nua;
										Equipe de gerenciamento e responsabilidades.<br><br>
										
										Sa�da de: 8.1 Planejar o gerenciamento da qualidade<br>
										Entrada para: 11.2 Identificar os riscos
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
				
				<center><h5><font color="green"> ${mensagem}</font></h5></center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigat�rio.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="cadastrarPlanoGerenciamentoQualidade"></input>
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
						<td><p align="justify"><b>Plano de Gerenciamento da Qualidade <font color="red">*</font></b></p>
						<p align="justify">
								<input id="planogerenciamentoqualidade" name="planogerenciamentoqualidade"
									style="height: 30px; width: 379px" maxlength="150"
									value="${planoGerenciamentoQualidade.planogerenciamentoqualidade}" class="input" required="true"></input>
							<p class="hint">[Informar o Plano de Gerenciamento da Qualidade.]</p></td>
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
									value="${planoGerenciamentoQualidade.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>C�digo do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 300px"
									Placeholder="" maxlength="10"
									class="input" required="true"
									onkeypress="return numbers(event);"></input>
									
							<p class="hint">[Informar o c�digo do Projeto.]</p></td>
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
									value="${planoGerenciamentoQualidade.versao}" class="input" required="true"></input>
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
									value="${planoGerenciamentoQualidade.data}" class="input" required="true"
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
									value="${planoGerenciamentoQualidade.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor]</p></td>
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
									value="${planoGerenciamentoQualidade.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revis�o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>1 Objetivo do Plano de Gerenciamento da Qualidade do Projeto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,400,'spcontando0');contarCaracteresEtapa1(this.value,400,'sprestante0')"></textarea>
							<p class="hint">[O plano de Gerenciamento da qualidade do projeto descreve como a equipe de gerenciamento de projetos implementar� a pol�tica de qualidade da organiza��o executora. O Plano de gerenciamento da qualidade define requisitos e padr�es da qualidade aplic�veis ao projeto e as suas entregas e descreve como ser� verificado a conformidade das entregas respeitando a pol�tica de qualidade da empresa.]</p>
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
								<b>2 M�todo de Gerenciamento da Qualidade  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="metodo" name="metodo" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,400,'spcontando');contarCaracteresEtapa2(this.value,400,'sprestante')"></textarea>
							<p class="hint">[Gerenciar a qualidade do projeto requer um plano de qualidade aprovado englobando os principais processos de qualidade. O plano de qualidade � desenvolvido e aprovado durante a fase de planejamento do projeto para confirmar requisitos e padr�es da qualidade aplic�veis ao projeto e as suas entregas e gerenciar os processos de projeto aprovados.]</p>
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
								<b>2.1	Processos de Qualidade <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="processoqualidade" name="processoqualidade" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,400,'spcontando1');contarCaracteresEtapa3(this.value,400,'sprestante1')"></textarea>
							<p class="hint">[Auditoria dos requisitos de qualidade e dos resultados das medi��es do controle da qualidade para garantir que sejam usados os padr�es de qualidade e defini��es operacionais apropriados. Monitoramento e registro dos resultados da execu��o das atividades de qualidade para avaliar o desempenho e recomendar as mudan�as necess�rias. ]</p>
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
								<b>2.2	Justificativa do Projeto e indicadores de sucesso do projeto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="justificativa" name="justificativa" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,400,'spcontando2');contarCaracteresEtapa4(this.value,400,'sprestante2')"></textarea>
							<p class="hint">[Como ser� determinado se o projeto foi um sucesso ou um fracasso, justificativa do projeto e quais indicadores ser�o usados. Exemplo: O projeto ser� considerado um sucesso se atender a todos os crit�rios de aceita��o das entregas, respeitar as restri��es e cumprir o cronograma de execu��o e principalmente atender os requisitos e padr�es de qualidade detalhados nesse plano.]</p>
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
								<b>2.3	M�tricas da Qualidade <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="metrica" name="metrica" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,400,'spcontando3');contarCaracteresEtapa5(this.value,400,'sprestante3')"></textarea>
							<p class="hint">[Uma m�trica de qualidade � uma defini��o operacional que descreve, em termos bem espec�ficos, um atributo do projeto ou do produto, e como o processo de controle da qualidade ir� medi-lo. Uma m�trica � medida e possui um valor real. Liste os padr�es e requisitos de qualidade usados e como ser�o satisfeitos. Para os padr�es de mercado, referenciar a Norma ABNT ou Internacional, e para os padr�es da empresa, referenciar o procedimento do SGQ (Sistema de Gest�o da Qualidade) ou documento de refer�ncia. Anexar os documentos referenciados. Lembre-se, requisito da qualidade � uma condi��o ou aptid�o de um atributo do projeto. Para atender um requisito da qualidade, voc� pode usar um ou mais indicadores.]</p>
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
								<b>2.4	Ferramentas de Qualidade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="ferramentaqualidade" name="ferramentaqualidade" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,400,'spcontando4');contarCaracteresEtapa6(this.value,400,'sprestante4')"></textarea>
							<p class="hint">[Lista as ferramentas de qualidade que o projeto empregar�. Descreve como ser�o usadas e o respons�vel por isso. Exemplo: Ferramenta, descri��o da aplica��o, quando aplicar e respons�vel.]</p>
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
								<b>2.5	Entregas do Projeto e Crit�rios de Aceita��o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="entregaprojetoaceitacao" name="entregaprojetoaceitacao" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,400,'spcontando5');contarCaracteresEtapa7(this.value,400,'sprestante5')"></textarea>
							<p class="hint">[Baseado nos requisitos de qualidade da se��o m�tricas de qualidade, descreva as entregas necess�rias para cumpri-los, seus crit�rios de aceita��o e como e quando (checkpoint) ser�o validados. Exemplo: C�digo EAP, entrega, Crit�rioas de aceita��o e quando ser� verificado.]</p>
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
								<b>3 GARANTIA DE QUALIDADE DO PROJETO<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="garantiaqualidade" name="garantiaqualidade" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,400,'spcontando6');contarCaracteresEtapa8(this.value,400,'sprestante6')"></textarea>
							<p class="hint">[Define atividades do processo Realizar a garantia da qualidade incluindo auditorias, e melhoria cont�nua. ]</p>
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
								<b>3.1	Auditorias do Projeto & Revis�es de Qualidade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="auditoria" name="auditoria" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,400,'spcontando7');contarCaracteresEtapa9(this.value,400,'sprestante7')"></textarea>
							<p class="hint">[An�lise estruturada e independente que busca identificar pol�ticas, processos e procedimentos ineficientes e ineficazes em uso no projeto e n�o aderentes �s pol�ticas e procedimentos do projeto e da empresa. Exemplo: Revis�o de qualidade, data prevista, auditor respons�vel e coment�rios.]</p>
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
								<b>3.2	Processos de Melhoria Cont�nua<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="processomelhoria" name="processomelhoria" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,400,'spcontando8');contarCaracteresEtapa10(this.value,400,'sprestante8')"></textarea>
							<p class="hint">[Meio iterativo de melhorar a qualidade de todos os processos. Reduz o desperd�cio e elimina as atividades que n�o agregam valor, permitindo que os processos sejam operados com n�veis mais altos de efici�ncia e efic�cia. ]</p>
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
								<b>3.3	Responsabilidades de Qualidade da Equipe do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="responsabilidadequalidade" name="responsabilidadequalidade" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,400,'spcontando9');contarCaracteresEtapa11(this.value,400,'sprestante9')"></textarea>
							<p class="hint">[Descreva as responsabilidades referentes aos processos de qualidade de cada membro do projeto, mesmo que j� citados em outros t�picos do documento. Exemplo: Menbro da equipe e responsabilidades.]</p>
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
								<b>3.4	Log de Auditoria da Qualidade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="logauditoria" name="logauditoria" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,400,'spcontando10');contarCaracteresEtapa12(this.value,400,'sprestante10')"></textarea>
							<p class="hint">[Data de revis�o, atividade revisada, pontos de aten��o e resolu��o.]</p>
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
								<b>4	CONTROLE DE QUALIDADE DO PROJETO<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="controlequalidade" name="controlequalidade" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,400,'spcontando14');contarCaracteresEtapa16(this.value,400,'sprestante14')"></textarea>
							<p class="hint">[Descreva os procedimentos do processo Controlar a qualidade, como as inspe��es, que ser�o feitas, etc. Segue abaixo um exemplo. ]</p>
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
								<b>4.1	Procedimentos de Inspe��o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="procedimentoinspecao" name="procedimentoinspecao" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,400,'spcontando15');contarCaracteresEtapa17(this.value,400,'sprestante15')"></textarea>
							<p class="hint">[A inspe��o ser� realizada na conclus�o de cada entrega utilizando-se CheckList apresentado em anexo e respectivamente, os seus indicadores, a fim de manter a qualidade do projeto e alimentar o processo de melhoria cont�nua.]</p>
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
								<b>4.2	Procedimentos de Monitoramento<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="procedimentomonitoramento" name="procedimentomonitoramento" required="true"
								onkeyup="mostrarResultadoEtapa18(this.value,400,'spcontando16');contarCaracteresEtapa18(this.value,400,'sprestante16')"></textarea>
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
					</tr>
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
								onkeyup="mostrarResultadoEtapa19(this.value,400,'spcontando17');contarCaracteresEtapa19(this.value,400,'sprestante17')"></textarea>
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
