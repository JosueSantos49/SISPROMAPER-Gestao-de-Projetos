<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="sessao.jsp" />

<head>

<jsp:include page="sessao.jsp" />
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Resultado de envio de E-mail</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">
<link rel="stylesheet" href="css/menuperante.css" type="text/css">

</head>

<body>

<div align="left" id="menuEmailForm"><%@include file="menuperantecssemailform.jsp"%></div>

<br><br><br><br>
<div align="center">
	<table border="0" height="300" width="45%" align="center" bgcolor="#D8F6CE">

		<tr>
			<td>
					<div align="center">
						<table border="0" width="35%" align="center">
							<tr><td colspan="1" align="center"><font color="red"><h3><%=request.getAttribute("Message")%></h3></font></td>							</tr>
						</table>
					</div>
					<br>
			</td>
		</tr>
	</table>
</div>
</body>
</html>