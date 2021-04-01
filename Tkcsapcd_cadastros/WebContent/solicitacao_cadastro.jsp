<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Cliente"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.SolicitacaoCadastro"%>

<html>

<jsp:include page="sessao.jsp" />

<head>

<title>Solicitação Cadastro</title>

<link rel="stylesheet" href="css/formatacaoTelaFormularioSolicitacaoCadastro.css" type="text/css">
<link type="text/css" href="/Tkcsapcd_cadastros/css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>	
<script language="javascript" src="js/funcoes.js"></script>		
<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.2-utf8.js"></script>

<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
 
<script type="text/javascript" src="js/validaSolicitacaoAcesso.js"></script>
 
<script type="text/javascript">
/*função valida email*/
function valida_form()
	{
	var x=document.forms["formSolicitacaoCadastro"]["email"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
	alert("Não é um endereço de e-mail válido!\n\nEntre com um endereço de e-mail válido.\n\nVerifique a veracidade do e-mail, pôs com mesmo também podemos entrar em contato.");
	return false;m
	}
	return true;
}
</script> 
 
<!-- Dialogo -->		
<script type="text/javascript">
		$(function(){
			$("#dialog").dialog({
				height: 150,
				modal:true,
				buttons: {
					"Ok":function(){
						$(this).dialog("close");
					}
				}
			});			
		});	
</script>

<script type="text/javascript">
	$(document).ready(function(){			
		$("#data").mask("99/99/9999"); 
		$("#telefone").mask("99-9999-9999"); 
	});
</script>

<script type="text/javascript">
window.onDomReady(function() {
  new dgCidadesEstados({
    estado: document.getElementById('estado'),
    cidade: document.getElementById('cidade')
  });
});
</script>

</head>

<body  bgcolor="#ffffff">

<div id="preloader"><h1><img src="img/loader.gif" height="70px"></h1></div>	
					
				<div align="center" class="container">
				
					<form class="rounded" action="TkcsapcdController"	id="formSolicitacaoCadastro" name="formSolicitacaoCadastro"  onsubmit="validaSolicitacaoAcesso();"> <!-- onclick="valida_form();" -->
										
					<h3>Solicitação Acesso - SisproMaper</h3><br>
					
					<center><h5><font color="green"> ${mensagem}</font><br>
						<%
						String msg = (String) request.getAttribute("msg");
							if(msg != null)
						out.println(msg);
						%>
					</h5></center><br>
					
						<br>
						<p><font color="red">Campos de (*) são de preenchimento obrigatório.</font></p>
						<br>
						
						<div id="dialog">
							<p><font color="red">Campos de (*) obrigatório!<br>Fields (*) required!</font></p>
						</div>
			
						<input type="hidden" name="cmd" value="cadastrarSolicitacaoCadastro">
						
						<div class="field">
							<label for="name">Nome: *</label>
						  	<input id="nome" name="nome" class="input" value="${solicitacaocadastro.nome}" maxlength="35" onkeypress="return Letras(event);" required="true" Placeholder="Digitar nome completo!">
							<p class="hint">Entre com o nome.</p>
						</div>
						
						<div class="field">
							<label for="email">Email: *</label>
						  	<input id="email" name="email" class="input" value="${solicitacaocadastro.email}" maxlength="50" required="true" Placeholder="exemplo@exemplo.com.br">
							<p class="hint">Entre com o email.</p>
						</div>
						
						<div class="field">
							<label for="id">ID: *</label>
						  	<input id="id" name="id" class="input" value="${solicitacaocadastro.id}" maxlength="8" onkeypress="return numbers(event);" required="true">
							<p class="hint">Entre com o ID.</p>
						</div>
						
						<div class="field">
							<label for="id">Área: *</label>
						  	<input id="area" name="area" class="input" value="${solicitacaocadastro.area}" maxlength="35" onkeypress="return Letras(event);" required="true">
							<p class="hint">Entre com a área.</p>
						</div>
											
						<div class="field">
							<label for="id">Função: *</label>
						  	<input id="funcao" name="funcao" class="input" value="${solicitacaocadastro.funcao}" maxlength="100" onkeypress="return Letras(event);" required="true">
							<p class="hint">Entre com a função.</p>
						</div>
						
						<div class="field">
							<label for="id">Responsável: *</label>
						  	<input id="responsavel" name="responsavel" class="input" value="${solicitacaocadastro.responsavel}" maxlength="35" onkeypress="return Letras(event);" required="true">
							<p class="hint">Entre com o gestor responsável.</p>
						</div>
						
						<div class="field">
							<label for="telefone">Telefone: *</label>
						  	<input id="telefone" name="telefone" class="input" value="${solicitacaocadastro.telefone}" maxlength="12">
							<p class="hint">Entre com o telefone.</p>
						</div>
						<div class="field">
							<label for="data">Data: *</label>
						  	<input id="data" name="data" class="input" value="${solicitacaocadastro.data}" maxlength="10">
							<p class="hint">Entre com a data.</p>
						</div>
						
						<div class="field">
						<label for="status">Status: *</label>						
						<select id="status" style="width:310px;height: 30px" name="status">
							<option value="0"></option>						
							<option value="Solicitação Acesso">Solicitação Acesso</option>						
						</select>
						</div>
						
						<br>
						<div class="field">
							<label for="message">Observação: *</label>
							<br>
						  	<textarea class="input textarea" name="obs" id="obs"></textarea><!-- class="input textarea" -->
							<p class="hint">Entre com a observação.</p>							
						</div>
						<br>
						<input type="submit" name="Submit"  class="button" value="Enviar" onchange="validaSolicitacaoAcesso()">
						<input type="reset" value="Limpar" class="button">
					</form>		
		</div>
</body>
</html>