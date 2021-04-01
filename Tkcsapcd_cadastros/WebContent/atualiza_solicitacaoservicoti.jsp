<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.SolicitacaoServicoTI"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<%@page import="br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>

<%@include file="include.jsp" %>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar SSTI</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->



<script type="text/javascript">
/*função valida email*/
function valida_form()
	{
	var x=document.forms["formulario"]["email"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
	alert("Não é um endereço de e-mail válido!\n\nEntre com um endereço de e-mail válido.");
	return false;
	}
	return true;
}
</script>

<!-- MASCARA PARA TRATAMENTO DE ERRO -->
<script>
	$(document).ready(function(){
		$('#telefonecontato').mask("99-99999-9999");
		$("#datasolicitacao").mask("99/99/9999"); 	    	    
	});
</script>

<script>
	$(function() {
	$("#datasolicitacao").datepicker({
		dateFormat: 'dd/mm/yy',
		showOn : "button",
		buttonImage : "img/calendar.gif",
		buttonImageOnly : true
	});
});
</script>

<script>
	function show_confirm()
	{
		
		var r=confirm("Click em OK, para continuar!");
		if(r==true)
			{
			alert("Continuando...");
			return true;
			}
		else
			{
				alert("Click em OK, para cancelar!");
				location.href="TkcsapcdController?cmd=consultarSolicitacaoServicoTI";
				
			}		
}
</script>

<script type="text/javascript">	function setFocus() {	document.getElementById("codigoprojeto").focus(); }</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<div class="resp"></div>

<div align="center"><center><h3><font color="red">${mensagem}</font></h3></center><br></div>

<form action="TkcsapcdController" id="formulario"	name="formulario" enctype="multipart/form-data" onsubmit="validaCadastrarSolicicatcaoServicoTI()" >	
		
		<ul id="progress">
			<li class="ativo">Identificação Solicitante</li>
			<li>Identificação da Demanda</li>
			<li>Estimativa de custo</li>			
		</ul>
				
		<input type="hidden" name="cmd" value="atualizarSolicitacaoServicoTI"></input>
		<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->	
	
			<fieldset>	
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">SOLICITAÇÃO DE SERVIÇO DE TECNOLOGIA DA INFORMAÇÃO</font></th></tr></table><br>		
			
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>							
							<tr class="field">
								<td><p align="justify"><b>Código do Projeto <font color="red">*</font></b></td>
								<td><p align="justify">									
									<input id="codigoprojeto" name="codigoprojeto" maxlength="11" style="height: 30px; width: 150px" class="input" onkeypress="return numbers(event);" value="${solicitacaoServicoTI.codigoprojeto}" required="true"></input>									
									<p class="hint">[Informar o projeto da SSTI.]</p>
								</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>					 				
							<tr class="field">
								<td><p align="justify"><b>Código SSTI <font color="red">*</font></b></td>
								<td><p align="justify"><input id="codigosolicitaoservico" name="codigosolicitaoservico"
									style="height: 30px; width: 150px" class="input" onkeypress="return numbers(event);" value="${solicitacaoServicoTI.codigosolicitaoservico}" required="true"></input>
									<p class="hint">[Informar o código de solicitacao de serviço da Técnologia da Informação.]</p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field">
								<td><p align="justify"><b>Área <font color="red">*</font></b></td>
								<td><p align="justify"><input id="area" name="area"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.area}" required="true" onkeypress="return Letras(event);"></input>
									<p class="hint">[Informar a área.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Responsável pela demanda <font color="red">*</font></b></td>
								<td><p align="justify"><font color="blue"></font></P>
								<p align="justify">
								<input id="responsaveldemanda" name="responsaveldemanda"
									style="height: 30px; width: 379px" class="input" onkeypress="return Letras(event);" value="${solicitacaoServicoTI.responsaveldemanda}" required="true" Placeholder="Digitar nome completo!"></input>
								<p class="hint">[Informar o nome do gerente do projeto.]</p></p></td>
								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Telefone de Contato <font color="red">*</font></b></td>
								<td><p align="justify"><input id="telefonecontato" name="telefonecontato"
									style="height: 30px; width: 150px" class="input" value="${solicitacaoServicoTI.telefonecontato}" maxlength="13" required="true"></input>(xx.xxxxx.xxxx)
									<p class="hint">[Informar o telefone para contato.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>E-mail <font color="red">*</font></b></td>
								<td><p align="justify"><input id="email" name="email" 
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.email}" required="true" Placeholder="exemplo@exemplo.com.br"></input>
									<p class="hint">[Informar o e-mail para contato.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Data de Solicitação <font color="red">*</font></b></td>
								<td><p align="justify"><input id="datasolicitacao" name="datasolicitacao"
									style="height: 30px; width: 100px" class="input" value="${solicitacaoServicoTI.datasolicitacao}" required="true"></input>
									<p class="hint">[Informar a data de solicitação.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>ID <font color="red">*</font></b></td>
								<td><p align="justify"><input id="id" name="id"
									style="height: 30px; width: 130px" class="input" value="${solicitacaoServicoTI.id}" maxlength="8"></input>
									<p class="hint">[Informar o ID.]</p></td>
							</tr>
							<tr>
								<td><br>
									
								</td>								
							</tr>								
							</table>
								<input type="button" name="next1" class="next acao" value="Próximo" onchange="validaCadastrarSolicicatcaoServicoTI()" onclick="validaCadastrarSolicicatcaoServicoTI()">							
							</fieldset>
							
							<fieldset>							
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">
							
							<tr>
								<td><tr><th bgcolor="#FFFF00" width="300px"><font color="#4682B4" size="2">IDENTIFICAÇÃO DA DEMANDA</font><br></th></tr></td>								
							</tr>							
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Nome da Demanda <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="nomedemanda" name="nomedemanda" onkeyup="mostrarResultadoNomedemanda(this.value,200,'spcontando0');contarCaracteresNomedemanda(this.value,200,'sprestante0')">${solicitacaoServicoTI.nomedemanda}</textarea>
							 		<p class="hint">[Informar o nome da demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Objetivo da Demanda <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="objetivodemanda" name="objetivodemanda" onkeyup="mostrarObjetivoDemanda(this.value,200,'spcontando1');contarCaracteresObjetivoDemanda(this.value,200,'sprestante1')">${solicitacaoServicoTI.objetivodemanda}</textarea>
							 		<p class="hint">[Informar o objetivo da demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando1" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante1" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Decrição do Problema <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="decricaoproblema" name="decricaoproblema" onkeyup="mostrarResultadoDescricaoProblema(this.value,200,'spcontando3');contarCaracteresDescricaoProblema(this.value,200,'sprestante3')" required="true">${solicitacaoServicoTI.decricaoproblema}</textarea>
							 		<p class="hint">[Forneça uma descrição relatando os problemas que serão resolvidos pelo atendimento da demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando3" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante3" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Desenho do Processo <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="desenhoprocesso" name="desenhoprocesso" onkeyup="mostrarResultadoDesenhoProcesso(this.value,200,'spcontando4');contarCaracteresDesenhoProcesso(this.value,200,'sprestante4')">${solicitacaoServicoTI.desenhoprocesso}</textarea>
							 		<p class="hint">[Descrever o nível de maturidade do(s) processo(s) envolvido(s) na demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando4" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante4" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Funcionalidade <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="funcionalidade" name="funcionalidade" onkeyup="mostrarResultadoFuncionalidade(this.value,200,'spcontando5');contarCaracteresFuncionalidade(this.value,200,'sprestante5')">${solicitacaoServicoTI.funcionalidade}</textarea>
							 		<p class="hint">[Listar quais são as principais funcionalidade dessa demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando5" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante5" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><tr><th bgcolor="#FFFF00"><font color="#4682B4" size="2">PARTES ENVOLVIDAS</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Partes Envolvidas <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="parteenvolvida" name="parteenvolvida" onkeyup="mostrarResultadoParteenvolvida(this.value,200,'spcontando6');contarCaracteresParteenvolvida(this.value,200,'sprestante6')">${solicitacaoServicoTI.parteenvolvida}</textarea>
							 		<p class="hint">[Listar as pessoas envolvidas na apresentação dessa demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando6" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante6" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Parte Envolvida Representante <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="parteenvolvidarepresentante" name="parteenvolvidarepresentante" onkeyup="mostrarResultadoParteenvolvidaRepresentante(this.value,200,'spcontando7');contarCaracteresParteenvolvidaRepresentante(this.value,200,'sprestante7')">${solicitacaoServicoTI.parteenvolvidarepresentante}</textarea>
							 		<p class="hint">[Representante: Quem é o representante do envolvimento da demanda? Especifique o nome da pessoa.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando7" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante7" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Parte Envolvida/Forma Contato <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="parteenvolvidaformacontato" name="parteenvolvidaformacontato" onkeyup="mostrarResultadoParteenvolvidaFormaContato(this.value,200,'spcontando8');contarCaracteresParteenvolvidaFormaContato(this.value,200,'sprestante8')">${solicitacaoServicoTI.parteenvolvidaformacontato}</textarea>
							 		<p class="hint">[Forma de contato dos representantes, seja telefone e/ou e-mail.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando8" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante8" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Recursos <font color="red">*</font></b></td>
								<td><p align="justify"><input id="recursos" name="recursos"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.recursos}" maxlength="50"></input>
									<p class="hint">[Informar os recursos.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>								
							</table>
								<input type="button" name="prev" class="prev acao" value="Anterior" onchange="validaCadastrarSolicicatcaoServicoTI()" onclick="validaCadastrarSolicicatcaoServicoTI()">
								<input type="button" name="next2" class="next acao" value="Próximo" onchange="validaCadastrarSolicicatcaoServicoTI()" onclick="validaCadastrarSolicicatcaoServicoTI()">
							</fieldset>
							
							<fieldset>
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">
							
							<tr>
								<td><tr><th bgcolor="#FFFF00"><font color="#4682B4" size="2">ESTIMATIVA DE CUSTO</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Estimativa de Custo Global <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="estimativacustoglobal" name="estimativacustoglobal" onkeyup="mostrarResultadoEstimativacustoglobal(this.value,200,'spcontando9');contarCaracteresEstimativacustoglobal(this.value,200,'sprestante9')">${solicitacaoServicoTI.estimativacustoglobal}</textarea>
							 		<p class="hint">[Estimativa de Custo: Informe o valor GLOBAL previsto para essa demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando9" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante9" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Fonte de Finaciamento <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="fontefinanciamento" name="fontefinanciamento" onkeyup="mostrarResultadoFontefinaciamento(this.value,200,'spcontando10');contarCaracteresFontefinaciamento(this.value,200,'sprestante10')">${solicitacaoServicoTI.fontefinanciamento}
							 		</textarea><p class="hint">[Informe a fonte de financiamento que deverá ser utilizada para custeá a demanda.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando10" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante10" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Método Levantamento de Custo <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="metodolevantamentocusto" name="metodolevantamentocusto" onkeyup="mostrarResultadoMetodolevantamentocusto(this.value,200,'spcontando11');contarCaracteresMetodolevantamentocusto(this.value,200,'sprestante11')">${solicitacaoServicoTI.metodolevantamentocusto}</textarea>
							 		<p class="hint">[Informe quais foram os métodos utilizados para realizar o levantamento de orçamento.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando11" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante11" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Numero de Usuário Previsto <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="numerousuarioprevisto" name="numerousuarioprevisto" onkeyup="mostrarResultadoNumerousuarioprevisto(this.value,200,'spcontando12');contarCaracteresNumerousuarioprevisto(this.value,200,'sprestante12')">${solicitacaoServicoTI.numerousuarioprevisto}</textarea>
							 		<p class="hint">[Informe a quantidade total de usuários previsto para o projeto e que serão objeto de aquisição específica.]</p> <br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando12" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante12" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Treinamento do Pessoal <font color="red">*</font></b></td>
								<td><p align="justify"><input id="treinamentopessoal" name="treinamentopessoal"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.treinamentopessoal}" maxlength="50"></input>
									<p class="hint">[Informar o treinamento do pessoal.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Material de Apoio <font color="red">*</font></b></td>
								<td><p align="justify"><input id="materialapoio" name="materialapoio"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.materialapoio}" maxlength="50"></input>
									<p class="hint">[Informar o material de apoio.]</p></td>
							</tr>				 
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Restrição do Projeto <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="restricaoprojeto" name="restricaoprojeto" onkeyup="mostrarResultadoRestricaoprojeto(this.value,200,'spcontando13');contarCaracteresRestricaoprojeto(this.value,200,'sprestante13')">${solicitacaoServicoTI.restricaoprojeto}</textarea>
							 		<p class="hint">[Indique as restrições de prazos custos que possam afetar o futuro projeto de aquisição.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando13" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante13" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>								
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Principais Usuários <font color="red">*</font></b></td>
								<td><p align="justify">								
									<input id="principaisusuarios" name="principaisusuarios" maxlength="150" style="height: 30px; width: 150px" class="input" onkeypress="return Letras(event);" value="${solicitacaoServicoTI.principaisusuarios}" required="true"></input>									
									<p class="hint">[Informar os Principais Usuários.]</p>
								</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr class="field" >
							 	<td><p align="justify"><b>Necessidade dos Usuários <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="necessidadeusuario" name="necessidadeusuario" onkeyup="mostrarResultadoNecessidadeusuario(this.value,200,'spcontando14');contarCaracteresNecessidadeusuario(this.value,200,'sprestante14')">${solicitacaoServicoTI.necessidadeusuario}</textarea>
							 		<p class="hint">[Liste as principais necessidades dos usuários e stakeholders.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando14" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante14" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>				 
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Prioridade <font color="red">*</font></b></p></td>
								<td><p align="justify"><input id="prioridade" name="prioridade" 
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.prioridade}" onkeypress="return Letras(event);"></input>
									<p class="hint">[Informar a prioridade.]</p></p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>					 				
							<tr class="field"> 
								<td><p align="justify"><b>Solucao Atual <font color="red">*</font></b></td>
								<td><p align="justify"><input id="solucaoatual" name="solucaoatual"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.solucaoatual}"></input>
									<p class="hint">[Informar solução atual.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field">
								<td><p align="justify"><b>Problema c/ solucao atual <font color="red">*</font></b></td>
								<td><p align="justify"><input id="problemasolucaoatual" name="problemasolucaoatual"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.problemasolucaoatual}" ></input>
									<p class="hint">[Informar o problema c/ solução atual.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Solucao Proposta <font color="red">*</font></b></td>
								<td><p align="justify"><input id="solucaoproposta" name="solucaoproposta"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.solucaoproposta}"></input>
									<p class="hint">[Informar a solução prosta.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field" >
								<td><p align="justify"><b>Status <font color="red">*</font></b></td>
								<td><p align="justify"><input id="status" name="status"
									style="height: 30px; width: 379px" class="input" value="${solicitacaoServicoTI.status}" ></input>
								<p class="hint">Entre com o status.</p>	
								</td>
							</tr>
							<tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
				</table>
					<input type="button" name="prev" class="prev acao" value="Anterior"  onchange="validaCadastrarSolicicatcaoServicoTI()" onclick="validaCadastrarSolicicatcaoServicoTI()">
					<input type="submit" class="acao" value="Atualizar"  onclick="show_confirm()" onchange="validaCadastrarSolicicatcaoServicoTI()" onclick="validaCadastrarSolicicatcaoServicoTI()"></input><!--  -->
			</fieldset>				

<div class="demo-description">
<p>Click tabs to swap between content that is broken into logical sections.</p>
</div>				
</form>	
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>-->
<script type="text/javascript" src="js/functions.js"></script>
<script type="text/javascript" src="js/validaCadastrarSolicicatcaoServicoTI.js"></script>
<script language="javascript" src="js/TexteareCadastroSolicitacaoServicoTI.js"></script><!-- Textarea Tratamento de erro -->
<%@include file="rodape.jsp" %>
</body>
</html>