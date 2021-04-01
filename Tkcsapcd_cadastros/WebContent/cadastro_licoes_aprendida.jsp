<!-- 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,br.com.tkcsapcd.model.bean.LicoesAprendida"%>
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

<title>Cadastrar Lições Aprendidas</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilos.css">

<link href="css/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/menuperante.css" type="text/css">
<script language="javascript" src="js/funcoes.js"></script>
<%@include file="includedialogo.jsp"%><!-- / Dialogo -->
<%@include file="includemascara.jsp"%><!-- / Macara -->
<script language="javascript" src="js/TexteareaLicoesAprendida.js"></script>
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
			location.href = "TkcsapcdController?cmd=consultarLicoesAprendida";

		}
	}
</script>

<script type="text/javascript">
	function setFocus() {
		document.getElementById("empresa").focus();
	}
</script>

</head>

<body onload="waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 2000); tamanhooriginal(); setFocus();">

<%@include file="menuperantecssadm.jsp"%>

	<div align="center">

		<form action="TkcsapcdController" id="formulario" name="formulario"	onsubmit="validaCadastrarRiscos()">

			<fieldset>
				<table width="100%" class="table table-striped"><tr class="success"><th bgcolor="#FFFF00"><font size="3">LIÇÕES APRENDIDAS</font></th></tr></table><br>				
				
								<!-- Modal explicando o objetivo da transação -->
				<div class="bs-example">
				    <div class="alert alert-info fade in">
				        <a href="#" class="close" data-dismiss="alert">&times;</a>
				        <strong>Nota!</strong> As lições aprendidas no projeto tem como objetivo principal evitar que os erros e os problemas encontrados não se repitam em futuros projetos, além de servir de base para o aperfeiçoamento contínuo da metodologia de Gerenciamento de Projetos.
				    </div>
				    
				    <!-- Button HTML (to Trigger Modal) -->
				    <input type="button" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary" value="Clique aqui!">
				    
				    <!-- Modal HTML -->
				    <div id="myModal" class="modal fade">
				        <div class="modal-dialog">
				            <div class="modal-content">
				                <div class="modal-header">
				                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				                    <h2 class="modal-title">Lições aprendidas</h2>
				                </div>
				                <div class="modal-body">
				                    <p><button type="button" class="btn btn-link show-text">Clique aqui para carregar lotes de texto.</button></p>
				                    <div class="lots-of-text" align="left">
				                    	As Lições Aprendidas são bases, para a qualidade e melhoria contínua. As lições aprendidas é a base para alcançarmos a perfeição ou o nível de excelência desejado, é o alicerce para o aperfeiçoamento contínuo.<br>
										Só podemos ser melhores se aprendemos com nossos erros e nossos acertos. Mais importante do que inovar é aprender com os erros e acertos da inovação.<br>
										
										As lições aprendidas podem ser informais ou formais, documentadas ou apenas discutidas, feitas em grupo ou até individualmente, em uma reunião ou informalmente em um happy-hour ou no café. <br>
										
										Ainda muito pouco usadas nas organizações, principalmente, pela falta de tempo e ainda baixa preocupação em documentar o aprendizado.<br>
										
										Caso sua organização não tenha esse excelente hábito, sugiro adotá-lo mesmo que faça o registro das lições aprendidas com poucos colegas ou até sozinho.<br>
										
										Importante é garantir que você aprende com cada projeto e tornar-se uma pessoa melhor.<br><br>
										
										Elas podem conter várias informações. Abaixo destacamos alguns dos tópicos mais comuns a serem discutidos e documentados:<br>
										
										Principais problemas enfrentados no projeto; Recomendações para melhoria futura; Análise das variações do projeto.
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
				<br> <input type="hidden" name="cmd" value="cadastrarLicoesAprendida"></input>
				<table border="0" cellspacing="3" cellpadding="3" width="90%"	bgcolor="#FFFFFF">
					<tr>
						<td><p><font color="red">Campos de (*) obrigatório.</font></p><br></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Empresa <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="empresa" name="empresa"
									style="height: 30px; width: 379px" maxlength="150"
									value="${licoesAprendida.empresa}" class="input" required="true"
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
							</p><p align="justify">
								<input id="orgao" name="orgao"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${licoesAprendida.orgao}" class="input" required="true"
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
							</p>
						<p align="justify">
								<input id="setor" name="setor"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${licoesAprendida.setor}" class="input" required="true"
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
							</p>
						<p align="justify">
								<input id="programa" name="programa"
									style="height: 30px; width: 379px"
									Placeholder="" 
									value="${licoesAprendida.programa}" class="input" required="true"
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
							</p>
						<p align="justify">
								<select id="codigoprojeto"	name="codigoprojeto">
								<option id="codigoprojeto">	</option>
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
					<tr class="field">
						<td><p align="justify">
								<b>Nome do Projeto <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="projeto" name="projeto"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${licoesAprendida.projeto}" class="input" required="true"
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
							</p>
						<p align="justify">
								<input id="gerente" name="gerente"
									style="height: 30px; width: 379px"
									Placeholder=""
									value="${licoesAprendida.gerente}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar o Gerente do projeto.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Requerido por: <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="funcao" name="funcao"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${licoesAprendida.funcao}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar nome e função.]</p></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Aprovado por: <font color="red">*</font></b>
							</p>
						<p align="justify">
								<input id="aprovado" name="aprovado"
									style="height: 30px; width: 379px"
									Placeholder="Digitar nome completo!"
									value="${licoesAprendida.aprovado}" class="input" required="true"
									onkeypress="return Letras(event);"></input>
							<p class="hint">[Informar nome e função.]</p></td>
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
									value="${licoesAprendida.versao}" class="input" required="true"></input>
							<p class="hint">[Informar a versão.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>Data da Aprovação: <font color="red">*</font></b>
						<p align="justify">
								<input id="dataaprovacao" name="dataaprovacao"
									style="height: 30px; width: 100px"
									value="${licoesAprendida.dataaprovacao}" class="input" required="true"
									onkeypress="return numbers(event);"></input>
							<p class="hint">[Informar a Data da Aprovação.]</p>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify"><b>1.  Os produtos entregues correspondem aos descritos na proposta executiva? <font color="red">*</font></b><br>
						<p align="justify">	<font color="blue"></font></p>
							<textarea id="pergunta1" name="pergunta1" required="true" onkeyup="mostrarResultadoEtapa1(this.value,300,'spcontando0');contarCaracteresEtapa1(this.value,300,'sprestante0')"></textarea>
							<p class="hint">[Os produtos entregues correspondem aos descritos na proposta executiva?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando0" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante0" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>2.  Foi elaborado um relatório de auditoria final dos resultados? <font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta2" name="pergunta2" required="true" onkeyup="mostrarResultadoEtapa2(this.value,300,'spcontando');contarCaracteresEtapa2(this.value,300,'sprestante')"></textarea>
							<p class="hint">[Foi elaborado um relatório de auditoria final dos resultados?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestante" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>3.  Houve desvios entre os prazos realizados e programados (baseline)? <font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta3" name="pergunta3" required="true"
								onkeyup="mostrarResultadoEtapa3(this.value,300,'spcontando1');contarCaracteresEtapa3(this.value,300,'sprestante1')"></textarea>
							<p class="hint">[Houve desvios entre os prazos realizados e programados (baseline)?]</p>
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
								<b>4.  Houve desvios entre os custos efetivos e os orçados (baseline)?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta4" name="pergunta4" required="true"
								onkeyup="mostrarResultadoEtapa4(this.value,300,'spcontando2');contarCaracteresEtapa4(this.value,300,'sprestante2')"></textarea>
							<p class="hint">[Houve desvios entre os custos efetivos e os orçados (baseline)?]</p>
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
								<b>5. Os desvios poderiam ter sido evitados?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta5" name="pergunta5" required="true"
								onkeyup="mostrarResultadoEtapa5(this.value,300,'spcontando3');contarCaracteresEtapa5(this.value,300,'sprestante3')"></textarea>
							<p class="hint">[Os desvios poderiam ter sido evitados?]</p>
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
								<b>6.  Ocorreram riscos não previstos?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta6" name="pergunta6" required="true"
								onkeyup="mostrarResultadoEtapa6(this.value,300,'spcontando4');contarCaracteresEtapa6(this.value,300,'sprestante4')"></textarea>
							<p class="hint">[Ocorreram riscos não previstos?]</p>
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
								<b>7.  Os clientes/usuários estão satisfeitos? <font color="red">*</font></b><br>
							<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta7" name="pergunta7" required="true"
								onkeyup="mostrarResultadoEtapa7(this.value,300,'spcontando5');contarCaracteresEtapa7(this.value,300,'sprestante5')"></textarea>
							<p class="hint">[Os clientes/usuários estão satisfeitos?]</p>
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
								<b>8.  A equipe ficou satisfeita com o apoio dos patrocinadores?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta8" name="pergunta8" required="true"
								onkeyup="mostrarResultadoEtapa8(this.value,300,'spcontando6');contarCaracteresEtapa8(this.value,300,'sprestante6')"></textarea>
							<p class="hint">[A equipe ficou satisfeita com o apoio dos patrocinadores?]</p>
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
								<b>9.  Houve cooperação e comprometimento das pessoas?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta9" name="pergunta9" required="true"
								onkeyup="mostrarResultadoEtapa9(this.value,300,'spcontando7');contarCaracteresEtapa9(this.value,300,'sprestante7')"></textarea>
							<p class="hint">[Houve cooperação e comprometimento das pessoas?]</p>
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
								<b>10. O projeto foi bem administrado?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta10" name="pergunta10" required="true"
								onkeyup="mostrarResultadoEtapa10(this.value,300,'spcontando8');contarCaracteresEtapa10(this.value,300,'sprestante8')"></textarea>
							<p class="hint">[O projeto foi bem administrado?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando8"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante8"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>11. Houve problemas de comunicação?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta11" name="pergunta11" required="true"
								onkeyup="mostrarResultadoEtapa11(this.value,300,'spcontando9');contarCaracteresEtapa11(this.value,300,'sprestante9')"></textarea>
							<p class="hint">[Houve problemas de comunicação?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando9"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante9"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>12. O projeto foi bem documentado?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta12" name="pergunta12" required="true"
								onkeyup="mostrarResultadoEtapa12(this.value,300,'spcontando10');contarCaracteresEtapa12(this.value,300,'sprestante10')"></textarea>
							<p class="hint">[O projeto foi bem documentado?]</p>
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
								<b>13. Os fornecedores entregaram seus produtos/serviços em conformidade com as especificações combinadas?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta13" name="pergunta13" required="true"
								onkeyup="mostrarResultadoEtapa13(this.value,300,'spcontando11');contarCaracteresEtapa13(this.value,300,'sprestante11')"></textarea>
							<p class="hint">[Os fornecedores entregaram seus produtos/serviços em conformidade com as especificações combinadas?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando11"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante11"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>14. O que faríamos da mesma forma? <font color="red">*</font></b><br>
							<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta14" name="pergunta14" required="true"
								onkeyup="mostrarResultadoEtapa14(this.value,300,'spcontando12');contarCaracteresEtapa14(this.value,300,'sprestante12')"></textarea>
							<p class="hint">[O que faríamos da mesma forma?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando12"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante12"
									style="font-family: Arial;"></span></font>
							</h5></td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>15. O que faríamos de maneira diferente?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta15" name="pergunta15" required="true" onkeyup="mostrarResultadoEtapa15(this.value,300,'spcontando13');contarCaracteresEtapa15(this.value,300,'sprestant13')"></textarea>
							<p class="hint">[O que faríamos de maneira diferente?]</p>
							<br><br>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="spcontando13" style="font-family: Arial;"></span></font></h5>
							<h5 align="left"><font size="1" color="#6C7B8B"><span id="sprestant13" style="font-family: Arial;"></span></font></h5>
						</td>
					</tr>
					<tr>
						<td><br></td>
						<td><br></td>
					</tr>
					<tr class="field">
						<td><p align="justify">
								<b>16. O que sabemos hoje, e que não sabíamos antes do projeto?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta16" name="pergunta16" required="true"
								onkeyup="mostrarResultadoEtapa16(this.value,300,'spcontando14');contarCaracteresEtapa16(this.value,300,'sprestante14')"></textarea>
							<p class="hint">[O que sabemos hoje, e que não sabíamos antes do projeto?]</p>
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
								<b>17. Que recomendações devemos incluir para melhorar os próximos projetos?<font color="red">*</font></b><br>
						<p align="justify">
								<font color="blue"></font>
							</p> <textarea id="pergunta17" name="pergunta17" required="true"
								onkeyup="mostrarResultadoEtapa17(this.value,300,'spcontando15');contarCaracteresEtapa17(this.value,300,'sprestante15')"></textarea>
							<p class="hint">[Que recomendações devemos incluir para melhorar os próximos projetos?]</p>
							<br>
						<br>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="spcontando15"
									style="font-family: Arial;"></span></font>
							</h5>
							<h5 align="left">
								<font size="1" color="#6C7B8B"><span id="sprestante15"
									style="font-family: Arial;"></span></font>
							</h5>
						</td>
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
