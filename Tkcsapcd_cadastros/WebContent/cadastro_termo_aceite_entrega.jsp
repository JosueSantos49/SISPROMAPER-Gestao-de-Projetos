<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.DicionarioEAP"%>
<%@ page import="java.util.List, br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@ page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
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

<title>Cadastrar Termo de Aceite da Entrega</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroTermoAceiteEntrega.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
}
.conf_operacao{
	position: fixed;
	
}
-->
</style>

<!-- Calend�rio -->
<script>
	$(function() {
		$("#data").datepicker({
			dateFormat : 'dd/mm/yy',
			showOn : "button",
			buttonImage : "img/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<script>
	$(function() {
		$("#dataimplantacaoprevista").datepicker({
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
		$("#data").mask("99/99/9999"); //dataProjeto  
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
			location.href = "TkcsapcdController?cmd=consultarTermoAceiteEntrega";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planogerenciamentoqualidade").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>			
				
				<table width="100%" class="table table-striped">
					<tr class="success">
						<th bgcolor="#FFFF00">
							<font size="3">TERMO DE ACEITE DA ENTREGA</font>
						</th>
					</tr>					
				</table>
				
				<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O Termo de aceite da entrega formaliza o aceite da entrega considerando-a em conformidade com os requisitos e os crit�rios de aceita��o definidos. Formaliza��o ou Aceite da Entrega do Projeto. Pode ser usada tanto para entregas parciais ou a entrega final do projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Termo de aceite da entrega</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Entregas Aceitas: as entregas aceitas e validadas do ponto de vista de qualidade ser�o entregues ao cliente do projeto, que pode ser interno ou externo, essas entregas devem ser devidamente documentadas para que n�o restem d�vidas sobre a conclus�o do projeto.
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
				<!-- Fim Modal explicando o objetivo da transa��o -->	
				
				
							
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigat�rio.<br></font>
					</p>
					<br>
				</div>
				<br> <input type="hidden" name="cmd" value="cadastrarTermoAceiteEntrega"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="80%"	bgcolor="#FFFFFF">
					<tr>
						<td>
							<p>
								<font color="red">Campos de (*) obrigat�rio.</font>
							</p>
							<br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Termo <font color="red">*</font></b></p>
						<p align="justify">
								<input id="termo" name="termo"
									style="height: 30px; width: 379px" maxlength="150"
									value="${termoAceiteEntrega.termo}" class="input" required="true"></input>
							<p class="hint">[Informar o termo]</p></td>
					</tr>
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
									value="${dicionarioEAP.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<!-- <tr class="field">
						<td><p align="justify">
								<b>C�digo do Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${dicionarioEAP.codigoprojeto}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o c�digo do Projeto.]</p></td>
					</tr>-->
					<tr class="field">
						<td><p align="justify">
								<b>C�digo do Projeto <font color="red">*</font></b>
							</p>
						<p align="justify">
						<select id="codigoprojeto"	name="codigoprojeto">
								<option id="codigoprojeto">Selecione</option>
								<%
									List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
									for(ProjetoInicio ProjetoInicio: projetoInicios){
										out.println("<option value='" + ProjetoInicio.getCodigoprojeto() + "'>"
												                      + ProjetoInicio.getCodigoprojeto());
									}
								%>
						</select>
							<p class="hint">[Informar o c�digo do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivos deste documento  <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,450,'spcontando0');contarCaracteresEtapa1(this.value,450,'sprestante0')"></textarea>
							<p class="hint">[Descreva o motivo pelo qual esse documento ser� usado. Caso exista quest�es em aberto, incluir: Este documento formaliza o aceite da entrega considerando-a em conformidade com os requisitos e os crit�rios de aceita��o definidos.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Entrega  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="entrega" name="entrega" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,450,'spcontando');contarCaracteresEtapa2(this.value,450,'sprestante')"></textarea>
							<p class="hint">[Descrever a entrega com seus requisitos e crit�rios de aceita��o ou referencie o documento que ser� anexado. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Quest�es em Aberto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="questao" name="questao" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,450,'spcontando1');contarCaracteresEtapa3(this.value,450,'sprestante1')"></textarea>
							<p class="hint">[Usar caso haja alguma quest�o pendente em rela��o � entrega. Retirar a se��o caso n�o houver nenhum ponto em aberto. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando1"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante1"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Informa��es adicionais <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="informacao" name="informacao" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,450,'spcontando2');contarCaracteresEtapa4(this.value,450,'sprestante2')"></textarea>
							<p class="hint">[Informa��es adicionais]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando2"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante2"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aceite da Entrega<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aceite" name="aceite" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,450,'spcontando3');contarCaracteresEtapa5(this.value,450,'sprestante3')"></textarea>
							<p class="hint">[Os participantes atestam o cumprimento dos requisitos e dos crit�rios de aceita��o da entrega.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando3"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante3"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar"
					onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@include file="rodape.jsp" %>
</body>
</html>
