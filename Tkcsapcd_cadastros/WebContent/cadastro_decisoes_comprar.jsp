<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.DecisoesComprar"%>
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

<title>Cadastrar Decisões de Comprar</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareDecisoesComprar.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarDecisoesComprar";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("decisoesComprar").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

	<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">DECISÕES DE COMPRAR</font></th></tr></table><br>				
				
								<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> Decisões de Comprar ou Mapa das aquisições. Lista contendo uma breve justificativa para as decisões.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Decisões de fazer ou comprar.</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	As decisões de fazer ou comprar documentam as conclusões obtidas em relação aos produtos, serviços ou resultados do projeto adquiridos fora da organização do projeto ou realizados internamente pela equipe do projeto.<br> 
				                    	Também podem incluir decisões de exigir apólices de seguros ou contratos de bônus de desempenho para abordar alguns dos riscos identificados.<br>
				                    	O documento das decisões de fazer ou comprar pode ser simples; por exemplo, apenas uma lista contendo uma breve justificativa para as decisões.<br><br>
										As decisões de fazer ou comprar contemplam 100% do escopo do projeto, dividindo os pacotes de trabalho da EAP em dois grupos:<br>
										
										O que será feito internamente;<br>
										O que será contratado.<br><br>
										
										Saída de: Planejar o gerenciamento das aquisições<br>
										Entrada para: Conduzir as aquisições<br>
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
				<input type="hidden" name="cmd" value="cadastrarDecisoesComprar"></input>
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
						<td><p align="justify">
								<b>Importância <font color="red">*</font></b></p>
						<p align="justify">
								<input id="importancia" name="importancia"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.importancia}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar Importância]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Código EAP <font color="red">*</font></b></p>
						<p align="justify">
								<input id="codigoeap" name="codigoeap"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.codigoeap}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Código usado na EAP (Estrutura analítica do projeto / WBS: Work Breakdown Structure)]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Item a ser adquirido <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="itens" name="itens" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,700,'spcontando0');contarCaracteresEtapa1(this.value,700,'sprestante0')"></textarea>
							<p class="hint">[Nome do item a ser adquirido. Um pacote de trabalho da EAP pode ter vários itens de aquisição.]</p>
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
								<b>Urgência <font color="red">*</font></b>
							<p align="justify">
								<select id="urgencia" name="urgencia" required="true">
									<option value="">......</option>
									<option value="1-Muito baixa">1-Muito baixa</option>
									<option value="2-Baixa">2-Baixa</option>
									<option value="3-Média">3-Média</option>
									<option value="4-Alta">4-Alta</option>
									<option value="5-Muito Alta">5-Muito Alta</option>
								</select>
							<p class="hint">[urgência da disponibilização da informação]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>impacto <font color="red">*</font></b>
							<p align="justify">
								<select id="impacto" name="impacto" required="true">
									<option value="">......</option>
									<option value="1-Muito baixa">1-Muito baixa</option>
									<option value="2-Baixa">2-Baixa</option>
									<option value="3-Média">3-Média</option>
									<option value="4-Alta">4-Alta</option>
									<option value="5-Muito Alta">5-Muito Alta</option>
								</select>
							<p class="hint">[Impacto da não entrega da informação]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Motivo da Decisão de Compra  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="motivodecisao" name="motivodecisao" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,700,'spcontando');contarCaracteresEtapa2(this.value,700,'sprestante')"></textarea>
							<p class="hint">[Motivo da Decisão de Compra.]</p>
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
								<b>Fornecedores potenciais <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="fornecedores" name="fornecedores" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,700,'spcontando1');contarCaracteresEtapa3(this.value,700,'sprestante1')"></textarea>
							<p class="hint">[Fornecedores potenciais.]</p>
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
								<b>Quantidade <font color="red">*</font></b></p>
						<p align="justify">
								<input id="quantidade" name="quantidade"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.quantidade}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a quantidade.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Custo <font color="red">*</font></b></p>
						<p align="justify">
								<input id="custo" name="custo"
									style="height: 30px; width: 300px"
									Placeholder=""
									value="${decisoesComprar.custo}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar o custo.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Previsão <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="previsao" name="previsao" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,700,'spcontando2');contarCaracteresEtapa4(this.value,700,'sprestante2')"></textarea>
							<p class="hint">[Previsão.]</p>
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
								<b>Doc Aquisição <font color="red">*</font></b>
						<p align="justify">
								<input id="docaquisicao" name="docaquisicao"
									style="height: 30px; width: 300px"
									value="${decisoesComprar.docaquisicao}" class="input" required="true"></input>
							<p class="hint">[Informar o Doc Aquisição.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Descrição <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="descricao" name="descricao" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,700,'spcontando3');contarCaracteresEtapa5(this.value,700,'sprestante3')"></textarea>
							<p class="hint">[Descrição do item. A coluna pode ser excluída ou referenciada quando o item estiver detalhado no doc. de aquisição]</p>
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
								<b>Tipo Contrato<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="tipocontrato" name="tipocontrato" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,700,'spcontando4');contarCaracteresEtapa6(this.value,700,'sprestante4')"></textarea>
							<p class="hint">[Tipo Contrato.]</p>
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
								<b>Status <font color="red">*</font></b>
							<p align="justify">
								<select id="status" name="status" required="true">
									<option value="">......</option>
									<option value="Ok">Ok</option>
									<option value="Pendente">Pendente</option>
									<option value="Em andamento">Em andamento</option>
								</select>
							<p class="hint">[Informar o status.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Comentários<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comentarios" name="comentarios" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,700,'spcontando5');contarCaracteresEtapa7(this.value,700,'sprestante5')"></textarea>
							<p class="hint">[Comentários.]</p>
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
						<th bgcolor="#F3F781"><br></th>
						<th bgcolor="#F3F781"></th>
					</tr>
				</table>
				<br>
				<br> <input class="prev acao" type="submit" value="Cadastrar" onclick="show_confirm();" onchange="validaCadastrarRiscos();"></input>
				<input class="prev acao" type="reset" value="Limpar"></input>
			</fieldset>
		</form>
	</div>
	<%@ include file="rodape.jsp" %>
</body>
</html>
