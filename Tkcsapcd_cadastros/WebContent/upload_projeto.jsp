<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List,br.com.tkcsapcd.model.bean.FileBeanProjeto"%>
<html>

<jsp:include page="sessao.jsp" />

<%
	if (!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")) {
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon">

<title>Upload de Arquivo Projeto</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroUploadProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
-->
</style>

<!-- Calendário -->
<script>
	$(function() {
		$("#dataregistro").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>

<!-- Dialogo -->
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			height : 150,
			modal : true,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#dataregistro").mask("99/99/9999");  
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
	function show_confirm() {

		var r = confirm("Click em OK, para continuar!");
		if (r == true) {
			alert("Continuando...");
			return true;
		} else {
			alert("Click em OK, para cancelar!");
			location.href = "TkcsapcdController?cmd=consultarFilebeanProjeto";

		}
	}
</script>

<script type="text/javascript">
/*onload="setFocus();"*/
	function setFocus() {
		document.getElementById("codigoprojeto").focus();
	}
</script>


</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000);" >

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="uploadProjeto.do" id="formulario" name="formulario" enctype="multipart/form-data" method="post">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">UPLOAD DE ARQUIVO PROJETO</font></th></tr></table><br>				
								
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>

				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					<tr>
						<td>
							<p>
								<font color="red">Campos de (*) obrigatório.</font>
							</p>
							<br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					
					<tr class="field">
						<td><p align="justify"><b>Descrição <font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="description" id="description" required="true" style="height: 30px; width: 379px" maxlength="150" class="input"><br/>
							<p class="hint">[Informar descrição.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Arquivo <font color="red">*</font></b></p>
						<p align="justify">
								<input type="file" name="file" id="file" required="true"><br/>
							<p class="hint">[Informar o arquivo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Código Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="codigoprojeto" id="codigoprojeto" required="true" style="height: 30px; width: 150px" maxlength="150" class="input"><br/>
							<p class="hint">[Informar o código do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentário <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentario" name="comentario" 
								onkeyup="mostrarResultadoEtapa1(this.value,800,'spcontando0');contarCaracteresEtapa1(this.value,800,'sprestante0')"></textarea>
							<p class="hint">[Comentário.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando0"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante0"
									style="font-family: Arial;"></span></font>
							</h5></td>
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
						<td><p align="justify">
								<b>Data <font color="red">*</font></b>
						<p align="justify">
								<input id="dataregistro" name="dataregistro" value="00/00/0000"
									style="height: 30px; width: 100px"
									class="input"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>E-mail Confirmação <font color="red">*</font></b></p>
						<p align="justify">
								<input type="text" name="email" id="email"
									style="height: 30px; width: 379px" 
									maxlength="150" 
									placeholder="Destinatário"
									class="input" ></input>
							<p class="hint">[Inserir e-mail para receber confirmação de registro, por e-mail.]</p></td>
					</tr>
				</table>
				<br>
				 <input type="submit" value="Enviar" class="prev acao" onclick="show_confirm();"/>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>

