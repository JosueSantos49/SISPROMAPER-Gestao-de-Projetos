<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.ProjetoInicio"%>

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Projeto</title> 

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarProjeto.js"></script>
		
<style TYPE="text/css" >    <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>
		
<!-- Calendário -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'yyyy-MM-dd',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
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
	$(document).ready(function() {
		$("#data").mask("9999-99-99"); //99/99/9999  
	});
</script>
	
<script>
	$(function() {
	$("#").datepicker({//dataProjeto
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
				location.href="TkcsapcdController?cmd=consultarProjetoInicio";
				
			}		
	}
</script>

<script type="text/javascript">	function setFocus() {	document.getElementById("autorProjeto").focus(); }</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

	<div align="center">	
	
		<form action="TkcsapcdController"	id="formulario"	name="formulario" onsubmit="validaCadastrarProjeto()">
				
		<fieldset>
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PROJETO</font></th></tr></table>	
			
			<center><h3><font color="red">${mensagem}</font></h3></center>			
			<div id="dialog"><p><font color="red">Campo (*) obrigatório.</font></p></div>
			<input type="hidden" name="cmd" value="atualizarProjetoInicio"></input>
			<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->			
				<table	border="0" cellspacing="3" cellpadding="3" width="100%" bgcolor="#FFFFFF">	
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
				<tr class="field">
					<td><p align="justify"><b>Código Projeto <font color="red">*</font></b></p>
					<p align="justify"><input id="codigoprojeto" name="codigoprojeto" style="height: 30px; width: 179px" maxlength="15"
						value="${projetoInicio.codigoprojeto}" class="input" onkeypress="return numbers(event);"></input>
						<p class="hint">[Informar o código do projeto.]</p>
					</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Projeto <font color="red">*</font></b></p>
					<p align="justify"><input id="projeto" name="projeto" style="height: 30px; width: 379px" Placeholder="Digitar nome completo!"
						value="${projetoInicio.projeto}" class="input"></input>
						<p class="hint">[Informar o projeto.]</p>
					</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>					
				<tr class="field">
					<td><p align="justify"><b>Data <font color="red">*</font></b></p>
					<p align="justify"><input id="data" name="data" style="height: 30px; width: 100px" Placeholder=""
						value="${projetoInicio.data}" class="input" ></input>
						<p class="hint">[Informar a data.]</p>
					</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Atribui <font color="red">*</font></b>
					<p align="justify"><font color="blue"></font>
					<input id="atribuiprojeto" name="atribuiprojeto" style="height: 30px; width: 379px" value="${projetoInicio.atribuiprojeto}"  onkeypress="return Letras(event);" class="input"></input>
						<p class="hint">[Informar a atribuição do projeto.]</p></p></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>		
				 <tr class="field">
				 	<td><p align="justify" ><b>Descrição <font color="red">*</font></b>
				 	<p align="justify"><font color="blue"></font></p>
				 		<textarea  id="descricao" name="descricao" onkeyup="mostrarResultadoDescricao(this.value,400,'spcontando0');contarCaracteresDescricao(this.value,400,'sprestante0')">${projetoInicio.descricao}
				 		</textarea><p class="hint">[Informar a descrição.]</p><br><br>
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family:Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family:Arial;"></span></font></h5>
				 	</td>
				 </tr>
				 <tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
				 	<td><p align="justify" ><b>Objetivo <font color="red">*</font></b>
				 	<p align="justify"><font color="blue"></font></p>
				 		<textarea  id="objetivo" name="objetivo" onkeyup="mostrarResultadoDescricao(this.value,400,'spcontando0');contarCaracteresDescricao(this.value,400,'sprestante0')">${projetoInicio.objetivo}
				 		</textarea><p class="hint">[Descrever o objetivo.]</p><br><br>
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family:Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family:Arial;"></span></font></h5>
				 	</td>
				 </tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Tipo Projeto <font color="red">*</font></b>
					<p align="justify"><font color="blue"></font>
						<input id="tipoprojeto" name="tipoprojeto" style="height: 30px; width: 379px;" value="${projetoInicio.tipoprojeto}" class="input" onkeypress="return Letras(event);" Placeholder="Digitar nome completo!"></input>
						<p class="hint">[Informar o tipo do projeto.]</p></p>
					</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Área <font color="red">*</font></b>
					<p align="justify"><input id="area" name="area" style="height: 30px; width: 379px;"
						value="${projetoInicio.area}" class="input" onkeypress="return Letras(event);"></input>
						<p class="hint">[Informar a área.]</p></td>
				</tr>	
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Cliente <font color="red">*</font></b>
					<p align="justify"><input id="cliente" name="cliente" style="height: 30px; width: 379px;"
						value="${projetoInicio.cliente}" class="input" onkeypress="return Letras(event);"></input>
						<p class="hint">[Informar o Cliente.]</p></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Programa <font color="red">*</font></b>
					<p align="justify"><input id="programa" name="programa" style="height: 30px; width: 379px;"
						value="${projetoInicio.programa}" class="input" onkeypress="return Letras(event);"></input>
						<p class="hint">[Informar o Programa.]</p></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Email: <font color="red">*</font></b>
					<p align="justify"><input id="copia" name="copia" style="height: 30px; width: 379px;"
						value="${projetoInicio.copia}" class="input" onkeypress="return Letras(event);"></input>
						<p class="hint">[Informar o E-mail.]</p></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr class="field">
					<td><p align="justify"><b>Roi <font color="red">*</font></b>
					<p align="justify"><input id="roi" name="roi" style="height: 30px; width: 100px"
						value="${projetoInicio.roi}" class="input"></input>
						<p class="hint">[Informar o ROI.]</p></td>
					</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
				</tr>
			</table><br><br>
					<input class="prev acao" type="submit" value="Atualizar" onclick="show_confirm();" onchange="validaCadastrarProjeto();" ></input>
		</fieldset>	
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
	</body>
</html>
