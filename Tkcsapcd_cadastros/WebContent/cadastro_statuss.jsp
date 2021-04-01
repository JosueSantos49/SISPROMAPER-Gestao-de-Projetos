<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Acessando a biblioteca java	 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- Classe especialista em formatação	 -->
<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Statuss"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>

<html>

<jsp:include page="sessao.jsp" />

<% 
	if(!session.getAttribute("login").toString().equals("3") && !session.getAttribute("login").toString().equals("2")){
		response.sendRedirect(request.getContextPath()+"/erro.jsp");  
	}		
%>

<head>

<link rel="shortcut icon" href="img/logoavl.jpg" type="image/x-icon"><!-- Icone na aba da página -->

<title>Cadastrar Status</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroStatus.js"></script><!-- Textarea Tratamento de erro -->
<script type="text/javascript" src="js/validaCadastroStatuss.js"></script>

<!-- Calendário -->
<script>
			$(function() {
				$("#datastatus").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>
<script>
			$(function() {
				$("#datainicio").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>
<script>
			$(function() {
				$("#datafim").datepicker({
					dateFormat: 'dd/mm/yy',
					showOn : "button",
					buttonImage : "img/calendar.gif",
					buttonImageOnly : true
				});
			});
</script>

<!-- / Calendário -->
<script type="text/javascript">
		/<font color="red">*</font>/<font color="red">*</font>Janela de dialogo exemplo 2<font color="red">*</font>/		
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
		//$("#percentualevolucao").mask("99");
		//$("#percentualplanejado").mask("99");
		$("#datastatus").mask("99/99/9999");   
		$("#datainicio").mask("99/99/9999");  
		$("#datafim").mask("99/99/9999");  
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
				location.href="TkcsapcdController?cmd=consultarStatuss";
			}		
	} 
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp" %>

	<div align="center">
	
		<form 	action="TkcsapcdController" id="formulario" name="formulario" onSubmit="validaCadastroStatuss()" >
			
			<fieldset>
			
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">STATUS DO PROJETO - PROJECT CHARTER</font></th></tr></table>	
						
			<center><h3><font color="green"> ${mensagem}</font></h3></center>
						
			<div id="dialog"><p><font color="red">Campos de (<font color="red">*</font>) obrigatório.</font></p></div>
			
			<br>
			<input type="hidden" name="cmd" value="cadastrarStatuss"></input>			
			<table	border="0" cellspacing="3" cellpadding="3" width="80%" bgcolor="#FFFFFF">				
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Nome do projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="projeto" name="projeto"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${statuss.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<select id="codigodoprojeto"	name="codigodoprojeto">
								<option id="codigodoprojeto"></option>
								<%
									List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
									for(ProjetoInicio ProjetoInicio: projetoInicios){
										out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
												                      + ProjetoInicio.getCodigoprojeto());
									}
								%>
						</select>
							<p class="hint">[Informar o código do Projeto.]</p></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify"><b>Fase do Projeto</b> <font color="red">*</font>
					<p align="justify"><input  id="fase" name="fase" style="height: 30px; width: 379px" class="input"
						value="${statuss.fase}" onkeypress="return Letra(event);" required="true"></input></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify"><b>Percentual Evolução</b> <font color="red">*</font>
					<p align="justify"><input maxlength="50" id="percentualevolucao" name="percentualevolucao" style="height: 30px; width: 379px" class="input"
						value="${statuss.percentualevolucao}" onkeypress="javascript: return numbers(event);" required="true"></input></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><p align="justify"><b>Percentual Planejado</b> <font color="red">*</font>
					<p align="justify"><input maxlength="50" id="percentualplanejado" name="percentualplanejado" style="height: 30px; width: 379px" class="input"
						value="${statuss.percentualplanejado}" onkeypress="javascript: return numbers(event);" required="true"></input></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>			
				<tr>
					<td><p align="justify"><b>Data Status <font color="red">*</font></b>
					<p align="justify"><input id="datastatus" name="datastatus" style="height: 30px; width: 100px;" class="input"
						value="${statuss.datastatus}" maxlength="10" ></input></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>			
				 <tr>
				 	<td><p align="justify"><b>Descrição</b> <font color="red">*</font>
				 	<p align="justify">
				 		<textarea rows="5" cols="70" id="descricao" name="descricao" onkeyup="mostrarResultadoDescricao(this.value,400,'spcontando0');contarCaracteresDescricao(this.value,400,'sprestante0')" required="true"></textarea>
				 		<br><br>
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family:Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family:Arial;"></span></font></h5>
				 	</td>
				 </tr>
				
				<tr>
					<td><br></td>					
				</tr>
	
				<tr>
					<td><p align="justify"><b>Pontos Positivos <font color="red">*</font></b>
					<p align="justify">
							<textarea id="pontospositivos" rows="5" cols="70" name="pontospositivos" onkeyup="mostrarResultado(this.value,300,'spcontando');contarCaracteres(this.value,300,'sprestante')" required="true"></textarea>
					 		<br><br>
					 		<!-- Atenção: esta linha é importante para mostra a infomracao na tela (em baixo do texarea), é necessario definir o id="" (diferente para cada texarea). -->
					 		<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando" style="font-family:Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante" style="font-family:Arial;"></span></font></h5>
				 	</td>
				</tr>
				<tr>
					<td><br></td>					
				</tr>
		
				<tr>
					<td><p align="justify"><b>Pontos Negativos <font color="red">*</font></b>
					<p align="justify">
						<textarea id="pontosnegativos" rows="5" cols="70" name="pontosnegativos" onkeyup="mostrarResultadoQualitativo(this.value,300,'spcontando1');contarCaracteresQualitativo(this.value,300,'sprestante1')" required="true"></textarea>
						<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando1" style="font-family:Arial;"></span></font></h5>
						<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante1" style="font-family:Arial;"></span></font></h5>
				 	</td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
	
				<tr>
					<td><b><p align="justify">Tendência <font color="red">*</font></b>
					<p align="justify"><input id="tendencia" name="tendencia" style="height: 30px; width: 379px;" class="input"
						value="${statuss.tendencia}" required="true"></input></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>

				<tr>
					<td><p align="justify"><b>Data Início</b>
					<p align="justify"><input id="datainicio" name="datainicio" style="height: 30px; width: 100px;" class="input"
						value="${statuss.datainicio}" maxlength="10"></input></td>
				</tr>	
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>		
				<tr>
					<td><p align="justify"><b>Data Fim</b>
					<p align="justify"><input id="datafim" name="datafim" style="height: 30px; width: 100px;" class="input"
						value="${statuss.datafim}" maxlength="10"></input></td>
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
					<input class=" acao" type="submit" value="Cadastrar" onclick="show_confirm();" onchange="validaCadastrarStatuss();" ></input>
					<input class=" acao" type="reset" value="Limpar" ></input>	
			</fieldset>				
		</form>	

</div>
<%@include file="rodape.jsp" %>
</body>
</html>