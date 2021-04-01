<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp"%>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Cliente"%>

<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<title>Cadastrar Cliente</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />

<style TYPE="text/css">
<!-- .input:focus {	background-color: #E7E8E7;}-->
</style>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.2-utf8.js"></script><!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->
<script type="text/javascript" src="js/validaCadastrarCliente.js"></script>

<!-- IMPLMENTA A FUNÇÃO DE LISTA ESTADO E CIDADE -->
<script type="text/javascript">
	window.onDomReady(function() {
		new dgCidadesEstados({
			estado : document.getElementById('estado'),
			cidade : document.getElementById('cidade')
		});
	});
</script>

<!-- MASCARA PARA TRATAMENTO DE ERRO -->
<script>
	$(document).ready(function() {
		$("#nascimento").mask("99/99/9999");
		$('#cep').mask("99999-999");
		$('#rg').mask("99.999.999-9");
		$("#cpf").mask("999.999.999-99");
		$("#cnpj").mask("99.999.999.9999-99");
		$('#fone').mask("999-9999-9999");
		$('#celular').mask("999-99999-9999");
		$('#foneemp').mask("999-9999-9999");
		$('#foneref').mask("999-9999-9999");
		$("#desde").mask("99/99/9999");
		//$("#placa").mask("aaa - 9999");  	
	});
</script>
<script>
	$(function() {
		$("#nascimento").datepicker({//nascimento
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#desde").datepicker({//desde
			dateFormat : 'dd/mm/yy',
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
			location.href = "TkcsapcdController?cmd=consultarCliente";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("nome").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<form action="TkcsapcdController" id="formulario" name="formulario" onsubmit="validaCadastrarCliente()">

		<fieldset>

			<center>
				<h3>
					<font color="green"> ${mensagem}</font>
				</h3>
			</center>

			<p>
				<font color="red">Campos de (<font color="red">*</font>) são
					de preenchimento obrigatório.
				</font>
			</p>

			<input type="hidden" name="cmd" value="cadastrarCliente"></input>

			<table border="0" cellspacing="3" cellpadding="3" width="100%"
				bgcolor="#FFFFFF">
				<tr>
					<th bgcolor="#F3F781"><br></th>
					<th bgcolor="#F3F781"></th>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Nome <font color="red">*</font>
						</p></td>
					<td><p align="justify">
							<input id="nome" name="nome" style="height: 30px; width: 379px"
								class="input" value="${cliente.nome}"
								onkeypress="return Letras(event);"
								Placeholder="Digitar nome completo!"></input>
						</p></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Sexo <font color="red">*</font></td>
					<td><p align="justify">
							Masculino <input name="sexo" type="radio" id="sexo" value="M"
								checked="checked" /> Feminino <input name="sexo" type="radio"
								id="sexo" value="F" />
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Nascimento <font color="red">*</font></td>
					<td><p align="justify">
							<input id="nascimento" name="nascimento"
								style="height: 20x; width: 100px" class="input"
								value="${cliente.nascimento}"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Profissão <font color="red">*</font></td>
					<td><p align="justify">
							<input id="profissao" name="profissao"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.profissao}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Renda <font color="red">*</font></td>
					<td><p align="justify">
							<input id="renda" name="renda" style="height: 30px; width: 379px"
								class="input" value="${cliente.renda}"
								onkeypress="return numbers(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							RG <font color="red">*</font></td>
					<td><p align="justify">
							<input id="rg" name="rg" style="height: 30px; width: 150px"
								class="input" value="${cliente.rg}"></input>(xx.xxx.xxx-x)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Orgão Emissor <font color="red">*</font></td>
					<td><p align="justify">
							<input id="orgaorg" name="orgaorg"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.orgaorg}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Telefone</td>
					<td><p align="justify">
							<input id="fone" name="fone" style="height: 30px; width: 150px"
								class="input" value="${cliente.fone}"></input>(xxx-xxxx-xxxx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Celular</td>
					<td><p align="justify">
							<input id="celular" name="celular"
								style="height: 30px; width: 150px" class="input"
								value="${cliente.celular}"
								onKeyPress="return digitos(event, this);"></input>(xxx-xxxxx-xxxx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Endereço <font color="red">*</font></td>
					<td><p align="justify">
							<input id="endereco" name="endereco"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.endereco}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Bairro <font color="red">*</font></td>
					<td><p align="justify">
							<input id="bairro" name="bairro"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.bairro}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Estado <font color="red">*</font></td>
					<td><p align="justify">
							<select id="estado" name="estado" value="${cliente.estado}"></select></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Cidade <font color="red">*</font></td>
					<td><p align="justify">
							<select id="cidade" name="cidade" value="${cliente.cidade}"></select></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							CEP <font color="red">*</font></td>
					<td><p align="justify">
							<input id="cep" name="cep" style="height: 30px; width: 200px"
								class="input" value="${cliente.cep}"></input>(xxxxx-xxx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							CPF <font color="red">*</font></td>
					<td><p align="justify">
							<input id="cpf" name="cpf" style="height: 30px; width: 200px"
								class="input" value="${cliente.cpf}" maxlength="14"
								onKeyPress="return digitos(event, this);"
								onKeyUp="Mascara('cpf',this,event);"
								onBlur="ValidarCPF(formularioCliente.cpf);"></input>(xxx.xxx.xxx-xx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							CNPJ <font color="red">*</font></td>
					<td><p align="justify">
							<input id="cnpj" name="cnpj" style="height: 30px; width: 200px"
								class="input" value="${cliente.cnpj}"></input>(xx.xxx.xxx.xxxx-xx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Inscrição Estadual</td>
					<td><p align="justify">
							<input id="insest" name="insest"
								style="height: 30px; width: 379px;" class="input"
								value="${cliente.insest}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Desde <font color="red">*</font></td>
					<td><p align="justify">
							<input id="desde" name="desde" style="height: 30px; width: 100px"
								class="input" value="${cliente.desde}"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							E-mail <font color="red">*</font></td>
					<td><p align="justify">
							<input id="email" name="email" style="height: 30px; width: 379px"
								class="input" value="${cliente.email}"
								Placeholder="exemplo@exemplo.com.br"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">
							Empresa <font color="red">*</font></td>
					<td><p align="justify">
							<input id="empresa" name="empresa"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.empresa}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Telefone Empresa</td>
					<td><p align="justify">
							<input id="foneemp" name="foneemp"
								style="height: 30px; width: 150px" class="input"
								value="${cliente.foneemp}"></input>(xxx-xxxx-xxxx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Referência</td>
					<td><p align="justify">
							<input id="referencia" name="referencia"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.referencia}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Telefone Referência</td>
					<td><p align="justify">
							<input id="foneref" name="foneref"
								style="height: 30px; width: 150px" class="input"
								value="${cliente.foneref}"></input>(xxx-xxxx-xxxx)</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Auditoria</td>
					<td><p align="justify">
							<input id="auditoria" name="auditoria"
								style="height: 30px; width: 379px" class="input"
								value="${cliente.auditoria}" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">E-mail Confirmação</td>
					<td><p align="justify">
							<input type="text" name="para"
									style="height: 30px; width: 379px" 
									maxlength="150" 
									placeholder="Destinatário"
									class="input" 
									required="true"></input>
							<p class="hint">[Inserir e-mail para receber confirmação de registro, por e-mail.]</p>
					</td>
				</tr>				
				<tr>
					<td><br></td>
				</tr>	
				<tr>
					<td><p align="justify">Observação</td>
					<td><p align="justify">
							<textarea rows="5" cols="70" name="obs"	Placeholder="caso necessário digite uma observação."></textarea>
						</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
			</table>
			<input class="prev acao" type="submit" value="Cadastrar"
				onclick="show_confirm()" onchange="validaCadastrarCliente();"></input>
			<input class="prev acao" type="reset" value="Limpar"></input>
		</fieldset>
	</form>
<%@ include file="rodape.jsp" %>	
</body>
</html>