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
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Métricas</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaCadastrarMetrica.js"></script>

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
			location.href="TkcsapcdController?cmd=consultarMetricas";
			}		
	}
</script>

<style TYPE="text/css" >    <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

<div align="center">

		<form 	action="TkcsapcdController" id="formulario" name="formulario" onSubmit="validaCadastrarMetrica()" onclick="validaCadastrarMetrica()"><br>

			<fieldset>			
			
			<img src="img/lapis.jpg" height="40px" width="50px">${mensagem}<br>
			
				<br><center><p><font color="red">Atualizar Métricas</font></p></center><br>
				
				<div id="dialog"><p><font color="red">Campos de (*) obrigatório.</font></p></div><br>
				
				<input type="hidden" name="cmd" value="atualizarMetricas"></input>			
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
					<td><p align="justify">ID *</td>
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
					<td><p align="justify">Nome Métrica *</td>
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
					<td><p align="justify">Indice da Métrica *</td>
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
					<td><p align="justify">Valor Referência - Hora*</td>
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
					<td><p align="justify">Valor Hora Calculada - Dia *</td>
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
			</table><br>
					<input class=" acao" type="submit" value="Atualizar" onclick="show_confirm()" onchange="validaCadastrarProjeto();"></input>
			</fieldset>		
		</form>		
</div>
<%@ include file="rodape.jsp" %>
</body>
</html>