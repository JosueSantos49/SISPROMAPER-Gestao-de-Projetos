<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PlanoGerenciamentoRH"%>
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

<title>Atualizar Plano de Gerenciamento dos Recursos Humanos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereRH.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarPlanoGerenciamentoRH";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planogerenciamentoRH").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DOS RECURSOS HUMANOS</font></th></tr></table><br>				
				<center>
					<h3>
						<font color="red"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigat�rio.<br></font>
					</p>
					<br>
				</div>
				<br> 
				<input type="hidden" name="cmd" value="atualizarPlanoGerenciamentoRH"></input>
				<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modifica��o -->
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
						<td><p align="justify"><b>Plano de Gerenciamento do RH <font color="red">*</font></b></p>
						<p align="justify">
								<input id="planogerenciamentorh" name="planogerenciamentorh"
									style="height: 30px; width: 379px" maxlength="150"
									value="${planoGerenciamentoRH.planogerenciamentorh}" class="input" required="true"></input>
							<p class="hint">[Informar o Plano de Gerenciamento do RH.]</p></td>
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
									value="${planoGerenciamentoRH.projeto}" class="input" required="true"
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
									Placeholder=""
									value="${planoGerenciamentoRH.codigoprojeto}" class="input" required="true"
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
									value="${planoGerenciamentoRH.versao}" class="input" required="true"></input>
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
									value="${planoGerenciamentoRH.data}" class="input" required="true"
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
									value="${planoGerenciamentoRH.autor}" class="input" required="true"
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
									value="${planoGerenciamentoRH.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revis�o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivo do Plano de gerenciamento dos recursos humanos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,400,'spcontando0');contarCaracteresEtapa1(this.value,400,'sprestante0')">${planoGerenciamentoRH.objetivo}</textarea>
							<p class="hint">[Descreva o objetivo do Plano de gerenciamento dos recursos humanos. O Plano de gerenciamento dos recursos humanos fornece orienta��o sobre como os recursos humanos do projeto devem ser definidos, mobilizados, gerenciados, controlados e, por fim, liberados.]</p>
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
								<b>M�todo de gerenciamento dos Recursos Humanos <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="metodo" name="metodo" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,400,'spcontando');contarCaracteresEtapa2(this.value,400,'sprestante')">${planoGerenciamentoRH.metodo}</textarea>
							<p class="hint">[Use as se��es seguintes para identificar os componentes do Plano de gerenciamento dos recursos humanos ou modifique-as para encontrar suas necessidades. ]</p>
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
								<b>Processos de Recursos Humanos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="processo" name="processo" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,400,'spcontando1');contarCaracteresEtapa3(this.value,400,'sprestante1')">${planoGerenciamentoRH.processo}</textarea>
							<p class="hint">[Exemplo: Mobilizar a equipe do projeto, Desenvolver a equipe do projeto e Gerenciar a equipe do projeto.]</p>
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
								<b>Documentos padronizados de recursos humanos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="documento" name="documento" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,400,'spcontando2');contarCaracteresEtapa4(this.value,400,'sprestante2')">${planoGerenciamentoRH.documento}</textarea>
							<p class="hint">[Descreva os documentos padronizados a serem usadas nos processos das aquisi��es. Indique onde est�o armazenados, como ser�o usados, e os respons�veis envolvidos]</p>
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
								<b>Ferramentas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="ferramenta" name="ferramenta" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,400,'spcontando3');contarCaracteresEtapa5(this.value,400,'sprestante3')">${planoGerenciamentoRH.ferramenta}</textarea>
							<p class="hint">[Descreve as ferramentas que o projeto empregar� nos processos descritos neste plano, como ser�o usadas e seu respons�vel. ]</p>
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
								<b>Organograma do projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="organograma" name="organograma" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,400,'spcontando4');contarCaracteresEtapa6(this.value,400,'sprestante4')">${planoGerenciamentoRH.organograma}</textarea>
							<p class="hint">[Exibi��o gr�fica dos membros da equipe do projeto e suas rela��es hier�rquicas. .]</p>
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
								<b>Pap�is e Responsabilidades da Equipe do Projeto<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="papeis" name="papeis" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,400,'spcontando5');contarCaracteresEtapa7(this.value,400,'sprestante5')">${planoGerenciamentoRH.papeis}</textarea>
							<p class="hint">[Descreva os pap�is e suas responsabilidades, compet�ncias e autoridade necess�rias para concluir o projeto; onde:
											Papel: designa��o que descreve a parte de um projeto pela qual uma pessoa � respons�vel e responde pelos resultados. 
											Responsabilidade: trabalho que se espera que um membro da equipe do projeto execute para concluir as atividades do projeto.
											Autoridade: direito de aplicar recursos do projeto, tomar decis�es e aprovar.
											Compet�ncia: habilidade e capacidade necess�ria para concluir atividades do projeto.]</p>
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
								<b>Plano de gerenciamento de pessoal<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="planogerenciamento" name="planogerenciamento" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,400,'spcontando6');contarCaracteresEtapa8(this.value,400,'sprestante6')">${planoGerenciamentoRH.planogerenciamento}</textarea>
							<p class="hint">[Descreva quando e como os requisitos de recursos humanos ser�o atendidos.]</p>
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
								<b>Mobiliza��o do pessoal<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="mobilizacao" name="mobilizacao" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,400,'spcontando7');contarCaracteresEtapa9(this.value,400,'sprestante7')">${planoGerenciamentoRH.mobilizacao}</textarea>
							<p class="hint">[Descreva como a equipe ser� mobilizada respondendo quest�es como:
											De onde vir�o os recursos humanos? (Da organiza��o ou de fontes externas contratadas) 
											Onde a equipe executar� seus trabalhos? (�nico Local, v�rias localiza��es)]</p>
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
								<b>Calend�rios dos recursos<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="calendario" name="calendario" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,400,'spcontando8');contarCaracteresEtapa10(this.value,400,'sprestante8')">${planoGerenciamentoRH.calendario}</textarea>
							<p class="hint">[Descreva os intervalos de tempo necess�rios para membros da equipe do projeto, individual ou coletivamente, e tamb�m quando as atividades de mobiliza��o (como o recrutamento) devem come�ar. ]</p>
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
								<b>Plano de libera��o de pessoal<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="planoliberacao" name="planoliberacao" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,400,'spcontando9');contarCaracteresEtapa11(this.value,400,'sprestante9')">${planoGerenciamentoRH.planoliberacao}</textarea>
							<p class="hint">[Determine como e quando liberar os membros da equipe. Quando membros da equipe s�o liberados de um projeto, os custos associados a esses recursos n�o s�o mais lan�ados no projeto, o que reduz os custos do projeto. A motiva��o melhora quando transi��es suaves para os projetos futuros j� est�o planejadas. Um plano de libera��o de pessoal tamb�m ajuda a reduzir os riscos de recursos humanos que podem ocorrer durante ou no fim de um projeto.]</p>
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
								<b>Necessidades de treinamento<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="necessidade" name="necessidade" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,400,'spcontando10');contarCaracteresEtapa12(this.value,400,'sprestante10')">${planoGerenciamentoRH.necessidade}</textarea>
							<p class="hint">[Determine como e quando os membros da equipe obter�o as compet�ncias necess�rias. Inclua formas de ajudar os membros da equipe a obter certifica��es que comprovariam sua capacidade para beneficiar o projeto.]</p>
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
								<b>Reconhecimento e recompensas<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="reconhecimento" name="reconhecimento" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,400,'spcontando14');contarCaracteresEtapa16(this.value,400,'sprestante14')">${planoGerenciamentoRH.reconhecimento}</textarea>
							<p class="hint">[Estabele�a crit�rios claros para recompensas e um sistema planejado para seu uso de modo a promover e refor�ar os comportamentos desejados. Para serem eficazes, o reconhecimento e as recompensas devem se basear em atividades e desempenho que possam ser controlados por uma pessoa. ]</p>
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
								<b>Conformidade<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="conformidade" name="conformidade" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,400,'spcontando15');contarCaracteresEtapa17(this.value,400,'sprestante15')">${planoGerenciamentoRH.conformidade}</textarea>
							<p class="hint">[Defina as estrat�gias para cumprimento das regulamenta��es do governo aplic�veis, contratos com sindicatos e outras pol�ticas de recursos humanos estabelecidas. ]</p>
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
								<b>Seguran�a<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="seguranca" name="seguranca" required="true"
								onkeyup="mostrarResultadoEtapa18(this.value,400,'spcontando16');contarCaracteresEtapa18(this.value,400,'sprestante16')">${planoGerenciamentoRH.seguranca}</textarea>
							<p class="hint">[Identifique as pol�ticas e procedimentos que protegem os membros da equipe contra riscos de seguran�a.]</p>
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
								onkeyup="mostrarResultadoEtapa19(this.value,400,'spcontando17');contarCaracteresEtapa19(this.value,400,'sprestante17')">${planoGerenciamentoRH.aprovacao}</textarea>
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
