<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.GerenciamentoEscopo"%>
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

<title>Cadastrar Plano de Gerenciamento Escopo</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroGerenciamentoEscopo.js"></script>
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
		$("#dataaprovacao").datepicker({
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
		$("#dataaprovacao").mask("99/99/9999"); //dataProjeto  
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
			location.href = "TkcsapcdController?cmd=consultarGerenciamentoEscopo";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("autorProjeto").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 10000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DO ESCOPO</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O Plano de gerenciamento do escopo (PGE) descreve como o escopo será definido, desenvolvido, monitorado, controlado e verificado.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Plano de gerenciamento do escopo</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Descreve como o escopo do projeto será definido, desenvolvido e verificado e como a estrutura analítica do projeto será criada e definida, fornecendo orientação sobre como o escopo do projeto será gerenciado e controlado pela equipe de gerenciamento de projetos. Ele faz parte ou é um plano auxiliar do plano de gerenciamento do projeto.<br><br>
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>
				<!-- Fim Modal explicando o objetivo da transação -->
				
				<center>
					<h3>
						<font color="green"> ${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red"> Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>
				<br> <input type="hidden" name="cmd" value="cadastrarGerenciamentoEscopo"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="100%"	bgcolor="#FFFFFF">
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
						<td><p align="justify">
								<b>Empresa <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="empresa" name="empresa"
									style="height: 30px; width: 379px" maxlength="150"
									value="${gerenciamentoEscopo.empresa}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o nome do cliente.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Orgão <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="orgao" name="orgao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${gerenciamentoEscopo.orgao}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Órgão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Setor <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="setor" name="setor"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${gerenciamentoEscopo.setor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o setor da empresa responsável pelo projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Programa <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="programa" name="programa"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${gerenciamentoEscopo.programa}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o programa da empresa que o projeto está inserido.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
								<td><p align="justify"><b>Projeto <font color="red">*</font></b>
								<p align="justify">
									<select id="projetoinicio" name="projetoinicio">
										<option id="projetoinicio">Selecione</option>
										<%
											List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
											for(ProjetoInicio ProjetoInicio: projetoInicios){
												out.println("<option value='" + ProjetoInicio.getCodigo() + "'>"
														                      + ProjetoInicio.getProjeto());
											}
										%>	
									</select><p class="hint">[Informar o projeto.]</p>
								</td>
					</tr>
					
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Gerente do projeto <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="gerente" name="gerente"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${gerenciamentoEscopo.gerente}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Gerente do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Elaborado por <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="funcao" name="funcao"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${gerenciamentoEscopo.funcao}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar nome e função.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprovado por <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="aprovado" name="aprovado"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${gerenciamentoEscopo.aprovado}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o responsável pela aprovação.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Versão <font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${gerenciamentoEscopo.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data de Aprovação <font color="red">*</font></b></td>
						<td><p align="justify">
								<input id="dataaprovacao" name="dataaprovacao"
									style="height: 30px; width: 100px"
									value="${gerenciamentoEscopo.dataaprovacao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data de Aprovação.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Objetivos do plano de gerenciamento do escopo <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,1000,'spcontando0');contarCaracteresEtapa1(this.value,1000,'sprestante0')"></textarea>
							<p class="hint">[Estabelecer como o escopo do projeto será gerenciado. Definir como serão tratadas e controladas as alterações do escopo.]</p>
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
								<b>Gerenciamento do escopo <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="gerenciamento" name="gerenciamento" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,1000,'spcontando');contarCaracteresEtapa2(this.value,1000,'sprestante')"></textarea>
							<p class="hint">[Gerenciamento do escopo.]</p>
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
								<b>Reuniões da equipe de projeto <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="reunioes_equipe" name="reunioes_equipe" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1000,'spcontando1');contarCaracteresEtapa3(this.value,1000,'sprestante1')"></textarea>
							<p class="hint">[Reuniões da equipe de projeto.]</p>
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
								<b>Reuniões de planejamento global<font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="reunioes_planejamento" name="reunioes_planejamento" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1000,'spcontando2');contarCaracteresEtapa4(this.value,1000,'sprestante2')"></textarea>
							<p class="hint">[Reuniões de planejamento global.]</p>
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
								<b>Reuniões gerenciais<font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="reunioes_gerenciais" name="reunioes_gerenciais" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,1000,'spcontando3');contarCaracteresEtapa5(this.value,1000,'sprestante3')"></textarea>
							<p class="hint">[Reuniões gerenciais.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Gerenciamento de modificações do escopo<font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="modificacao_escopo" name="modificacao_escopo" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,1000,'spcontando4');contarCaracteresEtapa6(this.value,1000,'sprestante4')"></textarea>
							<p class="hint">[Gerenciamento de modificações do escopo.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando4"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante4"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Lições Aprendidas<font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="licoes" name="licoes" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,1000,'spcontando5');contarCaracteresEtapa7(this.value,1000,'sprestante5')"></textarea>
							<p class="hint">[Lições Aprendidas.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando5"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante5"
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
	<%@ include file="rodape.jsp" %>
</body>
</html>
