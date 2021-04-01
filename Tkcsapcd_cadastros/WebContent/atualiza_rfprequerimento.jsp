<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PautaReuniao"%>

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

<title>Atualizar RFP-Requerimento</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> 
<script src="js/jquery.maskedinput.js"></script>
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script><!-- Tratamento de erro, Ex campo não pode conter numeros, mas somente letras. -->
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaCadastrarRfpRequerimento.js"></script>

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
			location.href="TkcsapcdController?cmd=consultarRfpRequerimento";
				return false;
			}		
	}
</script>

<style TYPE="text/css" >     <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<div align="center">

		<form 	action="TkcsapcdController"  id="formularioRfpRequerimento" name="formularioRfpRequerimento" onsubmit="validaCadastrarRfpRequerimento()" onclick="validaCadastrarRfpRequerimento()"><br>

			<h2><img src="img/lapis.jpg" height="40px" width="50px">${mensagem}</h2>
			
			<br><center><p><font color="red">Atualizar RFP-Requerimento</font></p></center>
			<br>

			<div id="dialog"><p><font color="red">Campos de (*) obrigatório!</font></p></div>

			<br>
			
			<input type="hidden" name="cmd" value="atualizarRfpRequerimento"></input>			
			<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação -->
			
			<table 	bgcolor="#FFFFFF"				
					border="0" 
					bordercolor="gray" cellpadding="3" width="950">
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
					<td>Iten Avaliação *</td>
					<td><input id="itensavaliacao" name="itensavaliacao" class="input"
						style="height: 20px; width: 379px" value="${rfprequerimento.itensavaliacao}" maxlength="8"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td>Avaliação RFP *</td>
					<td><input id="avaliacaorfp" name="avaliacaorfp" class="input"
						style="height: 20px; width: 379px" value="${rfprequerimento.avaliacaorfp}"></input></td>
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
				<input class="button" type="submit" value="Atualizar" onclick="show_confirm()"></input>					
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>