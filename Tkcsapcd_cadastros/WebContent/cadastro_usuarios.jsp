<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.email.EnviaEmail"%>
<%@page import="br.com.tkcsapcd.model.helper.ConexaoHelper"%>
<%@page import="br.com.tkcsapcd.model.helper.Config"%>
<%@page import="br.com.tkcsapcd.model.helper.Hash"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.PrintWriter"	import="java.sql.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List,br.com.tkcsapcd.model.bean.Usuario"%>
<%@include file="httpservletrequest.jsp"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->	

<title>Cadastrar Usuário</title>

<link href="bootstrap/css/bootstrapPagination.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/> 
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validacadusuario.js"></script>
<script type="text/javascript" src="js/validacaoFormularioUsuarioNivelSelect.js"></script>					
<script type="text/javascript" src="js/validacaoFormularioUsuario.js"></script><!-- A validação do formulário deve ser depois do nível (select) -->

<script type="text/javascript">
		$(function(){
			$('#nivel').combo({
					required:true,
					editable:false
				});
					$('#sp').appendTo($('#nivel').combo('panel'));
					$('#sp input').click(function(){
						var v = $(this).val();
						var s = $(this).next('span').text();
					$('#nivel').combo('setValue', v).combo('setText', s).combo('hidePanel');
				});
			});
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
		$("#datacadastro").mask("99/99/9999"); 
	});
</script>

<script>
			$(function() {
				$("#datacadastro").datepicker({
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>

<script type="text/javascript">	function setFocus() {  	document.getElementById("nome").focus();}</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>
			
		<center><h5><font color="green"> ${mensagem}</font></h5></center>

			<form action="TkcsapcdController" class="rounded" name="formulario" id="formulario" onSubmit="validacadusuario()">
				
				<input type="hidden" name="cmd" value="cadastrarUsuario"></input>
					
				<fieldset>
										
						<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">DADOS DE IDENTIFICAÇÃO</font><br></th></tr></table><br>
					
						<div class="required-asterisk" aria-hidden="true">Campos de (*) são de preenchimento obrigatório.<br></div>
										
						<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">							
							<tr>
								<td>
								<br>
								<div class="field">
											<p align="justify">Nome: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="nome" name="nome" maxlength="100" class="input" style="height: 30px; width: 400px" required="true" onkeypress="return Letras(event);"></input>
											</p>
											<p class="hint">Entre com o nome.</p>
										</div>										
								</td>
							</tr>	
							<tr>
								<td>
								<br>
										<div class="field">
											<p align="justify">8-ID: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="id" name="id" maxlength="8"	class="input" style="height: 30px; width: 150px" required="true" onkeypress="return numbers(event);"></input>
											</p>
											<p class="hint">Entre com o 8-ID.</p>
										</div>
								</td>
							</tr>	
							<tr>
								<td>
								<br>
									<div class="field">
											<p align="justify">Gestor Imediato: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="gestorimediato" name="gestorimediato" maxlength="100"	class="input" style="height: 30px; width: 400px" required="true" onkeypress="return Letras(event);"></input>
											</p>
											<p class="hint">Entre com o Gestor Imediato.</p>
										</div>
								</td>
							</tr>	
							<tr>
								<td>
								<br>
									<div class="field">
											<p align="justify">Departamento: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="departamento" name="departamento" maxlength="100"	class="input" style="height: 30px; width: 400px" required="true" onkeypress="return Letras(event);"></input>
											</p>
											<p class="hint">Entre com o departamento.</p>
										</div>
								</td>
							</tr>
							<tr>
								<td>
								<br>
									<div class="field">
											<p align="justify">E-mail: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="email" name="email" maxlength="100"	class="input" style="height: 30px; width: 400px" required="true"></input>
											</p>
											<p class="hint">Entre com o E-mail.</p>
										</div>
								</td>
							</tr>	
							<tr>
								<td>
								<br>
									<div class="field">
											<p align="justify">Telefone: <font class="required-asterisk">*</font><p>
											<p align="justify">
												<input id="telefone" name="telefone" maxlength="10"	class="input" style="height: 30px; width: 400px" required="true" onkeypress="return numbers(event);"></input>
											</p>
											<p class="hint">Entre com o Telefone.</p>
										</div>
								<br><br>		
								</td>
							</tr>
							
						 		
							<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">DADOS DE ACESSO AO SISTEMA</font><br></th></tr></table>
															
																		  											
							<tr>
								<td>
									<br>
									<div class="field"><font class="required-asterisk"></font>
									<p align="justify" class="q-title">Usuário: <font class="required-asterisk">*</font><br>
									  	<input id="log_usuario" name="log_usuario" class="input" style="height: 30px; width: 150px" maxlength="15" required="true" requiredMessage="Insira o usuário"></input>
										<p class="hint">Entre com o usuário.</p>
									</div>
									<br>
								</td>
							</tr>
							
							<tr>
								<td>
									<br>
									<div class="field"><font class="required-asterisk"></font>
									<p align="justify" class="q-title">Senha: <font class="required-asterisk">*</font><br>
									  	<input name="log_senha" type="password" id="log_senha" class="input" style="height: 30px; width: 150px" maxlength="11" required="true" requiredMessage="Insira a senha">
										<p class="hint">Entre com a senha.</p>
									</div>
									<br>
								</td>
							</tr>						
							
							<tr>
								<td>
									<br>
									<div class="field"><font class="required-asterisk"></font>
									<p align="justify" class="q-title">Nível Acesso: <font class="required-asterisk">*</font><br>					
										<select id="log_nivelacesso" style="width:300px;height: 30px" name="log_nivelacesso">	
											<option value="0"></option>						
											<option value="1">Usuário (N1)</option>
										  	<option value="2">Usuário Chave (N2)</option>
										  	<option value="3">administrador (N3)</option>				
										</select> 
										<p class="hint">Entre com a senha.</p>
									</div>	
								</td>
							</tr>
													
							<tr>
								<td>
									<br>
									<div class="field"><font class="required-asterisk"></font>
									<p align="justify" class="q-title">CPF: <font class="required-asterisk">*</font><br>
									  	<input id="log_cpf" name="log_cpf" class="input" style="height: 30px; width: 400px" maxlength="11" required="true" requiredMessage="Insira o CPF." onkeypress="return numbers(event);"></input>
										<p class="hint">Entre com o CPF.</p>
									</div>
									<br>
								</td>
							</tr>
							
							<tr>
								<td>
									<br>
									<div class="field"><font class="required-asterisk"></font>
									<p align="justify" class="q-title">Data  Cadastro: <font class="required-asterisk">*</font><br>
									  	<input name="log_datacadastro" type="text" id="log_datacadastro" style="height: 30px; width: 150px" class="input" maxlength="10" required="true" requiredMessage="Insira a data cadastro." onkeypress="return numbers(event);">
										<p class="hint">Entre com a Data Cadastro.</p>
									</div>
								</td>
							</tr>
							
							</table>
							
							<br>
							<input class="acao" type="submit" name="gravar" id="gravar" value="Gravar" onclick="validacadusuario();"></input>
							<input class="acao" type="reset" value="Limpar" onclick="validacadusuario();"></input>
							<br><br><br>	
					</fieldset>											
		</form>	
<%@ include file="rodape.jsp" %>
</body>
</html>
