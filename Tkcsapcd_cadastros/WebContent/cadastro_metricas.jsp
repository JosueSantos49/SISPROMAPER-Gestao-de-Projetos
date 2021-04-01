<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Metricas"%>
<%@include file="include.jsp" %>

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Cadastrar Métricas</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaCadastrarMetrica.js"></script> 
<style TYPE="text/css" >  <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>

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
				location.href="TkcsapcdController?cmd=consultarAnalise";								
			}		
	}
</script>

<script type="text/javascript">	function setFocus() {	document.getElementById("idMetricas").focus(); }</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>
	
	<div align="center"> 
	
		<form action="TkcsapcdController" id="formulario" name="formulario" onSubmit="validaCadastrarMetrica()" onclick="validaCadastrarMetrica()">
			
			<fieldset>
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">METRICAS</font></th></tr></table><br>	
							
			<center><h3><font color="green"> ${mensagem}</font></h3></center>
						
			<div id="dialog"><p><font color="red">Campos de (*) obrigatório.</font></p></div>
			
			<input type="hidden" name="cmd" value="cadastrarMetricas"></input>
			<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">	
				<tr>
					<td><br><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">ID <font color="red">*</font></td>
					<td><p align="justify"><input id="idMetricas" name="idMetricas" class="input"
						style="height: 30px; width: 379px" value="${metricas.idMetricas}" maxlength="8" onkeypress="javascript: return numbers(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Nome Métrica <font color="red">*</font></td>
					<td><p align="justify"><input id="nomeMetrica" name="nomeMetrica" class="input"
						style="height: 30px; width: 379px" value="${metricas.nomeMetrica}"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Indice da Métrica <font color="red">*</font></td>
					<td><p align="justify"><input id="indiceMetrica" name="indiceMetrica" class="input"
						style="height: 30px; width: 379px" value="${metricas.indiceMetrica}" onkeypress="javascript: return numbers(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify">Valor Referência - Hora <font color="red">*</font></td>
					<td><p align="justify"><input id="valorReferenciaHora" name="valorReferenciaHora" class="input"
						style="height: 30px; width: 200px" value="${metricas.valorReferenciaHora}" maxlength="20" onkeypress="javascript: return numbers(event);"></input></td>
				</tr>
				<tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>				
				<tr>
					<td><p align="justify">Valor Hora Calculada - Dia <font color="red">*</font></td>
					<td><p align="justify"><input id="valorHoraCalculadaDia" name="valorHoraCalculadaDia" class="input"
						style="height: 30px; width: 379px" value="${metricas.valorHoraCalculadaDia}" onkeypress="javascript: return numbers(event);"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
				</tr>
			</table>
			<br>
				<input class="prev acao" type="submit" value="Cadastrar" onclick="show_confirm()" onchange="validaCadastrarProjeto();"></input>
				<input class="prev acao" type="reset" value="Limpar" ></input>
			</fieldset>			
		</form>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>