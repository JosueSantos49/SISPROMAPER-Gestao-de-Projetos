<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<% 

	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}
		
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->


<title>Enviar um email</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link rel="stylesheet" href="css/formatacaoButton.css" type="text/css">
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/validaEmailForm.js"></script>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validacaoFormularioEmail.js"></script>

<script type="text/javascript">
/*função valida email*/
function valida_form()
	{
	var x=document.forms["emailForm"]["recipient"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
	alert("Não é um endereço de e-mail válido!\n\nEntre com um endereço de e-mail válido.");
	return false;
	}
	return true;
}
</script>

</head>

<body>

<div align="left" id="menuEmailForm"><%@include file="menuperantecssemailform.jsp"%></div>

<br>
	
<div align="center">

	<table border="0" width="50%" align="center" bgcolor="#D8F6CE">

		<tr>
			<td>

				<form action="EmailSendingServlet" id="emailForm" name="emailForm" method="post" onsubmit="valida_form()" ><!-- onclick="valida_form()" -->
					
					<div align="center">
					
					<table border="0" width="35%" align="center">

						<caption>
							<br>
							<strong><font color="#528B8B"><h2>Enviar E-mail</h2></strong></font><br>
							<div align="center"><font color="red">Campos de (*) são de preenchimento obrigatório.</font><br></div>	
							<br>
						</caption>
						<tr>
							<td width="50%"></td>
							<td></td>
						</tr>
						<tr>
							<td width="50%"><strong><font color="#528B8B">E-mail Destinatário:</font></strong></td>
							<td><font color="red">*</font><input type="text" id="recipient" name="recipient" style="height: 20px; width: 450px" required="true" Placeholder="exemplo@exemplo.com.br"/> </td>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
						</tr>
						<tr>
							<td><strong><font color="#528B8B">Assunto:</font></strong></td>
							<td><font color="red">*</font><input type="text" id="subject"  name="subject" style="height: 20px; width: 450px" required="true"/></td>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
						</tr>
						<tr>
							<td><strong><font color="#528B8B">Conteúdo:</font></strong></td>
							<td><div align="center"><textarea rows="10" cols="55" name="content"></textarea></div></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><br>
							<input class="button" type="submit" value="Enviar"/>
							<input class="button" type="reset" value="Limpar" /></td>
							
						</tr>
					</table>
					</div>
					<br>
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>