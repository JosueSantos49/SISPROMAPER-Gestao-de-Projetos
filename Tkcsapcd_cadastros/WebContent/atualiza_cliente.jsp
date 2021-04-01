<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Cliente"%>
<jsp:useBean id="cliente" scope="request" class="br.com.tkcsapcd.model.bean.Cliente"></jsp:useBean><!-- Deve ser importado cada pacote, para resgatar os valores do BD. Ex: Value="" -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Cliente</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>

<style TYPE="text/css" >    <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/jquery.maskedinput.js"></script>	
<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.2-utf8.js"></script><!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaCadastrarCliente.js"></script>

<!-- IMPLMENTA A FUNÇÃO DE ESTADO E CIDADE -->
<script type="text/javascript">
window.onDomReady(function() {
  new dgCidadesEstados({
    estado: document.getElementById('estado'),
    cidade: document.getElementById('cidade')
  });
});
</script>


<!-- MASCARA PARA TRATAMENTO DE ERRO -->
<script>
	$(document).ready(function(){
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
		dateFormat: 'dd/mm/yy',
		showOn : "button",
		buttonImage : "img/calendar.gif",
		buttonImageOnly : true
	});
});
</script>
<script>
	$(function() {
	$("#desde").datepicker({//desde
		dateFormat: 'dd/mm/yy',
		showOn : "button",
		buttonImage : "img/calendar.gif",
		buttonImageOnly : true
	});
});
</script>

<!-- CONFIRMAÇÃO DE AÇÃO -->

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
			location.href="TkcsapcdController?cmd=consultarCliente";
			}		
	}
</script> 	

<script type="text/javascript">	function setFocus() {	document.getElementById("nome").focus(); }</script>

</head>

<body  bgcolor="#ededed" onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

				<div align="center">
					<form action="TkcsapcdController"  id="formulario" name="formulario" onsubmit="validaCadastrarCliente()" onclick="validaCadastrarCliente()">
						
						<fieldset>
						
						<br><br><center><h3><font color="red"> ${mensagem}</font></h3></center> 
						<br>
						<p><font color="red">Campos de (*) são de preenchimento obrigatório.</font></p>
						<br>
						
						<input type="hidden" name="cmd" value="atualizarCliente"></input>
						<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
						
							<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">				
							<thead>
								<tr>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tr>
								<th bgcolor="#F3F781"><br></th>									
								<th bgcolor="#F3F781"></th>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
							<td><p align="justify">Código</td>
							<td><p align="justify"><input id="codigo" name="codigo"
								style="height: 30px; width: 100px" disabled="disabled" value="${cliente.codigo}" ></input></td><!--  -->
							</tr>
							<tr>
								<td><br></td>
							</tr>				
							<tr>
								<td><p align="justify">Nome *</td>
								<td><p align="justify"><input id="nome" name="nome" 
									style="height: 30px; width: 379px" class="input" value="${cliente.nome}" Placeholder="Digitar nome completo!"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Sexo</td>
								<td><p align="justify">
									Masculino
					                    <input name="sexo" type="radio" id="sexo" value="M" checked="checked" />
					                  
					                Feminino
					                    <input name="sexo" type="radio" id="sexo" value="F" />		                
							</tr>
							<tr>
								<td><br></td>
							</tr>						 				
							<tr>
								<td><p align="justify">Nascimento *</td>
								<td><p align="justify"><input id="nascimento" name="nascimento"
									style="height: 20x; width: 100px" class="input" value="${cliente.nascimento}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>				
							<tr>
								<td><p align="justify">Profissão *</td>
								<td><p align="justify"><input id="profissao" name="profissao"
									style="height: 30px; width: 379px" class="input" value="${cliente.profissao}" ></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Renda *</td>
								<td><p align="justify"><input id="renda" name="renda"
									style="height: 30px; width: 379px" class="input" value="${cliente.renda}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">RG *</td>
								<td><p align="justify"><input id="rg" name="rg"
									style="height: 30px; width: 150px" class="input" value="${cliente.rg}"></input>(xx.xxx.xxx-x)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Orgão Emissor *</td>
								<td><p align="justify"><input id="orgaorg" name="orgaorg"
									style="height: 30px; width: 379px" class="input" value="${cliente.orgaorg}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Telefone</td>
								<td><p align="justify"><input id="fone" name="fone"
									style="height: 30px; width: 150px" class="input" value="${cliente.fone}"></input>(xxx-xxxx-xxxx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Celular</td>
								<td><p align="justify"><input id="celular" name="celular"
									style="height: 30px; width: 150px" class="input" value="${cliente.celular}"></input>(xxx-xxxxx-xxxx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Endereço *</td>
								<td><p align="justify"><input id="endereco" name="endereco"
									style="height: 30px; width: 379px" class="input" value="${cliente.endereco}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Bairro *</td>
								<td><p align="justify"><input id="bairro" name="bairro"
									style="height: 30px; width: 379px" class="input" value="${cliente.bairro}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Estado</td>
								<td><p align="justify"><select id="estado" name="estado" value="${cliente.estado}">${cliente.estado}</select></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Cidade *</td>
								<td><p align="justify"><select id="cidade" name="cidade" value="${cliente.cidade}"></select></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">CEP *</td>
								<td><p align="justify"><input id="cep" name="cep"
									style="height: 30px; width: 200px" class="input" value="${cliente.cep}"></input>(xxxxx-xxx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">CPF *</td>
								<td><p align="justify"><input id="cpf" name="cpf"
									style="height: 30px; width: 200px" class="input" value="${cliente.cpf}"></input>(xxx.xxx.xxx-xx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">CNPJ *</td>
								<td><p align="justify"><input id="cnpj" name="cnpj"
									style="height: 30px; width: 200px" class="input" value="${cliente.cnpj}"></input>(xx.xxx.xxx.xxxx-xx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Inscrição Estadual</td>
								<td><p align="justify"><input id="insest" name="insest"
									style="height: 30px; width: 379px;" class="input" value="${cliente.insest}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>				 
							<tr>
								<td><p align="justify">Desde</td>
								<td><p align="justify"><input id="desde" name="desde"
									style="height: 30px; width: 100px" class="input" value="${cliente.desde}"></input></td>
							</tr>	
							<tr>
								<td><br></td>
							</tr>			
							<tr>
								<td><p align="justify">E-mail *</td>
								<td><p align="justify"><input id="email" name="email" 
									style="height: 30px; width: 379px" class="input" value="${cliente.email}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Empresa</td>
								<td><p align="justify"><input id="empresa" name="empresa"
									style="height: 30px; width: 379px" class="input" value="${cliente.empresa}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Telefone Empresa</td>
								<td><p align="justify"><input id="foneemp" name="foneemp"
									style="height: 30px; width: 150px" class="input" value="${cliente.foneemp}"></input>(xxx-xxxx-xxxx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Referência</td>
								<td><p align="justify"><input id="referencia" name="referencia"
									style="height: 30px; width: 379px" class="input" value="${cliente.referencia}"></input></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Telefone Referência</td>
								<td><p align="justify"><input id="foneref" name="foneref"
									style="height: 30px; width: 150px" class="input" value="${cliente.foneref}"></input>(xxx-xxxx-xxxx)</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td><p align="justify">Auditoria</td>
								<td><p align="justify"><input id="auditoria" name="auditoria"
									style="height: 30px; width: 379px" class="input" value="${cliente.auditoria}"></input></td>
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
							 		<textarea rows="5" cols="70" name="obs" >${cliente.obs}</textarea>
							 	</td>
						 	</tr>
						 	<tr>
								<td><br></td>
							</tr>
						</table>
						<input class="acao" type="submit" value="Atualizar" onclick="show_confirm()" onchange="validaCadastrarCliente();"></input>
					</fieldset>	
				</form>
</div>	
<%@ include file="rodape.jsp" %>
</body>
</html>