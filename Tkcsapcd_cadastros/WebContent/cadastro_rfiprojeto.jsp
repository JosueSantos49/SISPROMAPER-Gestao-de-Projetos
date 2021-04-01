<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.RfiProjeto"%>
<%@include file="include.jsp" %><!-- Depois que coloquei o include, a cor do tratamento de erro funcionou. -->

<%@include file="include.jsp" %>

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("1") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Cadastrar RFI Projeto</title>

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
function valida_form(){
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
				location.href="index.jsp";
				
			}		
}
</script>

<script type="text/javascript">	function setFocus() {	document.getElementById("codigoprojeto").focus(); }</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 3200); tamanhooriginal(); setFocus();">

<%@include file="menuperantecsslivre_rfp_rfi_rfq.jsp" %>

<br><div class="resp"></div>

<div align="center"><center><h3><font color="green">${mensagem}</font></h3></center></div>

<form action="TkcsapcdController" id="formulario"	name="formulario" enctype="multipart/form-data" onsubmit="validaCadastrarRfiProjeto()" >

		<!-- <ul id="progress">
			<li class="ativo">ETAPA 1</li>
			<li>ETAPA 2</li>
			<li>ETAPA 3</li>			
		</ul> -->	
		
		<input type="hidden" name="cmd" value="cadastrarRfiProjeto"></input>		
		
		<fieldset>	
		
		<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">SOLICITAÇÃO DE INFORMAÇÃO - RFI</font></th></tr></table><br>	
		
		<br>
		<div align="left"><p><font color="red">Todas as informações incluídas neste RFI é confidencial e só para o conhecimento destinatário. Nenhuma informação contida neste documento ou em discussões conectados a ele podem ser divulgadas a qualquer outra parte.</font></p></div><br>
		<div align="left"><p><font color="red">Com este RFI solicitamos informações sobre sua empresa e seus produtos / serviços. As mesmas informações serão recolhidas a partir de diferentes empresas e será usado para avaliar o que os fornecedores que irá acompanhar o processo de terceirização com uma RFP ou RFQ.</font></p></div>
		
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td><br></td>
							</tr>		
							<tr>
								<td><br><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>CNPJ <font color="red">*</font></b></td>
								<td><p align="justify"><input id="cnpj" name="cnpj"
									style="height: 30px; width: 150px" class="input" maxlength="14" value="${rfiprojeto.cnpj}" required="true"></input>Somente numeros
									<p class="hint">[Informar o CNPJ.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Nome da Empresa <font color="red">*</font></b></td>
								<td><p align="justify">
								<input id="nome" name="nome" class="input"
									style="height: 30px; width: 379px" value="${rfiprojeto.nome}" onkeypress="return Letras(event);" maxlength="100" required="true" Placeholder="Digitar nome completo!"></input>
									<p class="hint">[Informar o nome da empresa.]</p></td>
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
									style="height: 30px; width: 379px" class="input" value="${rfiprojeto.endereco}" required="true" maxlength="100"></input>
									<p class="hint">[Informar o endereço da empresa.]</p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field">
								<td><p align="justify"><b>Página da Web <font color="red">*</font></b></td>
								<td><p align="justify"><input id="paginaweb" name="paginaweb"
									style="height: 30px; width: 379px" class="input" maxlength="50" value="${rfiprojeto.paginaweb}" required="true" Placeholder="www.exemplo.com.br"></input>
									<p class="hint">[Informar a página da Web da empresa.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Ano no mercado<font color="red">*</font></b></td>
								<td><p align="justify"><font color="blue"></font></P>
								<p align="justify">
								<input id="anosmercado" name="anosmercado"
									style="height: 30px; width: 100px" class="input" value="${rfiprojeto.anosmercado}"  onkeypress="return numbers(event);" maxlength="4" required="true" suportemundial></input>
								<p class="hint">[Informar o periodo da empresa no mercado.]</p></p></td>
								
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
									style="height: 30px; width: 150px" class="input" maxlength="15" value="${rfiprojeto.telefone}" required="true"></input>(ddd-xxxxx-xxxx)
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
									style="height: 30px; width: 379px" class="input" maxlength="50" value="${rfiprojeto.email}" required="true" Placeholder="exemplo@exemplo.com.br"></input>
									<p class="hint">[Informar o e-mail para contato.]</p></td>
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
							</table>
								<input type="button" name="nextRFIProjeto1" class="next acao" value="Próximo" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()" onclick="show_confirm()">							
							</fieldset>
							
							<fieldset>
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td><tr><th bgcolor="#FFFF00" width="300px"><font color="#4682B4" size="2">ETAPA - 2</font><br></th></tr></td>								
							</tr>						
							<tr>
								<td><br></td>
							</tr>
							
							<tr class="field">
								<td><p align="justify"><b>Localização <font color="red">*</font></b></td>
								<td><p align="justify"><input id="localizacao" name="localizacao"
									style="height: 30px; width: 379px" class="input" value="${rfiprojeto.localizacao}" maxlength="100"></input>
									<p class="hint">[Informar a localização.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
								
							<tr class="field">
							 	<td><p align="justify"><b>Produto/Serviço<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="produtoservico" name="produtoservico" onkeyup="mostrarResultadoProdutoservico(this.value,320,'spcontando0');contarCaracteresProdutoservico(this.value,320,'sprestante0')"></textarea>
							 		<p class="hint">[Informar os principais produtos e serviço.]</p><br><br>
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
							 	<td><p align="justify"><b>Mercado/Cliente <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font>
							 		<textarea  id="mercadocliente" name="mercadocliente" onkeyup="mostrarObjetivoMercadocliente(this.value,320,'spcontando1');contarCaracteresMercadocliente(this.value,320,'sprestante1')"></textarea>
							 		<p class="hint">[Informar o principal mercado e cliente.]</p><br><br>
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
							 	<td><p align="justify"><b>Estrutura da propriedade <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="estruturapropriedade" name="estruturapropriedade" onkeyup="mostrarResultadoDescricaoEstruturapropriedade(this.value,320,'spcontando3');contarCaracteresDescricaoEstruturapropriedade(this.value,320,'sprestante3')" required="true"></textarea>
							 		<p class="hint">[Forneça a estrutura de propriedade com status de propriedade em percentagem.]</p><br><br>
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
							 	<td><p align="justify"><b>Estrutura da empresa <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="estruturaempresa" name="estruturaempresa" onkeyup="mostrarResultadoEstruturaempresa(this.value,320,'spcontando4');contarCaracteresEstruturaempresa(this.value,320,'sprestante4')"></textarea>
							 		<p class="hint">[Descrever a estrutura da empresa, parcerias ou outras relações relevantes.]</p><br><br>
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
							 	<td><p align="justify"><b>Gestão Ambiental<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="gestaoambiental" name="gestaoambiental" onkeyup="mostrarResultadoGestaoambiental(this.value,320,'spcontando5');contarCaracteresGestaoambiental(this.value,320,'sprestante5')"></textarea>
							 		<p class="hint">[Descrever o sistema (s) de gestão ambiental da empresa.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando5" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante5" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							</table>
								<input type="button" name="prev" class="prev acao" value="Anterior" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()">
								<input type="button" name="nextRFIProjeto2" class="next acao" value="Próximo" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()">
							</fieldset>
							
							<fieldset>
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">
							<tr>
								<td><tr><th bgcolor="#FFFF00" width="300px"><font color="#4682B4" size="2">ETAPA 3</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
								<td><p align="justify"><b>Ultimo Lucro no Ano <font color="red">*</font></b></td>
								<td><p align="justify"><input id="ultimolucroano" name="ultimolucroano" class="input"
									style="height: 30px; width: 320px" maxlength="50" value="${rfiprojeto.ultimolucroano}"  onkeypress="return numbers(event);" required="true"></input>
									<p class="hint">[Informar o ultimo lucro do ano.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Gestão Qualidade <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="gestaoqualidade" name="gestaoqualidade" onkeyup="mostrarResultadoGestaoqualidade(this.value,320,'spcontando6');contarCaracteresGestaoqualidade(this.value,320,'sprestante6')"></textarea>
							 		<p class="hint">[Descrever o sistema (s) de gestão da qualidade da empresa.]</p><br><br>
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
							 	<td><p align="justify"><b>Gestão Negócio <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="gestaonegocio" name="gestaonegocio" onkeyup="mostrarResultadoGestaonegocio(this.value,320,'spcontando7');contarCaracteresGestaonegocio(this.value,320,'sprestante7')"></textarea>
							 		<p class="hint">[Descreva a sua gestão de continuidade de negócios.]</p><br><br>
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
							 	<td><p align="justify"><b>Quadro Funcionario<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="funcionario" name="funcionario" onkeyup="mostrarResultadoFuncionario(this.value,320,'spcontando8');contarCaracteresFuncionario(this.value,320,'sprestante8')"></textarea>
							 		<p class="hint">[Descrição do qaudro de funcionário.]</p><br><br>
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
							 	<td><p align="justify"><b>Produção <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="producao" name="producao" onkeyup="mostrarResultadoProducao(this.value,320,'spcontando9');contarCaracteresProducao(this.value,320,'sprestante9')"></textarea>
							 		<p class="hint">[Definir a produção.]</p><br><br>
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
							 	<td><p align="justify"><b>Marketing de vendas <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="marketingvendas" name="marketingvendas" onkeyup="mostrarResultadoMarketingvendas(this.value,320,'spcontando10');contarCaracteresMarketingvendas(this.value,320,'sprestante10')"></textarea>
							 		<p class="hint">[Detalhar o marketing de vendas da empresa.]</p><br><br>
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
							 	<td><p align="justify"><b>Departamento de Qualidade <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="departamentoqualidade" name="departamentoqualidade" onkeyup="mostrarResultadoDepartamentoqualidade(this.value,320,'spcontando11');contarCaracteresDepartamentoqualidade(this.value,320,'sprestante11')"></textarea>
							 		<p class="hint">[Descrever o departamento de qualidade.]</p> <br><br>
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
							 	<td><p align="justify"><b>Informação Financeira <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="informacaofinanceira" name="informacaofinanceira" onkeyup="mostrarResultadoInformacaofinanceira(this.value,320,'spcontando12');contarCaracteresInformacaofinanceira(this.value,320,'sprestante12')"></textarea>
							 		<p class="hint">[Descrever informações financeiras.]</p><br><br>
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
							 	<td><p align="justify"><b>Volume do Negócio <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="volumenegocio" name="volumenegocio" onkeyup="mostrarResultadoVolumenegocio(this.value,320,'spcontando13');contarCaracteresVolumenegocio(this.value,320,'sprestante13')"></textarea>
							 		<p class="hint">[Decreva no ano passado, o volume de negócios da empresa.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando13" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante13" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							
							<tr>
								<td><br></td>
							</tr>
				</table>
					<input type="button" name="prev" class="prev acao" value="Anterior" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()">
					<input type="button" name="nextRFIProjeto3" class="next acao" value="Próximo" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()">
			</fieldset>		
			
			<fieldset>	
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td><tr><th bgcolor="#FFFF00"><font color="#4682B4" size="2">ETAPA 4</font><br></th></tr></td>								
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr class="field" >
							 	<td><p align="justify"><b>Mercado Ações <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="mercadoacoes" name="mercadoacoes" onkeyup="mostrarResultadoMercadoacoes(this.value,320,'spcontando14');contarCaracteresMercadoacoes(this.value,320,'sprestante14')"></textarea>
							 		<p class="hint">[Descrever os mercados de ações onde sua empresa está listado.]</p><br><br>
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
								<td><p align="justify"><b>Pessoa Para Contato <font color="red">*</font></b></td>
								<td><p align="justify"><input id="pessoacontato" name="pessoacontato"
									style="height: 30px; width: 379px" class="input" maxlength="100" value="${rfiprojeto.pessoacontato}" onkeypress="return Letras(event);" required="true" Placeholder="Digitar nome completo!"></input>
									<p class="hint">[Informar a pessoa de contato a responder a esta RFI.]</p></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>														
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Capacidade Hoje <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="capacidadehoje" name="capacidadehoje" onkeyup="mostrarResultadoCapacidadehoje(this.value,320,'spcontando15');contarCaracteresCapacidadehoje(this.value,320,'sprestante15')"></textarea>
							 		<p class="hint">[Descrever a capacidade da empresa atualmente.]</p> <br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando15" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante15" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Capacidade Antecipada <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="capacidadeantecipada" name="capacidadeantecipada" onkeyup="mostrarResultadoCapacidadeantecipada(this.value,320,'spcontando16');contarCaracteresCapacidadeantecipada(this.value,320,'sprestante16')"></textarea>
							 		<p class="hint">[Descrever condições capacidade antecipada em 12 meses.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando16" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante16" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr class="field" >
							 	<td><p align="justify"><b>Condição Não Atendida <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="condicaonaoatendida" name="condicaonaoatendida" onkeyup="mostrarResultadocondicaonaoatendida(this.value,320,'spcontando17');contarCaracteresResultadocondicaonaoatendida(this.value,320,'sprestante17')"></textarea>
							 		<p class="hint">[Condições que é listado na RFI e não podem ser atendidas.]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando17" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante17" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
								<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Produtos Entregues <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="produtosentregues" name="produtosentregues" onkeyup="mostrarResultadoProdutosentregues(this.value,320,'spcontando18');contarCaracteresProdutosentregues(this.value,320,'sprestante18')"></textarea>
							 		<p class="hint">[Descrição dos produtos ou serviços que já são entregues aos clientes hoje, e poderia ser comparável ao que é pedido neste RFI.]</p> <br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando18" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante18" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Cliente Referencia Comparaveis <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="clientereferenciacomparaveis" name="clientereferenciacomparaveis" onkeyup="mostrarResultadoClientereferenciacomparaveis(this.value,320,'spcontando19');contarCaracteresClientereferenciacomparaveis(this.value,320,'sprestante19')"></textarea>
							 		<p class="hint">[Descrever os clientes de referência usando produtos ou serviços comparáveis (incluindo informações de contato).]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando19" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante19" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr class="field" >
							 	<td><p align="justify"><b>Cliente Referência Não Comparaveis<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="clientereferencianaocomparaveis" name="clientereferencianaocomparaveis" onkeyup="mostrarResultadoClientereferencianaocomparaveis(this.value,320,'spcontando20');contarCaracteresClientereferencianaocomparaveis(this.value,320,'sprestante20')"></textarea>
							 		<p class="hint">[Decreva clientes de referência usando seus produtos ou serviços, hoje, embora eles não são comparáveis com o que é pedido neste RFI (incluindo informações de contato).]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando20" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante20" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							
							<tr>
								<td><br></td>
							</tr>
							<tr class="field">
							 	<td><p align="justify"><b>Disponivel entrega <font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="disponivelentrega" name="disponivelentrega" onkeyup="mostrarResultadoDisponivelentrega(this.value,320,'spcontando21');contarCaracteresDisponivelentrega(this.value,320,'sprestante21')"></textarea>
							 		<p class="hint">[Locais disponíveis para entrega, se não em todo o mundo..]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando21" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante21" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>
							<tr class="field" >
							 	<td><p align="justify"><b>Disponibilidade<font color="red">*</font></b></td>
							 	<td><p align="justify"><font color="blue"></font></p>
							 		<textarea  id="disponibilidade" name="disponibilidade" onkeyup="mostrarResultadoDisponibilidade(this.value,320,'spcontando22');contarCaracteresDisponibilidade(this.value,320,'sprestante22')"></textarea>
							 		<p class="hint">[Disponibilidade de peças de reposição .]</p><br><br>
								 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando22" style="font-family:Arial;"></span></font></h5>
										<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante22" style="font-family:Arial;"></span></font></h5>
							 	</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>			
							<tr class="field">
								<td><p align="justify"><b>Suport mundial <font color="red">*</font></b></td>
								<td><p align="justify"><input id="suportemundial" name="suportemundial"
									style="height: 30px; width: 379px" class="input" value="${rfiprojeto.suportemundial}" required="true" maxlength="150"></input>
									<p class="hint">[Informar o suport mundial.]</p></td>
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
								<td><p align="justify"><b>Data <font color="red">*</font></b></td>
								<td><p align="justify"><input id="data" name="data"
									style="height: 30px; width: 100px" class="input" maxlength="20" value="${rfiprojeto.data}" required="true"></input>
									<p class="hint">[Informar a data.]</p></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><br></td>								
							</tr>
							</table>
									<input type="button" name="prev" class="prev acao" value="Anterior"  onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()">
									<input class="acao" type="submit" value="Enviar"  onclick="show_confirm()" onchange="validaCadastrarRfiProjeto()" onclick="validaCadastrarRfiProjeto()"></input><!--  -->
									<input class="acao" type="reset" value="Limpar" ></input>
							</fieldset>
							
			

<div class="demo-description">
<p>Preencha todos os dados da primeira etapa, para poder ir para a segunda etapa!</p>
</div>				
</form>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>-->
<script type="text/javascript" src="js/functionsRFIProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarRfiProjeto.js"></script>
<script language="javascript" src="js/TexteareCadastroRFIProjeto.js"></script><!-- Textarea Tratamento de erro -->
</body>
</html>