<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.RegistroRisco"%>
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

<title>Cadastrar Registro dos Riscos</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareRegistroRisco.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarRegistroRisco";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("registroRisco").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">REGISTRO DOS RISCOS</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O registro dos riscos é feito principalmente, no processo 11.2 Identificar os riscos, mas, é sempre revisado de acordo com a criação de novos planos.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Registro dos Riscos</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	Saída de: 11.2 Identificar os riscos.<br><br>
										Entrada para: 									
										7.1 Estimar os custos<br>
										8.1 Planejar o gerenciamento da qualidade<br>
										11.3 Realizar a análise qualitativa dos riscos<br>
										11.4 Realizar a análise quantitativa dos riscos<br>
										11.5 Planejar as respostas aos riscos<br>
										11.6 Monitorar e controlar os riscos<br>
										12.1 Planejar as aquisições
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
				<br> 
				<input type="hidden" name="cmd" value="cadastrarRegistroRisco"></input>
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
						<td><p align="justify"><b>Registro Risco <font color="red">*</font></b></p>
						<p align="justify">
								<input id="registrorisco" name="registrorisco"
									style="height: 30px; width: 379px" maxlength="150"
									value="${registroRisco.registrorisco}" class="input" required="true"></input>
							<p class="hint">[Informar Registro Risco.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Referência <font color="red">*</font></b></p>
						<p align="justify">
								<input id="referencia" name="referencia"
									style="height: 30px; width: 379px" maxlength="150"
									value="${registroRisco.referencia}" class="input" required="true"></input>
							<p class="hint">[Informar Referência.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Projeto <font color="red">*</font></b></p>
						<p align="justify">
								<select id="projetoinicio"	name="projetoinicio">
								<option id="projetoinicio"></option>
								<%
									List<ProjetoInicio> projetoInicios = (List<ProjetoInicio>) request.getAttribute("projetoInicios");
									for(ProjetoInicio ProjetoInicio: projetoInicios){
										out.println("<option value='" + ProjetoInicio.getCodigo() + "'>"
												                      + ProjetoInicio.getProjeto());
									}
								%>
						</select>
							<p class="hint">[Informar o código do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Versão <font color="red">*</font></b>
						<p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${registroRisco.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data <font color="red">*</font></b>
						<p align="justify">
								<input id="data" name="data"
									style="height: 30px; width: 100px"
									value="${registroRisco.data}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Autor <font color="red">*</font></b></p>
						<p align="justify">
								<input id="autor" name="autor"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${registroRisco.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Notas de revisão <font color="red">*</font></b></p>
						<p align="justify">
								<input id="notarevisao" name="notarevisao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${registroRisco.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revisão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Passos <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="passos" name="passos" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,1500,'spcontando0');contarCaracteresEtapa1(this.value,1500,'sprestante0')"></textarea>
							<p class="hint">[Incluir todos os riscos identificados.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Severidade <font color="red">*</font></b>
							<p align="justify">
								<select id="severidade" name="severidade" required="true">
									<option value="">......</option>
									<option value="1">1-Muito baixa</option>
									<option value="2">2-Baixa</option>
									<option value="3">3-Média</option>
									<option value="4">4-Alta</option>
									<option value="5">5-Muito Alta</option>
								</select>
							<p class="hint">[Informar Severidade.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Descrição do risco  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="descricao" name="descricao" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,1500,'spcontando');contarCaracteresEtapa2(this.value,1500,'sprestante')"></textarea>
							<p class="hint">[Informar descricao.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>Probabilidade <font color="red">*</font></b>
							<p align="justify">
								<select id="probabilidade" name="probabilidade" required="true">
									<option value="">......</option>
									<option value="1-Muito baixa">1-Muito baixa</option>
									<option value="2-Baixa">2-Baixa</option>
									<option value="3-Média">3-Média</option>
									<option value="4-Alta">4-Alta</option>
									<option value="5-Muito Alta">5-Muito Alta</option>
								</select>
							<p class="hint">[Informar Probabilidade.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Impacto <font color="red">*</font></b>
							<p align="justify">
								<select id="impacto" name="impacto" required="true">
									<option value="">......</option>
									<option value="1-Muito baixa">1-Muito baixa</option>
									<option value="2-Baixa">2-Baixa</option>
									<option value="3-Média">3-Média</option>
									<option value="4-Alta">4-Alta</option>
									<option value="5-Muito Alta">5-Muito Alta</option>
								</select>
							<p class="hint">[Informar Impacto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Descrição do Impacto <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="descricaoimpacto" name="descricaoimpacto" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,1500,'spcontando1');contarCaracteresEtapa3(this.value,1500,'sprestante1')"></textarea>
							<p class="hint">[Descrição do Impacto]</p>
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
								<b>Categoria <font color="red">*</font></b>
							<p align="justify">
								<select id="categoria" name="categoria" required="true">
									<option value="">......</option>
									<option value="Organizacional">Organizacional</option>
									<option value="Gestão do projeto">Gestão do projeto</option>
									<option value="Técnico">Técnico</option>
									<option value="Externo">Externo</option>
								</select>
							<p class="hint">[Informar Categoria.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Ação <font color="red">*</font></b>
							<p align="justify">
								<select id="acao" name="acao" required="true">
									<option value="">......</option>
									<option value="Prevenir">Prevenir</option>
									<option value="Mitigar">Mitigar</option>
									<option value="Transferir">Transferir</option>
									<option value="Assumir">Assumir</option>
								</select>
							<p class="hint">[Informar Ação.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Descrição da ação <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="descricaoacao" name="descricaoacao" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,1500,'spcontando2');contarCaracteresEtapa4(this.value,1500,'sprestante2')"></textarea>
							<p class="hint">[Descrição da ação.]</p>
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
						<td><p align="justify"><b>Responsável <font color="red">*</font></b></p>
						<p align="justify">
								<input id="responsavel" name="responsavel"
									style="height: 30px; width: 379px" maxlength="150"
									value="${registroRisco.responsavel}" class="input" required="true"></input>
							<p class="hint">[Informar Responsável.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>Previsão <font color="red">*</font></b></p>
						<p align="justify">
								<input id="previsao" name="previsao"
									style="height: 30px; width: 379px" maxlength="150"
									value="${registroRisco.previsao}" class="input" required="true"></input>
							<p class="hint">[Informar Previsão.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentários <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentario" name="comentario" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,1500,'spcontando3');contarCaracteresEtapa5(this.value,1500,'sprestante3')"></textarea>
							<p class="hint">[Comentários]</p>
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
	<%@ include file="rodape.jsp" %>
</body>
</html>
