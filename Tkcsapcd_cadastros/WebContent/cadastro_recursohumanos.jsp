<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.RecursosHumanos"%>
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

<title>Cadastrar Recursos Humanos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaCadastrarAnalise.js"></script>
<script type="text/javascript" src="js/validaFormularioRecursoshumanos.js"></script>

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
		//$('#codigoProjeto').mask("99999");
		//$('#itensProjeto').mask("99999");		 	
	});
</script>

<script>
	$(function() {
		$("#posse").datepicker({
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
				location.href="TkcsapcdController?cmd=consultarRecursosHumanos";								
			}		
	}
</script>

<script type="text/javascript">	function setFocus() {	document.getElementById("idRecursosHumanos").focus(); }</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">
	
<%@include file="menuperantecssadm.jsp" %>
	
	<div align="center"> 
	
		<form action="TkcsapcdController" id="formulario" name="formulario" onsubmit="validaRecursosHumanos();">
			
			<fieldset>	
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">RECURSOS HUMANOS</font></th></tr></table><br>		
			
			<center><h3><font color="green"> ${mensagem}</font></h3></center>
			
			<div id="dialog"><p><font color="red">Campos de (<font color="red">*</font>) obrigatório.</font></p><br></div>
			
			<input type="hidden" name="cmd" value="cadastrarRecursosHumanos"></input>
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">		
				<tr>
					<td><br><p><font color="red">Campos de (<font color="red">*</font>) obrigatório.</font></p><br></td>
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
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
				</tr>
			</table>
			<br><br>
				<input class="prev acao" type="submit" value="Cadastrar" onclick="show_confirm()" ></input>
				<input class="prev acao" type="reset" value="Limpar" ></input>
			</fieldset>			
		</form>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>