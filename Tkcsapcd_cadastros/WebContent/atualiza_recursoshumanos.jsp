<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.RecursosHumanos"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Recursos Humanso</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> 
<script src="js/jquery.maskedinput.js"></script>
<!-- <script type="text/javascript" src="js/jquery.1.4.2.jquery.min.js"></script>  Depois que documentei esta linha o tratamento de erro funcionou. Ex: Concordo com termo.-->
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script><!-- Tratamento de erro, Ex campo não pode conter numeros, mas somente letras. -->
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->

<script type="text/javascript" src="js/validaFormularioRecursoshumanos.js"></script>

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
<script>
	$(document).ready(function() {
		$('#codigoProjeto').mask("99999");
		$('#itensProjeto').mask("99999");		 	
	});
</script>	

<script>

	function show_confirm(pagina, largura, altura)
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
			location.href="TkcsapcdController?cmd=consultarAnalise";
			}		
	}
</script>

<style TYPE="text/css" > <!--	.input:focus{	background-color:#E7E8E7;	}  --></style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario" onsubmit="validaRecursosHumanos();" onclick="validaRecursosHumanos()"><br>
	
			<fieldset>	
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">RECURSOS HUMANOS</font></th></tr></table><br>			
			
			<div align="center"><img src="img/lapis.jpg" height="40px" width="50px">${mensagem}</div>
			
				<br><center><p><font color="red">Atualizar Recursos Humanos</font></p></center>
				
				<br>
				
				<div id="dialog"><p><font color="red">Campos de (*) obrigatório.</font></p><br></div>
				
			<br>
			<input type="hidden" name="cmd" value="atualizarRecursosHumanos"></input>
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
					<td><br></td>
				</tr>
				<tr>
					<td><br><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">ID <font color="red">*</font></td>
					<td><p align="justify"><input id="idRecursosHumanos" name="idRecursosHumanos" class="input" maxlength="8"
						style="height: 30px; width: 150px" value="${recursosHumanos.idRecursosHumanos}" onkeypress="return numbers(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Nome <font color="red">*</font></td>
					<td><p align="justify"><input id="nome" name="nome" class="input" Placeholder="Digitar nome completo!"
						style="height: 30px; width: 379px" value="${recursosHumanos.nome}" maxlength="35" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Profissão <font color="red">*</font></td>
					<td><p align="justify"><input id="profissao" name="profissao" class="input"
						style="height: 30px; width: 300px" value="${recursosHumanos.profissao}" maxlength="30" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Área <font color="red">*</font></td>
					<td><p align="justify"><input id="area" name="area" class="input"
						style="height: 30px; width: 300px" value="${recursosHumanos.area}" maxlength="30" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Status <font color="red">*</font></td>
					<td><p align="justify"><input id="status" name="status" class="input"
						style="height: 30px; width: 200px" value="${recursosHumanos.status}" maxlength="20" onkeypress="return Letras(event);"></input></td>
				</tr>
				<tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
				</tr>
			</table><br>
					<input class=" acao" type="submit" value="Atualizar" onclick="show_confirm()"></input>
					<input class=" acao" type="button" value="Voltar"  onclick="document.location.href='TkcsapcdController?cmd=consultarAnalise'" title="Voltar página"></input>						
					<input class=" acao" type="button" name="cancelar" onclick="document.location.href='sair.jsp'" value="Sair" title="Encerrar sessão" />
			</fieldset>
		</form>
</div>
<%@ include file="rodape.jsp" %>
</body>
</html>