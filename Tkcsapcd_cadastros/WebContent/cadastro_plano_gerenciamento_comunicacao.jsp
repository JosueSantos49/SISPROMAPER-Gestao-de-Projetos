<!-- 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@page import="br.com.tkcsapcd.model.bean.ProjetoInicio"%>
<%@page import="br.com.tkcsapcd.model.dao.ProjetoInicioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao"%>
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

<title>Cadastrar Plano de Gerenciamento das Comunica��es</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareCadastroPlanoGereComunicacao.js"></script>
<script type="text/javascript" src="js/validaCadastrarRiscos.js"></script>
<style TYPE="text/css">
<!--
.input:focus {
	background-color: #E7E8E7;
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
			location.href = "TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("planogerenciamentoComunicacao").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">PLANO DE GERENCIAMENTO DAS COMUNICA��ES</font></th></tr></table><br>				
				
				<!-- Modal explicando o objetivo da transa��o -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> O plano de gerenciamento das comunica��es descreve como os processos de comunica��o ser�o gerenciados desde a identifica��o das partes interessadas at� o encerramento do projeto.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				                    <h2 class="modal-title">Plano de Gerenciamento das Comunica��es</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	O Plano de Gerenciamento das Comunica��es � um componente do plano de gerenciamento do projeto baseado nas necessidades de comunica��o do projeto.<br><br>
				                    	Deve ser de f�cil entendimento e pode incluir, entre outros:
										-Requisitos de comunica��o dos stakeholders<br>
										-Relat�rio/Informa��o (formato, conte�do, n�vel de detalhe, modelo)<br>
										-Prop�sito<br>
										-Respons�vel<br>
										-Destinat�rios<br>
										-Meios de comunica��o ou tecnologia<br>
										-Frequ�ncia<br>
										-Crit�rio para escala��o<br>
										-M�todo para atualiza��o do plano<br>
										-Gloss�rio do projeto<br>
										-Modelos e diretrizes para reuni�es, e-mail, etc.
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
				<br> 
				<input type="hidden" name="cmd" value="cadastrarPlanoGerenciamentoComunicacao"></input>
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
						<td><p align="justify"><b>Plano de Gerenciamento da Comunica��o <font color="red">*</font></b></p>
						<p align="justify">
								<input id="planogerenciamentocomunicacao" name="planogerenciamentocomunicacao"
									style="height: 30px; width: 379px" maxlength="150"
									value="${planoGerenciamentoComunicacao.planogerenciamentocomunicacao}" class="input" required="true"></input>
							<p class="hint">[Informar o Plano de Gerenciamento da Comunicacao.]</p></td>
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
									value="${planoGerenciamentoComunicacao.projeto}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Nome do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>C�digo do Projeto <font color="red">*</font></b></p>
						<p align="justify">
									<input id="codigoprojeto" name="codigoprojeto"
									style="height: 30px; width: 300px"
									Placeholder=""
									class="input" required="true"
									onkeypress="return numbers(event);"></input>
						
							<p class="hint">[Informar o c�digo do Projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Vers�o <font color="red">*</font></b>
						<p align="justify">
								<input id="versao" name="versao"
									style="height: 30px; width: 100px"
									value="${planoGerenciamentoComunicacao.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a vers�o.]</p>
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
									value="${planoGerenciamentoComunicacao.data}" class="input" required="true"
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
									value="${planoGerenciamentoComunicacao.autor}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o autor]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Notas de revis�o <font color="red">*</font></b></p>
						<p align="justify">
								<input id="notarevisao" name="notarevisao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${planoGerenciamentoComunicacao.notarevisao}" class="input" required="true"></input>
							<p class="hint">[Informar Notas de revis�o.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>1	Objetivo do Plano de gerenciamento das comunica��es <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="objetivo" name="objetivo" required="true"
								onkeyup="mostrarResultadoEtapa1(this.value,400,'spcontando0');contarCaracteresEtapa1(this.value,400,'sprestante0')"></textarea>
							<p class="hint">[Descreva o objetivo do Plano de gerenciamento das comunica��es]</p>
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
								<b>2	Processos do Gerenciamento das Comunica��es  <font color="red">*</font></b>
						<p align="justify">
							<font color="blue"></font>
							</p> <textarea id="processo" name="processo" required="true"
								onkeyup="mostrarResultadoEtapa2(this.value,400,'spcontando');contarCaracteresEtapa2(this.value,400,'sprestante')"></textarea>
							<p class="hint">[Planejar o gerenciamento das comunica��es, Gerenciar as comunica��es e Controlar as comunica��es.]</p>
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
								<b>3.1	Requisitos de comunica��o das partes interessadas <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="requisito" name="requisito" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,400,'spcontando1');contarCaracteresEtapa3(this.value,400,'sprestante1')"></textarea>
							<p class="hint">[Defina os requisitos de comunica��o das partes interessadas individualmente e/ou por grupo. Exemplo:Os requisitos de comunica��es est�o documentados no Registro das partes interessadas em anexo.]</p>
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
								<b>3.2	Informa��es a serem comunicadas <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="informcacao" name="informcacao" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,400,'spcontando2');contarCaracteresEtapa4(this.value,400,'sprestante2')"></textarea>
							<p class="hint">[Determine como as informa��es do projeto ser�o geradas, coletadas, distribu�das, armazenadas, recuperadas e organizadas de maneira oportuna e apropriada. Exemplo: As informa��es a serem disponibilizadas est�o detalhadas na Matriz de Comunica��o em anexo.]</p>
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
								<b>3.3	Tecnologias e Ferramentas usados para comunicar <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="tecnologia" name="tecnologia" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,400,'spcontando3');contarCaracteresEtapa5(this.value,400,'sprestante3')"></textarea>
							<p class="hint">[Determine as tecnologias e as ferramentas usadas para comunicar. Descreva como ser�o usadas. ]</p>
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
								<b>4	Diretrizes e procedimentos usados para comunicar<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="diretrize" name="diretrize" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,400,'spcontando4');contarCaracteresEtapa6(this.value,400,'sprestante4')"></textarea>
							<p class="hint">[Quando existirem diretrizes e procedimentos espec�ficos para comunicar, descreva-os.</p>
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
								<b>4.1	Comunica��o geral <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="comunicacao" name="comunicacao" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,400,'spcontando5');contarCaracteresEtapa7(this.value,400,'sprestante5')"></textarea>
							<p class="hint">[Todos os procedimentos relacionados a comunica��o devem seguir as pol�ticas e procedimentos adotados pela empresa e pelo seu Escrit�rio de Projetos.]</p>
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
					<tr class="field">
						<td><p align="justify">
								<b>4.2	Gest�o de mudan�a de Escopo <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="gestao" name="gestao" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,400,'spcontando6');contarCaracteresEtapa8(this.value,400,'sprestante6')"></textarea>
							<p class="hint">[Toda mudan�a dever� ser solicitada atrav�s do formul�rio e enviada ao Gerente de Projeto por e-mail, o Gerente de Projeto far� sua avalia��o, incluir� no Log de Mudan�as e encaminhar� para aprova��o do patrocinador do projeto. O Log de Mudan�as ficar� na pasta do projeto e conter� todas as solicita��es com seu status atualizado, mesmo que ela seja rejeitada.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando6"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante6"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>4.3	Status Report / Relat�rios de desempenho<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="status" name="status" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,400,'spcontando7');contarCaracteresEtapa9(this.value,400,'sprestante7')"></textarea>
							<p class="hint">[Exemplo: Atividades Conclu�das no per�odo; Atividades em andamento; Atividades iniciando no pr�ximo per�odo; Pontos de Aten��o; Os seguintes documentos podem ser anexados ao Status Report; Planos de recupera��o para atividades com atraso; Planos de a��o corretiva para problemas esperados; Resolu��o para itens de a��o associados e Issues Log.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando7"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante7"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>4.4	Ger�ncia de reuni�es<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="gerenciareunioes" name="gerenciareunioes" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,400,'spcontando8');contarCaracteresEtapa10(this.value,400,'sprestante8')"></textarea>
							<p class="hint">[Toda reuni�o do projeto dever� ser planejada, executada e monitorada seguindo as boas pr�ticas .]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando8"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante8"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>4.5	Ger�ncia de quest�es e problemas <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="gerenciaquestoes" name="gerenciaquestoes" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,400,'spcontando9');contarCaracteresEtapa11(this.value,400,'sprestante9')"></textarea>
							<p class="hint">[O gerente de projeto (GP) deve registrar todas as quest�es e problemas ocorridos no projeto no registro das quest�es, mais conhecido pelo termo em ingl�s, Issues Log. O GP usa o Issues Log para documentar e monitorar sua solu��o, e deve, inicialmente, definir e classificar as quest�es com base na urg�ncia e no impacto potencial.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando9"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante9"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>4.6	Plano de Escalonamento <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="planoescalonamento" name="planoescalonamento" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,400,'spcontando10');contarCaracteresEtapa12(this.value,400,'sprestante10')"></textarea>
							<p class="hint">[Criado para agilizar as decis�es determinando n�veis de al�ada dentro da hierarquia do projeto e de determinados assuntos espec�ficos. O Plano de escalonamento tamb�m � usado para reunir agilmente as pessoas envolvidas na tomada de decis�o. O gerente de projeto � o respons�vel por acionar os envolvidos para solucionar as quest�es.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando10"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante10"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>5	Eventos da comunica��o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="eventocomunicacao" name="eventocomunicacao" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,400,'spcontando14');contarCaracteresEtapa16(this.value,400,'sprestante14')"></textarea>
							<p class="hint">[Descreva os principais eventos de comunica��o do projeto. Caso eles j� estiverem detalhados na matriz de comunica��o, exclua a se��o ou redunde caso queira enfatiz�-los. Para um melhor detalhamento incluir um cronograma com os eventos da comunica��o. ]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando14"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante14"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>6	Anexos <font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="anexo" name="anexo" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,400,'spcontando15');contarCaracteresEtapa17(this.value,400,'sprestante15')"></textarea>
							<p class="hint">[Matriz de Comunica��o, Templates usados de acordo com a matriz de comunica��o, Templates de e-mails e Gloss�rio do Projeto.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando15"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante15"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprova��o<font color="red">*</font></b>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="aprovacao" name="aprovacao" required="true"
								onkeyup="mostrarResultadoEtapa19(this.value,400,'spcontando17');contarCaracteresEtapa19(this.value,400,'sprestante17')"></textarea>
							<p class="hint">[Participantes, datas, etc.]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando17"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante17"
									style="font-family: Arial;"></span></font>
							</h5></td>
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
