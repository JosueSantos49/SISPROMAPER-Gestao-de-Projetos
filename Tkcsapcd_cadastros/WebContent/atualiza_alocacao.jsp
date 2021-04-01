<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.tkcsapcd.model.util.Valida"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<%@page import="br.com.tkcsapcd.model.bean.TermoAberturaProjeto"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.RecursosHumanos"%>
<jsp:useBean id="alocacao" scope="request" class="br.com.tkcsapcd.model.bean.Alocacao"></jsp:useBean><!-- Deve ser importado cada pacote, para resgatar os valores do BD. Ex: Value="" -->

<%@include file="include.jsp" %><!-- Depois que coloquei o include, a cor do tratamento de erro funcionou. -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Alocação</title> 

<style TYPE="text/css" > <!--.input:focus{	background-color:#E7E8E7;	}  --></style>
<link rel="stylesheet" href="css/formatarformulariobutomelegante.css" type="text/css">
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->
<script type="text/javascript" src="js/validaalocacao.js"></script>
<script type="text/javascript" src="js/validaFormularioAlocacao.js"></script>
		
<!-- Calendário -->
<script>
			$(function() {
				$("#data").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>
<script>
			$(function() {
				$("#data0").datepicker({
					dateFormat: 'dd/mm/yy',
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
	$(function() {
		$("#").tabs();
	});
</script>

<script type="text/javascript">	$(document).ready(function(){$("#dataProjeto").mask("99/99/9999");	});</script>	

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
				location.href="TkcsapcdController?cmd=consultarProjeto";
				
			}		
	}
</script>

<script type="text/javascript">	function setFocus() {  	document.getElementById("autorProjeto").focus();}</script>

</head>

<%	Valida valida = new Valida();	valida.validasessao();%>

<body  bgcolor="#ededed" onload="tamanhooriginal(); setFocus();">

<%@include file="menuperantecssalocacao.jsp" %>

<div align="center">	
	
	<br><div align="center"><p><font color="red">Atualizar Alocação - Campos de (*) obrigatório!</font></p></div>
	
		<form action="TkcsapcdController"	id="formularioAlocacao"	name="formularioAlocacao" onsubmit="validaalocacao();" onclick="validaalocacao()">
		
			<center><h3><font color="red"> ${mensagem}</font></h3></center>			
					
			<div id="dialog"><p><font color="red">Campos de (*) obrigatório!</font></p></div>
			<br>
			
			<input type="hidden" name="cmd" value="atualizarAlocacao"></input>
			<input type="hidden" name="codigo" value="${param.codigo}"></input><!-- Parametro que veio na modificação, codigo usado para modificar o registro -->
			
				<table 
					bgcolor="#FFFFFF"
					style="color: #004080; 
					font-size: 11px; 
					font-family: Tahoma, Verdana, Arial, Sans-Serif; 
					font-weight: bold; 
					border-left-color: #8080C0; 
					border-top-color: #8080C0; 
					border-right-color: #8080C0; 
					border-bottom-color: #8080C0"
					border="0" bordercolor="gray" cellpadding="3" width="1010">
				<thead>
					<tr>
						<th>						
			
						
						</th>
						<th></th>
					</tr>
				</thead>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
				</tr>
				<tr>
					<td><br></td>
					<td>
						<div align="left">
							<!-- <input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input> ---- <input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input>	 -->					
						</div>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><br></td>
					<td>
						
					</td>
					<td colspan="20">
						<div align="center">
							<input id="data" name="data" style="height: 12px; width: 100px"	value="${alocacao.data}" class="input"></input>* ---- <input id="data0" name="data0" style="height: 12px; width: 100px"	value="${alocacao.data0}" class="input"></input>*						
						</div>
					</td>
				</tr>				
				<tr>
					<td align="left">Projeto <font color="red">*</font></td>					
					<td>
							
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><br>
					<div align="left">
						<p align="justify"><input id="projeto_codigo" name="projeto_codigo" class="input"
							style="height: 12px; width: 150px" value="${alocacao.projeto_codigo}" onkeypress="return numbers(event);"></input>
					</div>						
					<br></td>
					<td></td>
					<td colspan="20"><center><font color="#A9E2F3">FY13/14 *</font> ------------------------------------------------------- <font color="#FA8258">FY14/15 *</font></center></td>
				</tr>
				<tr>
					<td><br></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>				
				<tr>
					<td align="left">Recursos Humanso <font color="red">*</font></td>
					<td align="left">Profissão <font color="red">*</font></td>
					<td width="80px" bgcolor="#A9E2F3">Apr</td>
					<td width="80px" bgcolor="#A9E2F3">May</td>
					<td width="80px" bgcolor="#A9E2F3">Jun</td>
					<td width="80px" bgcolor="#A9E2F3">Jul</td>
					<td width="80px" bgcolor="#A9E2F3">Aug</td>
					<td width="80px" bgcolor="#A9E2F3">Sep</td>
					<td width="80px" bgcolor="#FA8258">Oct</td>
					<td width="80px" bgcolor="#FA8258">Nov</td>
					<td width="80px" bgcolor="#FA8258">Dec</td>
					<td width="80px" bgcolor="#FA8258">Jan</td>
					<td width="80px" bgcolor="#FA8258">Feb</td>
					<td width="80px" bgcolor="#FA8258">Mar</td>
					<td width="80px" bgcolor="#FA8258">Apr</td>
					<td width="80px" bgcolor="#FA8258">May</td>
					<td width="80px" bgcolor="#FA8258">Jun</td>
					<td width="80px" bgcolor="#FA8258">Jul</td>
				</tr>
				<tr>
					<td><br>
						<div align="left">
							<p align="justify"><input id="recursoshumanos_codigo" name="recursoshumanos_codigo" class="input"
							style="height: 12px; width: 150px" value="${alocacao.recursoshumanos_codigo}" onkeypress="return numbers(event);"></input>					
						</div>
						<br>
					</td>
					<td><br>
						<div align="left">
							<p align="justify"><input id="profissao_codigo" name="profissao_codigo" class="input"
							style="height: 12px; width: 150px" value="${alocacao.profissao_codigo}" onkeypress="return numbers(event);"></input>
						</div>
						<br>
					</td>
					<td><input id="metrica1" name="metrica1" style="height: 12px; width: 30px"	value="${alocacao.metrica1}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica2" name="metrica2" style="height: 12px; width: 30px"	value="${alocacao.metrica2}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica3" name="metrica3" style="height: 12px; width: 30px"	value="${alocacao.metrica3}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica4" name="metrica4" style="height: 12px; width: 30px"	value="${alocacao.metrica4}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica5" name="metrica5" style="height: 12px; width: 30px"	value="${alocacao.metrica5}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica6" name="metrica6" style="height: 12px; width: 30px"	value="${alocacao.metrica6}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica7" name="metrica7" style="height: 12px; width: 30px"	value="${alocacao.metrica7}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica8" name="metrica8" style="height: 12px; width: 30px"	value="${alocacao.metrica8}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica9" name="metrica9" style="height: 12px; width: 30px"	value="${alocacao.metrica9}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica10" name="metrica10" style="height: 12px; width: 30px"	value="${alocacao.metrica10}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica11" name="metrica11" style="height: 12px; width: 30px"	value="${alocacao.metrica11}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica12" name="metrica12" style="height: 12px; width: 30px"	value="${alocacao.metrica12}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica13" name="metrica13" style="height: 12px; width: 30px"	value="${alocacao.metrica13}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica14" name="metrica14" style="height: 12px; width: 30px"	value="${alocacao.metrica14}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica15" name="metrica15" style="height: 12px; width: 30px"	value="${alocacao.metrica15}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
					<td><input id="metrica16" name="metrica16" style="height: 12px; width: 30px"	value="${alocacao.metrica16}" class="input" maxlength="4" onkeypress="javascript: return numbers(event);"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
					<th bgcolor="#F3F781"></th>
				</tr>				
			</table>
  			<input class="button" type="submit" value="Atualizar" onclick="show_confirm();" onchange="validaCadastrarProjeto();" ></input>
			<input class="button" type="button" name="cancelar" onclick="document.location.href='sair.jsp'" value="Sair" title="Encerrar sessão" />
		</form>
	</div>
	</body>
</html>
