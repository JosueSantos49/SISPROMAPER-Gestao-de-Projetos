<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.Stakeholders"%>
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

<title>Cadastrar Stakeholders</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroProjeto.js"></script>
<script type="text/javascript" src="js/validaCadastrarStakeholders.js"></script>

<%@include file="autocompletar.jsp" %>

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
		$("#dataaprovacao").mask("99/99/9999"); 
		$('#telefone').mask("999-99999-9999");
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
			location.href = "TkcsapcdController?cmd=consultarStakeholders";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("codigoprojeto").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarStakeholders()">

			<fieldset>
			
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">REGISTRO DAS PARTES INTERESSADAS</font></th></tr>
				<tr>
						<td>
							<%@include file="menu_icon_geral.jsp" %>
						</td>
					</tr>
				</table><br>	
			
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> As partes interessadas (também chamados pelo termo inglês, stakeholders) são os indivíduos e as organizações ativamente envolvidos no projeto, ou seja, quem interessa no seu projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title"> Partes interessadas (Stakeholders)</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O projeto irá atender necessidades das partes interessadas e elas são responsáveis por atender o objetivo do projeto.
										Podem ser positivamente ou negativamente afetados com a execução do projeto e irão influenciar o projeto e/ou seu resultado.<br><br>										
										Vale ressaltar algumas partes interessadas muito importantes para o projeto:<br><br>									
										Cliente: o projeto irá atender sua(s) necessidade(s);<br><br>
										Patrocinador: quem está financiando o projeto;<br><br>
										Gerente de projeto: quem faz a gestão do projeto e orquestra todas as partes interessadas de modo a alcançar os objetivos do projeto;<br><br>
										Equipe do Projeto: todos responsáveis por atividades no projeto, precisam estar motivados e alinhados com os objetivos do projeto;<br><br>
										Entre outras, como o PMO, gerente responsável pelo Escritório de Projetos, a organização, os fornecedores, população afetada, etc.<br><br>
										Quais são os interesses das partes interessadas?<br><br>
										Clientes: produto mais barato com maior qualidade;<br><br>
										Parceiros /Fornecedores: maior lucro;<br><br>
										Executivos<br>
										- Visibilidade; Redução de custos; Desempenho<br><br>
										Time do Projeto<br>
										- Parte dos resultados; Excelência técnica; Autonomia<br>
										- Interesses individuais.<br><br>
										Gerentes<br>
										- Cumprir suas metas; Não compartilhar seus recursos; Menos stress e pressão.<br>
										
										Quem são as partes interessadas mais críticas?<br><br>
										Poder de alocação sobre recursos críticos dos projetos<br><br>
										
										Escopo (Poder de veto)<br>
										$$$<br>
										Pessoas<br><br>
										Patrocinador<br>
										Designado para especificar o produto<br>
										Chefe hierárquico pela equipe do projeto<br>
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
						<font color="green">${mensagem}</font>
					</h3>
				</center>
				
				<div id="dialog">
					<p>
						<font color="red">Campo (*) obrigatório.<br></font>
					</p>
					<br>
				</div>
				<br> <input type="hidden" name="cmd" value="cadastrarStakeholders"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="100%"	bgcolor="#FFFFFF">					
					<tr>
						<td><br>
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
									value="${stakeholders.empresa}" class="input" required="true" class="form-control"
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
									value="${stakeholders.orgao}" class="input" required="true"
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
									value="${stakeholders.setor}" class="input" required="true"
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
									value="${stakeholders.programa}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o programa da empresa que o projeto está inserido.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código do Projeto <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 300px"
									class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o código do Projeto.]</p></td>
					</tr>										
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Nome do Projeto <font color="red">*</font></b>
							</p></td>
						<td><p align="justify">
								<input id="projeto" name="projeto"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${stakeholders.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Nome do Projeto.]</p></td>
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
									value="${stakeholders.gerente}" class="input" required="true"
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
									value="${stakeholders.funcao}" class="input" required="true"
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
									value="${stakeholders.aprovado}" class="input" required="true"
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
									value="${stakeholders.versao}" class="input" required="true"></input>
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
									value="${stakeholders.dataaprovacao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data de Aprovação.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Referência <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="referencia"
									name="referencia" style="height: 30px; width: 379px"
									value="${stakeholders.referencia}"
									onkeypress="return Letras(event);" class="input" required="true"></input>
							<p class="hint">[Informar a referência.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Nome <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="nome"
									name="nome" style="height: 30px; width: 379px"
									value="${stakeholders.nome}"
									onkeypress="return Letras(event);" class="input" required="true"></input>
							<p class="hint">[Informar o Nome.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Empresa/Equipe <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="empresaequipe"
									name="empresaequipe" style="height: 30px; width: 379px"
									value="${stakeholders.empresaequipe}"
									onkeypress="return Letras(event);" class="input" required="true"></input>
							<p class="hint">[Informar a Empresa/Equipe.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Cargo/Competência <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="cargocompetencia"
									name="cargocompetencia" style="height: 30px; width: 379px"
									value="${stakeholders.cargocompetencia}"
									onkeypress="return Letras(event);" class="input" required="true"></input>
							<p class="hint">[Informar o Cargo/Competência.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>E-mail <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="email"
									name="email" style="height: 30px; width: 379px"
									value="${stakeholders.email}"
									onkeypress="return Letras(event);" class="input" required="true"></input>
							<p class="hint">[Informar o email.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Telefone/Fax <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="telefone"
									name="telefone" style="height: 30px; width: 379px"
									value="${stakeholders.telefone}"
									onkeypress="return numbers(event);"class="input" required="true"></input>
							<p class="hint">[Informar o telefone.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Endereço <font color="red">*</font></b></td>
						<td><p align="justify">
								<font color="blue"></font> <input id="endereco"
									name="endereco" style="height: 30px; width: 379px"
									value="${stakeholders.endereco}"
									class="input" required="true"></input>
							<p class="hint">[Informar o endereço.]</p>
							</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Observação <font color="red"></font></b></td>
						<td><p align="justify">
								<font color="blue"></font>
							</p> <textarea id="obs" name="obs"
								onkeyup="mostrarResultadoDescricao(this.value,400,'spcontando0');contarCaracteresDescricao(this.value,400,'sprestante0')"></textarea>
							<p class="hint">[Caso necessário descrever uma observação.]</p>
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
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar"
					onclick="show_confirm();" onchange="validaCadastrarStakeholders();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
