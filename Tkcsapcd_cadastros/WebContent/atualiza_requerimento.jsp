<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="include.jsp" %>
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Requerimento"%><!-- Deve ser importado cada pacote, para resgatar os valores do BD. Ex: Value="" -->

<html>

<jsp:include page="sessao.jsp" />
<% 
	if(!session.getAttribute("login").toString().equals("3") /*&& !session.getAttribute("login").toString().equals("2")*/){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Atualizar Requerimento</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="/Tkcsapcd_cadastros/css/ui-lightness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="js/jquery.validate.min.js"></script> <!-- Validar Form -->
<script src="js/jquery.maskedinput.js"></script><!-- Validar Form -->
<%@include file="includedialogo.jsp" %><!-- / Dialogo -->
<%@include file="includemascara.jsp" %><!-- / Macara -->

<script language="javascript" src="js/TexteareCadastroRequerimento.js"></script><!-- Textarea Tratamento de erro -->
<script type="text/javascript" src="js/validaCadastrarRequerimento.js"></script>

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
	$(document).ready(function(){			
		//$("#data").mask("99/99/9999");   
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
				location.href="TkcsapcdController?cmd=consultarRequerimento";
			}		
	}
</script> 

<style TYPE="text/css" >     <!--	.input:focus{	background-color:#E7E8E7;	}    --></style>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp" %>

	<div align="center">
	
		<form action="TkcsapcdController" id="formulario" name="formulario" onsubmit="validaCadastrarRequerimento()" ><!-- onclick="validaCadastrarRequerimento()" -->
			
			<fieldset>
			
			<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">REQUERIMENTO</font></th></tr></table><br>	
						
			<center><h3><font color="red"> ${mensagem}</font></h3></center>
			
			<center><p><font color="red">Atualizar Requerimento</font></p></center><br>
									
			<div id="dialog"><p><font color="red">Campos de (<font color="red">*</font>) obrigatório!</font></p></div>
			
			<br>
			
			<script type="text/javascript" src="/Tkcsapcd_cadastros/js/FormValidaProjeto.js/"></script>
			
			<input type="hidden" name="cmd" value="atualizarRequerimento"></input>
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
				</tr>
				<tr>
					<td><p align="justify"><b>Requerimento Nome <font color="red">*</font></b></td>
					<td><p align="justify"><input id="nome" name="nome" style="height: 30px; width: 379px" class="input"
						value="${requerimento.nome}"></input></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
					 				 			
				 <tr>
				 	<td><p align="justify"><b>Descrição <font color="red">*</font></b></td>
				 	<td><p align="justify">
				 		<textarea rows="5" cols="70" id="descricao" name="descricao" onkeyup="mostrarResultadoDescricao(this.value,300,'spcontando0');contarCaracteresDescricao(this.value,300,'sprestante0')">${requerimento.descricao}</textarea>
				 		<br><br>
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family:Georgia;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family:Georgia;"></span></font></h5>
				 	</td>
				 </tr>				
				<tr>
					<td><br></td>
				</tr>
				 
				<tr>
					<td><p align="justify"><b>Resumo <font color="red">*</font></b></td>
					<td><p align="justify">
							<textarea id="resumo" rows="5" cols="70" name="resumo" onkeyup="mostrarResultado(this.value,300,'spcontando');contarCaracteres(this.value,300,'sprestante')">${requerimento.resumo}</textarea>
					 		<br><br>
					 		<!-- Atenção: esta linha é importante para mostra a infomracao na tela (em baixo do texarea), é necessario definir o id="" (diferente para cada texarea). -->
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando" style="font-family:Georgia;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante" style="font-family:Georgia;"></span></font></h5>
				 	</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				
				<tr>
					<td><p align="justify"><b>Requerimento Funcional <font color="red">*</font></b></td>
					<td><p align="justify">
						<textarea id="rqfuncional" rows="5" cols="70" name="rqfuncional" onkeyup="mostrarResultadoFuncional(this.value,300,'spcontando1');contarCaracteresFuncional(this.value,300,'sprestante1')">${requerimento.rqfuncional}</textarea>
				 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando1" style="font-family:Georgia;"></span></font></h5>
						<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante1" style="font-family:Georgia;"></span></font></h5>
				 	</td>
				</tr>				
				<tr>
					<td><br></td>
				</tr>
	
				<tr>
					<td><p align="justify"><b>Requerimento Tecnologico <font color="red">*</font></b></td>
					<td><p align="justify">
						<textarea id="rqtecnologico" rows="5" cols="70" name="rqtecnologico" onkeypress="return Letra(event);" onkeyup="mostrarResultadoTecnologico(this.value,300,'spcontando2');contarCaracteresTecnologico(this.value,300,'sprestante2')">${requerimento.rqtecnologico}</textarea>
				 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando2" style="font-family:Georgia;"></span></font></h5>
						<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante2" style="font-family:Georgia;"></span></font></h5>
				 	</td>
				</tr>						
				<tr>
					<td><br></td>
				</tr>
				
				<tr>
					<td><p align="justify"><b>Requerimento Status <font color="red">*</font></b></td>
					<td><p align="justify"><input id="rqstatus" name="rqstatus" style="height: 30px; width: 379px;" class="input"
						value="${requerimento.rqstatus}"></input></td>
				</tr>				
				<tr>
					<td><br></td>
				</tr>
		
				<tr>
					<td><p align="justify"><b>Concordo <font color="red">*</font></b></td>
					<td><p align="justify"><b>Desclaro que as informações citadas são verdadeiras e estou ciente de estar sujeito as penas pertinente caso tenha afirmado falsamente os dados preenchidos. <input id="concordo" name="concordo" type="checkbox" value="C"/></b></td>
					<td><p align="justify"></td>
				</tr>

				<tr>
					<th bgcolor="#F3F781"><br></th>									
					<th bgcolor="#F3F781"></th>
				</tr>
			</table>
			<br><br>
			<input class="acao" type="submit" value="Atualizar" onclick="show_confirm()" ></input>			
			</fieldset>
		</form>

	</div>
	<%@ include file="rodape.jsp" %>
</body>	
</html>