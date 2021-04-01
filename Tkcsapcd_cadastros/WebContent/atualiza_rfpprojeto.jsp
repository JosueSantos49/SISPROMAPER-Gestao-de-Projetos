<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.RfpProjeto"%>
<%@include file="include.jsp" %><!-- Depois que coloquei o include, a cor do tratamento de erro funcionou. -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar RFP-Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>

<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/jquery-cidades-estados.js"></script><!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->


<!-- IMPLMENTA A FUNÇÃO DE LISTA ESTADO E CIDADE -->
<script type="text/javascript">
window.onDomReady(function() {
  new dgCidadesEstados({
    estado: document.getElementById('estado'),
    cidade: document.getElementById('cidade')
  });
});
</script>

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
		$('#telefone').mask("99-99999-9999");
		$("#data").mask("99/99/9999"); 	    	    
	});
</script>

<script>
	$(function() {
	$("#data").datepicker({
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

<div class="resp"></div><!-- Resposta do Ajax -->

<div align="center"><center><h3><font color="red">${mensagem}</font></h3></center></div>

<form action="TkcsapcdController" id="formulario"	name="formulario" enctype="multipart/form-data" onsubmit="validaCadastrarRfpProjeto()" ><!-- onclick="validaCadastrarRfpProjeto()" -->

		<ul id="progress">
			<li class="ativo">ETAPA 1</li>
			<li>ETAPA 2</li>
			<li>ETAPA 3</li>			
		</ul>	
		
		<input type="hidden" name="cmd" value="atualizarFfpProjeto"></input>
		<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->		
		
		<fieldset>	
		
		<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">REQUEST FOR PROPOSAL</font></th></tr></table><br>	
		
		<br>
		<div align="left"><p><font color="red">Todas as informações incluídas neste RFP é confidencial e só para o conhecimento destinatário. Nenhuma informação contida neste documento ou em discussões conectados a ele podem ser divulgadas a qualquer outra parte.</font></p></div><br>
		<div align="left"><p><font color="red">Com este RFP solicitamos informações sobre sua empresa e seus produtos / serviços. As mesmas informações serão recolhidas a partir de diferentes empresas e será usado para avaliar o que os fornecedores que irá acompanhar o processo de terceirização.</font></p></div>
		
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							
							<tr>
								<td><br><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Código Projeto <font color="red">*</font></b></td>
								<td><p align="justify"><input id="codigoProjeto" name="codigoProjeto" class="input"
									style="height: 30px; width: 100px" value="${rfpprojeto.codigoProjeto}" onkeypress="return numbers(event);" required="true"></input>
									<p class="hint">[Informar o código.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>					 				
							<tr class="field">
								<td><p align="justify"><b>Código Item <font color="red">*</font></b></td>
								<td><p align="justify"><input id="itensProjeto" name="itensProjeto"
									style="height: 30px; width: 150px" class="input" onkeypress="return numbers(event);" value="${rfpprojeto.itensProjeto}" required="true"></input>
									<p class="hint">[Informar o código do item.]</p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field">
								<td><p align="justify"><b>Nome RFP <font color="red">*</font></b></td>
								<td><p align="justify"><input id="nomeRfpProjeto" name="nomeRfpProjeto"
									style="height: 30px; width: 379px" class="input" value="${rfpprojeto.nomeRfpProjeto}" required="true" onkeypress="return Letras(event);"></input>
									<p class="hint">[Informar o nome da RFP.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Nome da Empresa<font color="red">*</font></b></td>
								<td><p align="justify"><font color="blue"></font></P>
								<p align="justify">
								<input id="nomeempresa" name="nomeempresa"
									style="height: 30px; width: 379px" class="input" onkeypress="return Letras(event);" value="${rfpprojeto.representante}" required="true" Placeholder="Digitar nome completo!"></input>
								<p class="hint">[Informar o nome da organização.]</p></p></td>
								
							</tr>
							<tr>
								<td><br></td>
							</tr>							
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Telefone de Contato <font color="red">*</font></b></td>
								<td><p align="justify"><input id="telefone" name="telefone"
									style="height: 30px; width: 150px" class="input" value="${rfpprojeto.telefone}" required="true"></input>(dd-xxxxx-xxxx)
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
								<td><p align="justify"><input id="emailrepresentante" name="emailrepresentante" 
									style="height: 30px; width: 379px" class="input" value="${rfpprojeto.emailrepresentante}" required="true" Placeholder="exemplo@exemplo.com.br"></input>
									<p class="hint">[Informar o e-mail para contato.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Endereço <font color="red">*</font></b></td>
								<td><p align="justify"><input id="endereco" name="endereco"
									style="height: 30px; width: 379px" class="input" value="${rfpprojeto.endereco}" maxlength="50"></input>
									<p class="hint">[Informar o endereço.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Estado <font color="red">*</font></b></td>
								<td><p align="justify"><select id="estado" name="estado" value="${rfpprojeto.estado}"></select>
								<p class="hint">[Informar o estado.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Cidade <font color="red">*</font></b></td>
								<td><p align="justify"><select id="cidade" name="cidade" value="${rfpprojeto.cidade}"></select>
								<p class="hint">[Informar a cidade.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>					 				
							<tr class="field">
								<td><p align="justify"><b>Numero<font color="red">*</font></b></td>
								<td><p align="justify"><input id="numero" name="numero"
									style="height: 30px; width: 150px" class="input" onkeypress="return numbers(event);" value="${rfpprojeto.numero}" required="true"></input>
									<p class="hint">[Informar o numero.]</p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Bairro <font color="red">*</font></b></td>
								<td><p align="justify"><input id="bairro" name="bairro"
									style="height: 30px; width: 379px" class="input" value="${rfpprojeto.bairro}" maxlength="50"></input>
									<p class="hint">[Informar o bairro.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Data <font color="red">*</font></b></td>
								<td><p align="justify"><input id="data" name="data"
									style="height: 30px; width: 100px" class="input" value="${rfpprojeto.data}" required="true"></input>
									<p class="hint">[Informar a data.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>CEP <font color="red">*</font></b></td>
								<td><p align="justify"><input id="cep" name="cep"
									style="height: 30px; width: 130px" class="input" value="${rfpprojeto.cep}" maxlength="8"></input>
									<p class="hint">[Informar o CEP.]</p></td>
							</tr>
							<tr>
								<td><br></td>								
							</tr>
							<tr>
								<td><br>
									
								</td>								
							</tr>								
							</table>
								<input type="button" name="nextRFPProjeto1" class="next acao" value="Próximo" onchange="validaCadastrarRfpProjeto()" onclick="validaCadastrarRfpProjeto()">							
							</fieldset>
							
							<fieldset>
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td><tr><th bgcolor="#FFFF00" width="300px"><font color="#4682B4" size="2">Missão - Visão - Valor</font><br></th></tr></td>								
							</tr>	
							<tr class="field">
								<td><p align="justify"><b>Representante da Empresa<font color="red">*</font></b></td>
								<td><p align="justify"><font color="blue"></font></P>
								<p align="justify">
								<input id="representante" name="representante"
									style="height: 30px; width: 379px" class="input" onkeypress="return Letras(event);" value="${rfpprojeto.representante}" required="true" Placeholder="Digitar nome completo!"></input>
								<p class="hint">[Informar o nome do representante da empresa.]</p></p></td>
								
							</tr>						
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Histórico da Empresa<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="historicoempresa" name="historicoempresa" onkeyup="mostrarResultadoHistorico(this.value,200,'spcontando0');contarCaracteresHistorico(this.value,200,'sprestante0')">${rfpprojeto.historicoempresa}</textarea>
							 		<p class="hint">[Informar o histórico da organização.]</p><br><br>
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
							 	<td><p align="justify"><b>Produto <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="produtoempresa" name="produtoempresa" onkeyup="mostrarObjetivoProduto(this.value,200,'spcontando1');contarCaracteresObjetivoProduto(this.value,200,'sprestante1')">${rfpprojeto.produtoempresa}</textarea>
							 		<p class="hint">[Informar o produto.]</p><br><br>
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
							 	<td><p align="justify"><b>Mercado <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="mercadoempresa" name="mercadoempresa" onkeyup="mostrarResultadoDescricaoMercado(this.value,200,'spcontando3');contarCaracteresDescricaoMercado(this.value,200,'sprestante3')" required="true">${rfpprojeto.mercadoempresa}</textarea>
							 		<p class="hint">[Forneça uma descrição sobre a empresa no mercado.]</p><br><br>
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
							 	<td><p align="justify"><b>Valor <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="valoresempresa" name="valoresempresa" onkeyup="mostrarResultadoValor(this.value,200,'spcontando4');contarCaracteresValor(this.value,200,'sprestante4')">${rfpprojeto.valoresempresa}</textarea>
							 		<p class="hint">[Descrever o valor.]</p><br><br>
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
							 	<td><p align="justify"><b>Aquisição <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="aquisicao" name="aquisicao" onkeyup="mostrarResultadoAquisicao(this.value,200,'spcontando5');contarCaracteresAquisicao(this.value,200,'sprestante5')">${rfpprojeto.aquisicao}</textarea>
							 		<p class="hint">[Descrever o contexto geral da aquisição.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando5" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante5" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							</table>
								<input type="button" name="prev" class="prev acao" value="Anterior" onchange="validaCadastrarRfpProjeto()" onclick="validaCadastrarRfpProjeto()">
								<input type="button" name="nextRFPProjeto2" class="next acao" value="Próximo" onchange="validaCadastrarRfpProjeto()" onclick="validaCadastrarRfpProjeto()">
							</fieldset>
							
							<fieldset>
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">
							<tr>
								<td><tr><th bgcolor="#FFFF00" width="300px"><font color="#4682B4" size="2">PARTES ENVOLVIDAS</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Escopo <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="escopo" name="escopo" onkeyup="mostrarResultadoEscopo(this.value,200,'spcontando6');contarCaracteresEscopo(this.value,200,'sprestante6')">${rfpprojeto.escopo}</textarea>
							 		<p class="hint">[Delimitar o que faz parte do produto a ser gerado e que trabalho será realizado.]</p><br><br>
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
							 	<td><p align="justify"><b>Restrições <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="restricao" name="restricao" onkeyup="mostrarResultadoRestricao(this.value,200,'spcontando7');contarCaracteresRestricao(this.value,200,'sprestante7')">${rfpprojeto.restricao}</textarea>
							 		<p class="hint">[Descrever tudo que limita o projeto.]</p><br><br>
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
							 	<td><p align="justify"><b>Recurso<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="recurso" name="recurso" onkeyup="mostrarResultadoRecurso(this.value,200,'spcontando8');contarCaracteresRecurso(this.value,200,'sprestante8')">${rfpprojeto.recurso}</textarea>
							 		<p class="hint">[Descrição dos recursos necessários e das localidades onde serão executados os trabalhos.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando8" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante8" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><tr><th bgcolor="#FFFF00"><font color="#4682B4" size="2">ESTIMATIVA DE CUSTO</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Avaliação <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="avaliacao" name="avaliacao" onkeyup="mostrarResultadoAvaliacao(this.value,200,'spcontando9');contarCaracteresAvaliacao(this.value,200,'sprestante9')">${rfpprojeto.avaliacao}</textarea>
							 		<p class="hint">[Definir como o trabalho será avaliado (critério, descrição, métrica, etc).]</p><br><br>
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
							 	<td><p align="justify"><b>Cronograma <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="cronograma" name="cronograma" onkeyup="mostrarResultadoCronograma(this.value,200,'spcontando10');contarCaracteresCronograma(this.value,200,'sprestante10')">${rfpprojeto.cronograma}</textarea>
							 		<p class="hint">[Detalhar o cronograma (data final do projeto, data final do projeto, etc).]</p><br><br>
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
							 	<td><p align="justify"><b>Proposta <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="proposta" name="proposta" onkeyup="mostrarResultadoProposta(this.value,200,'spcontando11');contarCaracteresProposta(this.value,200,'sprestante11')">${rfpprojeto.proposta}</textarea>
							 		<p class="hint">[Descrever o formato da proposta.]</p> <br><br>
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
							 	<td><p align="justify"><b>Condições de Proposta <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="condicaoproposta" name="condicaoproposta" onkeyup="mostrarResultadoCondicaoproposta(this.value,200,'spcontando12');contarCaracteresCondicaoproposta(this.value,200,'sprestante12')">${rfpprojeto.condicaoproposta}</textarea>
							 		<p class="hint">[Descrever informações sobre propriedade, regras contratuais, garantia, multas, bônus e responsabilidades, disputa e foro..]</p><br><br>
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
							<tr class="field" >
							 	<td><p align="justify"><b>Observações <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="observacao" name="observacao" onkeyup="mostrarResultadoObservacao(this.value,200,'spcontando13');contarCaracteresObservacao(this.value,200,'sprestante13')">${rfpprojeto.observacao}</textarea>
							 		<p class="hint">[Caso, necessário decreva a observação.]</p><br><br>
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
				</table>
					<input class="prev acao" type="button" name="prev" value="Anterior"  onchange="validaCadastrarRfpProjeto()" onclick="validaCadastrarRfpProjeto()">
					<input class="acao" type="submit" value="Atualizar"  onclick="show_confirm()" onchange="validaCadastrarRfpProjeto()" onclick="validaCadastrarRfpProjeto()"></input><!--  -->
					<input class="acao" type="button" name="cancelar" onclick="document.location.href='sair.jsp'" value="Sair" title="Encerrar sessão" />								
			</fieldset>				

<div class="demo-description">
<p>Click tabs to swap between content that is broken into logical sections.</p>
</div>				
</form>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>-->
<script type="text/javascript" src="js/functionsRFPProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarRfpProjeto.js"></script>
<script language="javascript" src="js/TexteareCadastroRFPProjeto.js"></script><!-- Textarea Tratamento de erro -->
<%@include file="rodape.jsp" %>
</body>
</html>